package br.edu.fesa.TotalMedia.service;

import br.edu.fesa.TotalMedia.model.Media;
import br.edu.fesa.TotalMedia.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    // Salvar ou atualizar uma mídia
    public Media saveMedia(Media media) {
        // Salva o objeto de mídia, criando ou atualizando
        return mediaRepository.save(media);
    }

    public Media updateMedia(Media media) {
        // Verifica se a mídia existe no banco de dados
        Media existingMedia = mediaRepository.findById(media.getId()).orElseThrow(() -> new IllegalArgumentException("Mídia não encontrada"));

        // Atualiza os outros campos (título, gênero, data de lançamento, etc.)
        existingMedia.setTitle(media.getTitle());
        existingMedia.setSubtitle(media.getSubtitle());
        existingMedia.setGenre(media.getGenre());
        existingMedia.setReleaseDate(media.getReleaseDate());
        existingMedia.setDirector(media.getDirector());
        existingMedia.setImage(media.getImage());
        existingMedia.setRating(media.getRating());
        existingMedia.setSynopsis(media.getSynopsis());
        existingMedia.setYear(media.getYear());
        existingMedia.setProductionCompany(media.getProductionCompany());

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
