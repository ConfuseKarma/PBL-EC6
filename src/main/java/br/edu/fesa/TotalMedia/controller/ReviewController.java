package br.edu.fesa.TotalMedia.controller;

import br.edu.fesa.TotalMedia.model.Review;
import br.edu.fesa.TotalMedia.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Endpoint to save a review
    @PostMapping
    public ResponseEntity<Review> saveReview(@RequestBody Review review) {
        Review newReview = reviewService.saveReview(review);
        return ResponseEntity.ok(newReview); // Return 200 OK with the saved review
    }

    // Endpoint to fetch all reviews
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews); // Return 200 OK with the list of reviews
    }

    // Endpoint to fetch reviews by type (client, critic)
    @GetMapping("/type/{reviewType}")
    public ResponseEntity<List<Review>> getReviewsByType(@PathVariable String reviewType) {
        List<Review> reviews = reviewService.getReviewsByType(reviewType);
        return ResponseEntity.ok(reviews); // Return 200 OK with the list of reviews
    }

    // Endpoint to fetch a review by ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Integer id) {
        Optional<Review> review = reviewService.getReviewById(id);
        return review.map(ResponseEntity::ok) // Return 200 OK with the review
                     .orElseGet(() -> ResponseEntity.notFound().build()); // Return 404 if not found
    }

    // Endpoint to update a review
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Integer id, @RequestBody Review review) {
        review.setId(id); // Ensure the review ID is set correctly
        Review updatedReview = reviewService.updateReview(review);
        return ResponseEntity.ok(updatedReview); // Return 200 OK with the updated review
    }

    // Endpoint to delete a review
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Integer id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content after successful deletion
    }
}
