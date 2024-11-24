package br.edu.fesa.TotalMedia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_GENRE")
public class Genre {

    @Id
    @Column(name = "ID_GENRE")
    private Integer id;  // Alterado para Integer

    @Column(name = "GENRE_NAME", nullable = false)
    private String name;

    public Genre() {}

    public Genre(Integer id, String name) {  // Alterado para Integer
        this.id = id;
        this.name = name;
    }

    public Integer getId() {  // Alterado para Integer
        return id;
    }

    public void setId(Integer id) {  // Alterado para Integer
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
