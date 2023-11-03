package com.springboot.blog.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private long id;

    // name should not be null or empty
    @NotEmpty
    private String name;

    // email should not be null or empty
    // email field validation
    @NotEmpty
    @Email
    private String email;

    // comment body should not be null or empty
    // comment body must be minimum 10 characters
    @NotEmpty
    @Size(min = 10, message = "Comment body should have at least 10 characters")
    private String body;

    private PostDto post;
}
