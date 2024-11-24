package br.edu.fesa.TotalMedia.service;

import br.edu.fesa.TotalMedia.model.Media;
import br.edu.fesa.TotalMedia.model.GenreMedia;
import br.edu.fesa.TotalMedia.repository.MediaRepository;
import br.edu.fesa.TotalMedia.repository.GenreMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private GenreMediaRepository genreMediaRepository;

    // Salvar ou atualizar uma mídia
    public Media saveMedia(Media media) {
        // Salva a mídia
        Media savedMedia = mediaRepository.save(media);

        // Salva as associações de gêneros (a mídia pode ter mais de um gênero)
        if (media.getGenres() != null) {
            for (GenreMedia genreMedia : media.getGenres()) {
                genreMedia.setMedia(savedMedia); // Associa a mídia ao gênero
                genreMediaRepository.save(genreMedia);
            }
        }

        return savedMedia;
    }

    // Atualizar uma mídia
    public Media updateMedia(Media media) {
        // Verifica se a mídia existe no banco de dados
        Media existingMedia = mediaRepository.findById(media.getId()).orElseThrow(() -> new IllegalArgumentException("Mídia não encontrada"));

        // Atualiza os campos da mídia
        existingMedia.setTitle(media.getTitle());
        existingMedia.setSubtitle(media.getSubtitle());
        existingMedia.setReleaseDate(media.getReleaseDate());
        existingMedia.setDirector(media.getDirector());
        existingMedia.setImage(media.getImage());
        existingMedia.setRating(media.getRating());
        existingMedia.setSynopsis(media.getSynopsis());
        existingMedia.setYear(media.getYear());
        existingMedia.setProductionCompany(media.getProductionCompany());

        // Atualiza as associações de gêneros (após remover os antigos)
        genreMediaRepository.deleteByMedia(existingMedia); // Remove associações antigas
        if (media.getGenres() != null) {
            for (GenreMedia genreMedia : media.getGenres()) {
                genreMedia.setMedia(existingMedia); // Associa a mídia ao gênero
                genreMediaRepository.save(genreMedia);
            }
        }

        // Retorna a mídia atualizada
        return mediaRepository.save(existingMedia);
    }

    // Recuperar todas as mídias
    public List<Media> getAllMedias() {
        return mediaRepository.findAll();
    }

    // Recuperar uma mídia pelo ID
    public Optional<Media> getMediaById(int id) {
        return mediaRepository.findById(id);
    }

    // Recuperar uma mídia pelo título
    public List<Media> getMediaByTitle(String title) {
        return mediaRepository.findByTitle(title); // Supondo que haja um método no repositório
    }

    // Deletar uma mídia pelo ID
    public void deleteMedia(int id) {
        mediaRepository.deleteById(id);
    }
}
