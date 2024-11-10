package br.edu.fesa.TotalMedia.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TB_GENRE", schema = "TOTALMEDIA")
public class Genre implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_GENRE")
  private int id;

  @Column(name = "DESCRIPTION", nullable = false, length = 255)
  private String description;

  public Genre() {}

  public Genre(String description) {
    this.description = description;
  }

  public Genre(int id, String description) {
    this.id = id;
    this.description = description;
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}