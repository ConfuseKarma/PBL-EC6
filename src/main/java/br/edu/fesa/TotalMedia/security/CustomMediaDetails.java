package br.edu.fesa.TotalMedia.security;

import br.edu.fesa.TotalMedia.model.Media;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomMediaDetails implements UserDetails {
    private String title;
    private String subtitle;
    private String genre;
    private String director;
    private boolean isPublic; // Para verificar se a mídia é pública
    private boolean active; // Indica se a mídia está ativa
    private Collection<? extends GrantedAuthority> authorities;

    public CustomMediaDetails(
        String title,
        String subtitle,
        String genre,
        String director,
        boolean isPublic,
        boolean active,
        Collection<? extends GrantedAuthority> authorities) {
        
        this.title = title;
        this.subtitle = subtitle;
        this.genre = genre;
        this.director = director;
        this.isPublic = isPublic;
        this.active = active;
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return title; // Pode ser o título da mídia
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null; // Não aplicável para 'Media', já que não tem senha
    }

    @Override
    public boolean isAccountNonExpired() {
        return active; // Verifica se a mídia está ativa
    }

    @Override
    public boolean isAccountNonLocked() {
        return active; // A mídia está "desbloqueada" se for ativa
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Não aplica no contexto de 'Media'
    }

    @Override
    public boolean isEnabled() {
        return isPublic; // A mídia pode ser "habilitada" se for pública
    }

    // Getters para os campos de 'Media'
    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public boolean isActive() {
        return active;
    }
}
