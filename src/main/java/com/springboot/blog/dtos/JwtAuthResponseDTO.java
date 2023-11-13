package com.springboot.blog.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtAuthResponseDTO {
    private String accessToken;
    private String tokenType = "Bearer";
}
