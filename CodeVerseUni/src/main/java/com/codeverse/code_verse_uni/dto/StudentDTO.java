package com.codeverse.code_verse_uni.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class StudentDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Integer> courseIds;
}
