package com.codeverse.code_verse_uni.dao;

import com.codeverse.code_verse_uni.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    // that's it .... no need to write code here!
}
