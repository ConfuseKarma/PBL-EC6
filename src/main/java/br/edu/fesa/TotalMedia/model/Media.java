package br.edu.fesa.TotalMedia.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_BOOK", schema = "TOTALMEDIA")
public class Media implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_MEDIA")
  private int id;

  @Column(name = "TITLE", nullable = false, length = 255)
  private String title;
  
  @Column(name = "SUBTITLE", nullable = true, length = 255)
  private String subtitle;

  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_GENRE", referencedColumnName = "ID_GENRE")
  private Genre genre;

  @Column(name = "RELEASE_DATE", nullable = false)
  private LocalDateTime releaseDate;

  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_DIRECTOR", referencedColumnName = "ID_DIRECTOR")
  private Director director;

  @Column(name = "IMAGE", nullable = true)
  private String image;

  @Column(name = "RATING", nullable = true, length = 10)
  private String rating;

  @Column(name = "SYNOPSIS", nullable = true, length = 500)
  private String synopsis;

  @Column(name = "YEAR", nullable = true)
  private Integer year;

  @Column(name = "PRODUCTION_COMPANY", nullable = true, length = 255)
  private String productionCompany;

  public Media() {}

  public Media(
      String title,
      String subtitle,
      Genre genre,
      LocalDateTime releaseDate,
      Director director,
      String image,
      String rating,
      String synopsis,
      Integer year,
      String productionCompany) {
    this.title = title;
    this.subtitle = subtitle;
    this.genre = genre;
    this.releaseDate = releaseDate;
    this.director = director;
    this.image = image;
    this.rating = rating;
    this.synopsis = synopsis;
    this.year = year;
    this.productionCompany = productionCompany;
  }

  public Media(
      int id,
      String title,
      String subtitle,
      Genre genre,
      LocalDateTime releaseDate,
      Director director,
      String image,
      String rating,
      String synopsis,
      Integer year,
      String productionCompany) {
    this.id = id;
    this.title = title;
    this.subtitle = subtitle;
    this.genre = genre;
    this.releaseDate = releaseDate;
    this.director = director;
    this.image = image;
    this.rating = rating;
    this.synopsis = synopsis;
    this.year = year;
    this.productionCompany = productionCompany;
  }

  // Getters e Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public LocalDateTime getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(LocalDateTime releaseDate) {
    this.releaseDate = releaseDate;
  }

  public Director getDirector() {
    return director;
  }

  public void setDirector(Director director) {
    this.director = director;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getProductionCompany() {
    return productionCompany;
  }

  public void setProductionCompany(String productionCompany) {
    this.productionCompany = productionCompany;
  }
}
