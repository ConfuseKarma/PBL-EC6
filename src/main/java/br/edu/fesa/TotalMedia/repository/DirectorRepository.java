package br.edu.fesa.TotalMedia.repository;

import br.edu.fesa.TotalMedia.model.Director;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DirectorRepository extends JpaRepository<Director, UUID> {
  Optional<Director> findById(int id);
}
