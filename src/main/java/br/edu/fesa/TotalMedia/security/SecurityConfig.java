package br.edu.fesa.TotalMedia.security;

import br.edu.fesa.TotalMedia.model.User;
import br.edu.fesa.TotalMedia.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired private UserRepository userRepository;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            
            (requests) ->
                requests
                    .requestMatchers("/","/index", "/home", "/layout", "/users/create", "/css/**", "/images/**")
                    .permitAll() // Todos os usuários podem acessar
                    .requestMatchers("/admin/**")
                    .hasRole("ADMIN") // Somente usuários com a role "ADMIN" podem acessar /admin/**
                    .requestMatchers("/critic/**")
                    .hasAnyRole(
                        "ADMIN",
                        "CRITIC") // Somente usuários com "ADMIN" ou "LIBRARIAN" podem acessar
                                     // /critic/**
                    .anyRequest()
                    .authenticated())
            
        .formLogin(
            (form) ->
                form.loginPage("/login") // Esta é a URL que o Spring Security usa para login
                    .defaultSuccessUrl("/home", true) // Redireciona após o login
                    .successHandler(new CustomSuccessHandler()) // Adiciona o handler personalizado
                    .permitAll())
            
        .logout(
            (logout) ->
                logout
                    .logoutUrl("/logout") // Esta é a URL que o Spring Security usa para logout
                    .logoutSuccessUrl("/home") // Redireciona após o logout
                    .invalidateHttpSession(true) // Invalida a sessão
                    .deleteCookies("JSESSIONID") // Remove o cookie de sessão
                    .permitAll())
            
        .sessionManagement(
            (session) ->
                session
                    .maximumSessions(1) // Limita a uma sessão por usuário
                    .maxSessionsPreventsLogin(true) // Evita que o usuário faça login
            // novamente se já tiver uma sessão ativa
            )
            
        //.exceptionHandling()
        //.accessDeniedHandler(
        //    (request, response, accessDeniedException) -> {
        //      response.sendRedirect("/access-denied");
        //    })
        ;
    
    return http.build();
  }

  @Bean
public UserDetailsService userDetailsService() {
    return username -> {
        // Buscando o usuário pelo email
        User user = userRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Retornando um novo CustomUserDetails, incluindo bio e active
        return new CustomUserDetails(
                user.getEmail(),
                user.getPassword(),
                user.getName(),
                user.getImage(),
                user.getActive(), // Atribuindo o valor do campo 'active' do User
                user.getIsUsing2FA(),
                user.getBio(), // Atribuindo o valor de bio
                user.getActive(), // Repassando o 'active' para o CustomUserDetails
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getUserRole().name())) // Adicionando o papel do usuário
        );
    };
}

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response,
                          Authentication authentication) throws IOException, ServletException {
        String role = authentication.getAuthorities().stream()
            .findFirst()
            .map(GrantedAuthority::getAuthority)
            .orElse("ROLE_USER");

        String redirectUrl;

        switch (role) {
            case "ROLE_ADMIN":
                redirectUrl = "/admin/menu";
                break;
            case "ROLE_CRITIC":
                redirectUrl = "/critic/menu";
                break;
            default:
                redirectUrl = "/home";
        }

        response.sendRedirect(redirectUrl);
    }
}


  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
