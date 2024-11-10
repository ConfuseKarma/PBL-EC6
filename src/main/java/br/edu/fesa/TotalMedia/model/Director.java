package br.edu.fesa.TotalMedia.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "TB_DIRECTOR", schema = "TOTALMEDIA")
public class Director implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_DIRECTOR")
  private int id;

  @Column(name = "NAME", nullable = false, length = 100)
  private String name;

  @Column(name = "COUNTRY", nullable = false, length = 50)
  private String country;

  @Column(name = "BIRTH_DATE", nullable = false)
  private LocalDateTime birthDate;
  
   @Column(name = "IMAGE", nullable = true)
  private String image; // Para armazenar o caminho ou URL da imagem do diretor

  public Director() {}

  public Director(String name, String country, LocalDateTime birthDate) {
    this.name = name;
    this.country = country;
    this.birthDate = birthDate;
    this.image = image;
  }

  public Director(int id, String name, String country, LocalDateTime birthDate) {
    this.id = id;
    this.name = name;
    this.country = country;
    this.birthDate = birthDate;
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

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public LocalDateTime getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDateTime birthDate) {
    this.birthDate = birthDate;
  }
  
    public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
