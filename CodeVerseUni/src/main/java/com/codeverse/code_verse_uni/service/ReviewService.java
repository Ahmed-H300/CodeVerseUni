package com.codeverse.code_verse_uni.service;

import com.codeverse.code_verse_uni.entity.Review;

import java.util.List;

public interface ReviewService {
    public Review save(Review review);

    public Review findById(int id);

    public List<Review> findAll();

    public boolean doesExist(int id);

    public void deleteById(int id);
}
