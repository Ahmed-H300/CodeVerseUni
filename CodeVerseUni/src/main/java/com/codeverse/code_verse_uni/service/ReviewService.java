package com.codeverse.code_verse_uni.service;

import com.codeverse.code_verse_uni.dto.ReviewDTO;
import com.codeverse.code_verse_uni.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ReviewService {
    public Review save(ReviewDTO reviewDTO);

    public Review findById(int id);

    public Page<Review> findAll(Pageable pageable);

    public boolean doesExist(int id);

    public void deleteById(int id);
}
