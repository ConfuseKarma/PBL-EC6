package br.edu.fesa.TotalMedia.repository;

import br.edu.fesa.TotalMedia.model.Genre;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GenreRepository extends JpaRepository<Genre, UUID> {
  Optional<Genre> findById(int id);
}
