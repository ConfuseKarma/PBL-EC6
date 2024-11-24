package br.edu.fesa.TotalMedia.service;

import br.edu.fesa.TotalMedia.model.Review;
import br.edu.fesa.TotalMedia.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    // Inject the Review repository
    @Autowired
    private ReviewRepository reviewRepository;

    // Save a new review
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    // Get all reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get reviews by type (e.g., "client" or "critic")
    public List<Review> getReviewsByType(String reviewType) {
        return reviewRepository.findByReviewType(reviewType);
    }

    // Get a specific review by ID
    public Optional<Review> getReviewById(Integer id) {
        return reviewRepository.findById(id);
    }

    // Update a review
    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    // Delete a review
    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);
    }
}
