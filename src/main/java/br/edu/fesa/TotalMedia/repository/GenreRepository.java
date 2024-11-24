package br.edu.fesa.TotalMedia.repository;

import br.edu.fesa.TotalMedia.model.Genre;  // Importando o modelo Genre
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {  // Usando Long como tipo do ID
    @Override
    Optional<Genre> findById(Integer id);  // Método para buscar pelo id
}
