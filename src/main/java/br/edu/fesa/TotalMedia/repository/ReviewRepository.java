package br.edu.fesa.TotalMedia.repository;

import br.edu.fesa.TotalMedia.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Interface for the Review repository
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    // Custom query method to find reviews by their type (e.g., "client" or "critic")
    List<Review> findByReviewType(String reviewType);
}
