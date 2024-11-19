package br.edu.fesa.TotalMedia.model;

import br.edu.fesa.TotalMedia.enumerator.UserGender;
import br.edu.fesa.TotalMedia.enumerator.UserRole;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_USER", schema = "TOTALMEDIA")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_USER")
  private int id;

  @Column(name = "NAME", nullable = false, length = 100)
  private String name;

  @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
  private String email;

  @Column(name = "REGISTRATION_DATE", nullable = false)
  private LocalDateTime registrationDate;

  @Column(name = "PASSWORD", nullable = false, length = 255)
  private String password;

  @Column(name = "SECRET", nullable = true, length = 64)
  private String secret;

  @Enumerated(EnumType.STRING)
  @Column(name = "USER_ROLE", nullable = false)
  private UserRole userRole;

  @Enumerated(EnumType.STRING)
  @Column(name = "USER_GENDER", nullable = false)
  private UserGender userGender;

  // Novos atributos
  @Column(name = "IMAGE", nullable = true)
  private String image; // Para armazenar o caminho ou URL da imagem do usuário

  @Column(name = "IS_USING_2FA", nullable = true)
  private boolean isUsing2FA = false; // Para indicar se o usuário está usando 2FA

  // Adicionando os novos campos
  @Column(name = "BIO", nullable = true, length = 500)
  private String bio; // Para armazenar a biografia do usuário

  @Column(name = "ACTIVE", nullable = true)
  private boolean active = true; // Para indicar se o usuário está ativo ou não

  public User() {}

  public User(
      String name,
      String email,
      LocalDateTime registrationDate,
      String password,
      String secret,
      UserRole userRole,
      UserGender userGender,
      String image,
      boolean isUsing2FA,
      String bio,
      boolean active) {
    this.name = name;
    this.email = email;
    this.registrationDate = registrationDate;
    this.password = password;
    this.secret = secret;
    this.userRole = userRole;
    this.userGender = userGender;
    this.image = image;
    this.isUsing2FA = isUsing2FA;
    this.bio = bio;
    this.active = active;
  }

  public User(
      int id,
      String name,
      String email,
      LocalDateTime registrationDate,
      String password,
      String secret,
      UserRole userRole,
      UserGender userGender,
      String image,
      boolean isUsing2FA,
      String bio,
      boolean active) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.registrationDate = registrationDate;
    this.password = password;
    this.secret = secret;
    this.userRole = userRole;
    this.userGender = userGender;
    this.image = image;
    this.isUsing2FA = isUsing2FA;
    this.bio = bio;
    this.active = active;
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDateTime getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(LocalDateTime registrationDate) {
    this.registrationDate = registrationDate;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public UserRole getUserRole() {
    return userRole;
  }

  public void setUserRole(UserRole userRole) {
    this.userRole = userRole;
  }

  public UserGender getUserGender() {
    return userGender;
  }

  public void setUserGender(UserGender userGender) {
    this.userGender = userGender;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public boolean getIsUsing2FA() {
    return isUsing2FA;
  }

  public void setIsUsing2FA(boolean isUsing2FA) {
    this.isUsing2FA = isUsing2FA;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public boolean getActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}