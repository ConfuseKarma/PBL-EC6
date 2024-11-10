package br.edu.fesa.TotalMedia.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
  private String email; 
  private String password;
  private String name;
  private String image;
  private boolean isUsing2FA;
  private String bio; // Adicionando o campo bio
  private boolean active; // Adicionando o campo active

  private Boolean enabled;
  private Boolean accountNonExpired;
  private Boolean accountNonLocked;
  private boolean credentialsNonExpired;

  private final Collection<? extends GrantedAuthority> authorities;

  public CustomUserDetails(
      String email,
      String password,
      String name,
      String image,
      Boolean enabled,
      boolean isUsing2FA,
      String bio,
      boolean active,
      Collection<? extends GrantedAuthority> authorities) {
    this.email = email;
    this.password = password;
    this.name = name;
    this.image = image;
    this.enabled = enabled;
    this.isUsing2FA = isUsing2FA;
    this.bio = bio; // Inicializando bio
    this.active = active; // Inicializando active
    this.accountNonExpired = true;
    this.accountNonLocked = true;
    this.credentialsNonExpired = true;
    this.authorities = authorities;
  }

  public String getImage() {
    return image;
  }

  public boolean isUsing2FA() {
    return isUsing2FA;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getUsername() {
    return name;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  // Novos getters e setters para os campos adicionados
  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public void eraseCredentials() {
    this.password = null;
  }
}
