package com.codeverse.code_verse_uni.service.impl;

import com.codeverse.code_verse_uni.dao.ReviewRepository;
import com.codeverse.code_verse_uni.entity.Review;
import com.codeverse.code_verse_uni.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review save(Review review) {
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
    public void deleteById(int id) {
        reviewRepository.deleteById(id);
    }
}
