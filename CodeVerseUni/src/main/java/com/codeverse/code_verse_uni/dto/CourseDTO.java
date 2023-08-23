package com.codeverse.code_verse_uni.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CourseDTO {
    private int id;
    private String title;
    private int instructorId;
}
