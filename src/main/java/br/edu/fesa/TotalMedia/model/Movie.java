/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.TotalMedia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author user
 */
@Entity
@Table(name = "TB_MOVIE", schema = "TOTALMEDIA")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FILME")
    private Integer id;

    @Column(name = "TITLE", nullable = false, length = 255)
    private String title;

    @Column(name = "SUBTITLE", nullable = true, length = 255)
    private String subtitle;

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

    @Column(name = "RELEASE_YEAR", nullable = true)
    private Integer releaseYear;

    @Column(name = "PRODUCTION_COMPANY", nullable = true, length = 255)
    private String productionCompany;

    @Column(name = "DURATION_MINUTES", nullable = false)
    private int durationMinutes;

    @Column(name = "LANGUAGE", nullable = false, length = 50)
    private String language;
    
    // Construtor padrão
    public Movie() {}

    // Construtor completo
    public Movie(
            String title,
            String subtitle,
            LocalDateTime releaseDate,
            Director director,
            String image,
            String rating,
            String synopsis,
            Integer releaseYear,
            String productionCompany,
            int durationMinutes,
            String language,
            Genre genre) {
        this.title = title;
        this.subtitle = subtitle;
        this.releaseDate = releaseDate;
        this.director = director;
        this.image = image;
        this.rating = rating;
        this.synopsis = synopsis;
        this.releaseYear = releaseYear;
        this.productionCompany = productionCompany;
        this.durationMinutes = durationMinutes;
        this.language = language;
    }
    
    // Getters e Setters
    public Integer getId() {  // Alterado para Integer
        return id;
    }

    public void setId(Integer id) {  // Alterado para Integer
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

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }
    
    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
