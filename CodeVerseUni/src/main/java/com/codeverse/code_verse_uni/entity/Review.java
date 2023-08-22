package com.codeverse.code_verse_uni.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "review")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "course_id")
    private Course course;

    public Review(String comment) {
        this.comment = comment;
    }
}
