package com.springboot.blog.services;

import com.springboot.blog.dtos.CommentDto;

import java.util.List;

public interface ICommentService {
    void createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentByPostId(long postId);

    CommentDto getCommentById(long postId, long id);

    CommentDto updateComment(long postId, long commentId, CommentDto commentDto);

    void deleteComment(long postId, long commentId);
}
