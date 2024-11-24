package br.edu.fesa.TotalMedia.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Table(name = "TB_MEDIA", schema = "TOTALMEDIA")
@Inheritance(strategy = InheritanceType.JOINED)

public class Media implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MEDIA")
    private Integer id;  // Alterado para Integer

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

    @Column(name = "YEAR", nullable = true)
    private Integer year;

    @Column(name = "PRODUCTION_COMPANY", nullable = true, length = 255)
    private String productionCompany;

    @OneToMany(mappedBy = "media", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GenreMedia> genres = new ArrayList<>();  // Inicializando a lista de gêneros

    public Media() {}

    public Media(String title, String subtitle, LocalDateTime releaseDate, Director director,
                 String image, String rating, String synopsis, Integer year, String productionCompany, Genre genre) {
        this.title = title;
        this.subtitle = subtitle;
        this.releaseDate = releaseDate;
        this.director = director;
        this.image = image;
        this.rating = rating;
        this.synopsis = synopsis;
        this.year = year;
        this.productionCompany = productionCompany;
        addGenre(genre);  // Adiciona o gênero à lista
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

    // Método para adicionar gêneros à lista
    public void addGenre(Genre genre) {
        this.genres.add(new GenreMedia(this, genre));
    }

    public List<GenreMedia> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreMedia> genres) {
        this.genres = genres;
    }
}
