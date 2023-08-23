package com.codeverse.code_verse_uni.controller;

import com.codeverse.code_verse_uni.dto.ReviewDTO;
import com.codeverse.code_verse_uni.entity.Review;
import com.codeverse.code_verse_uni.exception.EntityNotFoundException;
import com.codeverse.code_verse_uni.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews/")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Add test API mapping
    @GetMapping("/hello")
    public String hello(){
        return "Hello From Review!";
    }

    @GetMapping("/{reviewId}")
    public Review getReview(@PathVariable("reviewId") int reviewId) {
        Review review = reviewService.findById(reviewId);
        if (review == null) {
            throw new EntityNotFoundException("Review id not found - " + reviewId);
        }
        return review;
    }

    @GetMapping("/all")
    public Page<Review> getAllReviews(@PageableDefault(size = 10) Pageable pageable) {
        return reviewService.findAll(pageable);
    }

    @PostMapping("/")
    public Review addReview(@RequestBody ReviewDTO reviewDTO) {
        reviewDTO.setId(0);
        Review review =  reviewService.save(reviewDTO);
        if (review == null) {
            throw new EntityNotFoundException("Course id not found - " + reviewDTO.getCourseId());
        }
        return review;
    }

    @PutMapping("/")
    public Review updateReview(@RequestBody ReviewDTO reviewDTO) {
        return reviewService.save(reviewDTO);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable("reviewId") int reviewId) {
        if (!reviewService.doesExist(reviewId)) {
            throw new EntityNotFoundException("Review id not found - " + reviewId);
        }
        reviewService.deleteById(reviewId);
        return ResponseEntity.ok().body("Deleted Review id - " + reviewId);
    }

    @GetMapping("/exists/{reviewId}")
    public ResponseEntity<Boolean> doesExist(@PathVariable("reviewId") int reviewId) {
        return ResponseEntity.ok(reviewService.doesExist(reviewId));
    }

}
