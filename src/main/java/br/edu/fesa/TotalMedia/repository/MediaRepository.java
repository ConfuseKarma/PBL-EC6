package br.edu.fesa.TotalMedia.repository;

import br.edu.fesa.TotalMedia.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MediaRepository extends JpaRepository<Media, Integer> {
    Optional<Media> findById(int id);
    List<Media> findByTitle(String title);  // Exemplo de busca por título
}
