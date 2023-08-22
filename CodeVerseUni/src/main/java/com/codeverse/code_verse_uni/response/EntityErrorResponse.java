package com.codeverse.code_verse_uni.response;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EntityErrorResponse {

    private String status;
    private String message;
    private String timeStamp;

}
