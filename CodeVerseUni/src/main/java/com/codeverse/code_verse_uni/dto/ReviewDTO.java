package com.codeverse.code_verse_uni.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ReviewDTO {
    private int id;
    private String comment;
    private int courseId;
}
