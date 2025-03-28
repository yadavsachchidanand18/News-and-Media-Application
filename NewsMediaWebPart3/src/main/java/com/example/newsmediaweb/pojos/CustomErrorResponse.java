package com.example.newsmediaweb.pojos;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomErrorResponse {
    private String message;
    private Integer internalStatusCode;

}
