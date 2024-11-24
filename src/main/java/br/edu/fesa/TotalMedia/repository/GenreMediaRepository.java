package br.edu.fesa.TotalMedia.repository;

import br.edu.fesa.TotalMedia.model.GenreMedia;
import br.edu.fesa.TotalMedia.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreMediaRepository extends JpaRepository<GenreMedia, Integer> {

    // Método para excluir associações de gêneros de uma mídia
    void deleteByMedia(Media media);

    // Método para buscar todas as associações de gênero de uma mídia
    List<GenreMedia> findByMedia(Media media);
}
