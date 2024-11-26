package br.edu.fesa.TotalMedia.service;

import br.edu.fesa.TotalMedia.model.Review;
import br.edu.fesa.TotalMedia.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    // Injeção do repositório de Review
    @Autowired
    private ReviewRepository reviewRepository;

    // Salvar uma nova avaliação
    public Review saveReview(Review review) {
        return reviewRepository.save(review); // Salva a avaliação no banco de dados
    }

    // Obter todas as avaliações
    public List<Review> getAllReviews() {
        return reviewRepository.findAll(); // Retorna todas as avaliações do banco
    }

    // Obter avaliações por tipo (por exemplo, "client" ou "critic")
    public List<Review> getReviewsByType(String reviewType) {
        return reviewRepository.findByReviewType(reviewType); // Retorna avaliações filtradas pelo tipo
    }

    // Obter uma avaliação específica por ID
    public Optional<Review> getReviewById(Integer id) {
        return reviewRepository.findById(id); // Retorna a avaliação com o ID fornecido, se existir
    }

    // Atualizar uma avaliação existente
    public Review updateReview(Review review) {
        // Verifica se a avaliação existe antes de atualizar
        Optional<Review> existingReview = reviewRepository.findById(review.getId());
        if (existingReview.isPresent()) {
            return reviewRepository.save(review); // Atualiza a avaliação se encontrada
        }
        throw new RuntimeException("Review not found with ID: " + review.getId()); // Lança exceção caso não encontre a avaliação
    }

    // Excluir uma avaliação
    public void deleteReview(Integer id) {
        // Verifica se a avaliação existe antes de excluir
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isPresent()) {
            reviewRepository.deleteById(id); // Exclui a avaliação se encontrada
        } else {
            throw new RuntimeException("Review not found with ID: " + id); // Lança exceção caso não encontre a avaliação
        }
    }

    // Verifica se a avaliação existe no banco de dados
    public boolean existsById(Integer id) {
        return reviewRepository.existsById(id); // Retorna true se a avaliação existir, false caso contrário
    }
    
    public List<Review> findReviewsByMovieId(int movieId) {
        return reviewRepository.findAllByMovieId(movieId);
    }
}
