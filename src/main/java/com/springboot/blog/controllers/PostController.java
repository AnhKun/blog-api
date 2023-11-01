package com.springboot.blog.controllers;

import com.springboot.blog.dtos.PostDto;
import com.springboot.blog.services.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {

    private final IPostService postService;

    // create the blog post
    @PostMapping("/posts")
    public ResponseEntity<String> createPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        return new ResponseEntity<>("Created",HttpStatus.CREATED);
    }

    // get all the posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost() {
        List<PostDto> postDtoList = postService.getAllPosts();
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }

    // get the post by its id
    @GetMapping("/posts/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long id) {
        var postDto = postService.getPostById(id);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    // update the post
    @PutMapping("/posts/{id}")
    public ResponseEntity<String> updatePost(@PathVariable long id, @RequestBody PostDto postDto){
        postService.updatePost(id, postDto);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    // delete the post by its id
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Deleted successfully.",HttpStatus.OK);
    }
}
