package com.springboot.blog.services.impl;

import com.springboot.blog.converter.Mapper;
import com.springboot.blog.dtos.PostDto;
import com.springboot.blog.entities.Post;
import com.springboot.blog.exceptions.ResourceNotFoundException;
import com.springboot.blog.repositories.IPostRepository;
import com.springboot.blog.services.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {
    private final IPostRepository postRepository;
    private final Mapper mapper;
    @Override
    public void createPost(PostDto postDto) {
        // convert DTO to entity
        var post = mapper.toModel(postDto, Post.class);
        postRepository.save(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> postList= postRepository.findAll();
        return mapper.toList(postList, PostDto.class);
    }

    @Override
    public PostDto getPostById(long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapper.toModel(post, PostDto.class);
    }

    @Override
    public void updatePost(long id, PostDto postDto) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        postRepository.save(post);
    }

    @Override
    public void deletePost(long id) {
        var post = postRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }
}
