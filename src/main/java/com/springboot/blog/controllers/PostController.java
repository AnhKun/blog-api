package com.springboot.blog.controllers;

import com.springboot.blog.dtos.PostDto;
import com.springboot.blog.payload.PostResponse;
import com.springboot.blog.services.IPostService;
import com.springboot.blog.utils.AppConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {

    private final IPostService postService;

    // create the blog post
    @PostMapping("/posts")
    public ResponseEntity<String> createPost(@Valid @RequestBody PostDto postDto) {
        postService.createPost(postDto);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    // get all the posts
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        PostResponse postResponse = postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    // get the post by its id
    @GetMapping("/posts/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long id) {
        var postDto = postService.getPostById(id);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    // update the post
    @PutMapping("/posts/{id}")
    public ResponseEntity<String> updatePost(@PathVariable long id, @Valid @RequestBody PostDto postDto) {
        postService.updatePost(id, postDto);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    // delete the post by its id
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }
}
