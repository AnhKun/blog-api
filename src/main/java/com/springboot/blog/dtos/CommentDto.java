package com.springboot.blog.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;

    private PostDto post;
}
