package com.codeverse.code_verse_uni.service;

import com.codeverse.code_verse_uni.entity.Instructor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstructorService {
    public Instructor save(Instructor instructor);

    public Instructor findById(int id);

    public List<Instructor> findAll();

    public Instructor findByIdAllDetails(int id);

    public boolean doesExist(int id);

    public void deleteById(int id);
}
