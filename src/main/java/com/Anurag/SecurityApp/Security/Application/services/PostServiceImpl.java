package com.Anurag.SecurityApp.Security.Application.services;

import com.Anurag.SecurityApp.Security.Application.dto.PostDTO;
import com.Anurag.SecurityApp.Security.Application.entities.PostEntity;
import com.Anurag.SecurityApp.Security.Application.entities.User;
import com.Anurag.SecurityApp.Security.Application.exceptions.ResourceNotFoundException;
import com.Anurag.SecurityApp.Security.Application.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostServices{

    private  final PostRepository postRepository;
    private final ModelMapper modelMapper;


    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity,PostDTO.class))
                .collect(Collectors.toList());
    }


    public PostDTO createNewPost(PostDTO inputPost) {

        PostEntity postEntity = modelMapper.map(inputPost ,PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity),PostDTO.class);
    }


    public PostDTO getPostById(Long postId) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        log.info("user {}",user);

        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Post Not found By Id "+postId));
        return modelMapper.map(postEntity,PostDTO.class);
    }

//    public PostDTO updatedPost(PostDTO inputPost, Long postId) {
//        PostEntity olderPost = postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post Not found By Id "+postId));
//        inputPost.setId(postId);
//        modelMapper.map(inputPost ,olderPost);
//        PostEntity savedPostEntity = postRepository.save(olderPost);
//        return modelMapper.map(savedPostEntity,PostDTO.class);
//    }
}

