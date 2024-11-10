package br.edu.fesa.TotalMedia.repository;

import br.edu.fesa.TotalMedia.model.Media;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MediaRepository extends JpaRepository<Media, UUID> {
  Optional<Media> findById(int id);
}
