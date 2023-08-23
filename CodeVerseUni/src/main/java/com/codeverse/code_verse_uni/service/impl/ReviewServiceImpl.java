package com.codeverse.code_verse_uni.service.impl;

import com.codeverse.code_verse_uni.dao.CourseRepository;
import com.codeverse.code_verse_uni.dao.ReviewRepository;
import com.codeverse.code_verse_uni.dto.ReviewDTO;
import com.codeverse.code_verse_uni.entity.Course;
import com.codeverse.code_verse_uni.entity.Review;
import com.codeverse.code_verse_uni.service.ReviewService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, CourseRepository courseRepository) {
        this.reviewRepository = reviewRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public Review save(ReviewDTO reviewDTO) {
        Course course = courseRepository.findById(reviewDTO.getCourseId()).orElse(null);
        if (course == null) {
            return null;
        }
        Review review = new Review();
        review.setId(reviewDTO.getId());
        review.setComment(reviewDTO.getComment());
        review.setCourse(course);
        return reviewRepository.save(review);
    }

    @Override
    public Review findById(int id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    @Override
    public boolean doesExist(int id) {
        return reviewRepository.existsById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        reviewRepository.deleteById(id);
    }
}
