package com.codeverse.code_verse_uni.dao;

import com.codeverse.code_verse_uni.entity.Review;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReviewRepository extends PagingAndSortingRepository<Review, Integer> {
    // that's it .... no need to write code here!
}
