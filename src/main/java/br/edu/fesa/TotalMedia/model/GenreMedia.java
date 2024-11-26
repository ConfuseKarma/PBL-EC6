package br.edu.fesa.TotalMedia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_GENRE_MEDIA")
public class GenreMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GENRE_MEDIA")
    private Integer id;  // Alterado para Integer

    @ManyToOne
    @JoinColumn(name = "ID_MEDIA", referencedColumnName = "ID_MEDIA")
    private Media media;

    @ManyToOne
    @JoinColumn(name = "ID_GENRE", referencedColumnName = "ID_GENRE")
    private Genre genre;

    public GenreMedia() {}

    public GenreMedia(Media media, Genre genre) {
        this.media = media;
        this.genre = genre;
    }

    public Integer getId() {  
        return id;
    }

    public void setId(Integer id) {  
        this.id = id;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
