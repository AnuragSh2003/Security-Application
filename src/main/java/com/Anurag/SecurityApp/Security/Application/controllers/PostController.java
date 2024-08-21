package com.Anurag.SecurityApp.Security.Application.controllers;

import com.Anurag.SecurityApp.Security.Application.dto.PostDTO;
import com.Anurag.SecurityApp.Security.Application.services.PostServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

    private  final PostServices postServices;
    @GetMapping
    public List<PostDTO> getAllPosts(){
        return postServices.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostDTO getPostById(@PathVariable Long postId){
        return postServices.getPostById(postId);
    }

    @PostMapping
    public  PostDTO createNewPost(@RequestBody PostDTO inputPost){
        return  postServices.createNewPost(inputPost);
    }

}
