package com.springboot.blog.controllers;

import com.springboot.blog.dtos.CommentDto;
import com.springboot.blog.services.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CommentController {

    private final ICommentService commentService;

    // create new comment
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<String> createComment(@PathVariable long postId, @RequestBody CommentDto commentDto) {
        commentService.createComment(postId, commentDto);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    // get all comments by post id
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentDto>> getCommentsByPostId(
            @PathVariable long postId
    ) {
        var commentList = commentService.getCommentByPostId(postId);
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(
            @PathVariable(value = "postId") long postId,
            @PathVariable(value = "commentId") long commentId
    ) {
        var commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable(value = "postId") long postId,
            @PathVariable(value = "commentId") long commentId,
            @RequestBody CommentDto commentDto
    ){
        var updatedComment = commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(
            @PathVariable(value = "postId") long postId,
            @PathVariable(value = "commentId") long commentId
    ){
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Deleted!", HttpStatus.OK);
    }
}
