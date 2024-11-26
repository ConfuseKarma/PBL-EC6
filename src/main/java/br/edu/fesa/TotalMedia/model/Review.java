package br.edu.fesa.TotalMedia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "TB_REVIEW")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REVIEW")
    private Integer id;  // ID da revisão

    @Column(name = "TEXT", nullable = false, length = 1000)
    private String text;  // Texto da revisão

    @Column(name = "REVIEW_TYPE", nullable = false, length = 50)
    @NotNull
    private String reviewType;  // Tipo de revisão (client ou critic)

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    @NotNull
    private User user;  // Relacionamento com o usuário (quem fez a review)

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID", nullable = false) // Atualizando o nome da coluna para 'MOVIE_ID'
    @NotNull
    private Movie movie;  // Relacionamento com o filme avaliado

    // Construtor sem o 'id', que será gerado automaticamente pelo banco de dados
    public Review(String text, String reviewType, User user, Movie movie) {
        this.text = text;
        this.reviewType = reviewType;
        this.user = user;
        this.movie = movie;
    }
    
    public Review() {
        // Construtor sem argumentos
    }

    // Construtor com todos os campos, incluindo o id (gerado automaticamente)
    public Review(Integer id, String text, String reviewType, User user, Movie movie) {
        this.id = id;
        this.text = text;
        this.reviewType = reviewType;
        this.user = user;
        this.movie = movie;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReviewType() {
        return reviewType;
    }

    public void setReviewType(String reviewType) {
        // Validação simples para garantir que o reviewType seja válido
        if (!reviewType.equals("client") && !reviewType.equals("critic")) {
            throw new IllegalArgumentException("Invalid review type");
        }
        this.reviewType = reviewType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", reviewType='" + reviewType + '\'' +
                ", user=" + (user != null ? user.getName() : "Unknown") + // Se o usuário for nulo, exibe "Unknown"
                ", movie=" + (movie != null ? movie.getTitle() : "Unknown") + // Se o filme for nulo, exibe "Unknown"
                '}';
    }
}
