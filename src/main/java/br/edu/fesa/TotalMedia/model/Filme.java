package br.edu.fesa.TotalMedia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_FILME", schema = "TOTALMEDIA")
public class Filme extends Media {

    @Column(name = "DURATION_MINUTES", nullable = false)
    private int durationMinutes;

    @Column(name = "LANGUAGE", nullable = false, length = 50)
    private String language;

    public Filme(
        String title,
        String subtitle,
        Genre genre,  // Agora inclui o parâmetro 'genre'
        LocalDateTime releaseDate,
        Director director,
        String image,
        String rating,
        String synopsis,
        Integer year,
        String productionCompany,
        int durationMinutes,
        String language
    ) {
        super(
            title,
            subtitle,
            releaseDate,
            director,
            image,
            rating,
            synopsis,
            year,
            productionCompany,
            genre  // Passando o gênero
        );
        this.durationMinutes = durationMinutes;
        this.language = language;
    }

    // Getters e Setters
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
