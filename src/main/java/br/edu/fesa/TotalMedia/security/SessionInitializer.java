package br.edu.fesa.TotalMedia.security;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component
public class SessionInitializer {

  @ModelAttribute
  public void addRoleToSession(HttpSession session) {
    // Obtém a autenticação atual
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    // Verifica se a autenticação existe e está autenticada
    if (authentication != null && authentication.isAuthenticated()) {
      Object principal = authentication.getPrincipal();

      if (principal instanceof CustomUserDetails) {
        CustomUserDetails userDetails = (CustomUserDetails) principal;

        // Obtém a primeira role do usuário (se houver) e a adiciona à sessão
        userDetails.getAuthorities().stream()
            .findFirst()
            .ifPresent(authority -> session.setAttribute("ROLE", authority.getAuthority()));
      }
    }
  }
}
