package com.Anurag.SecurityApp.Security.Application.services;


import com.Anurag.SecurityApp.Security.Application.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostServices {

    List<PostDTO> getAllPosts();

    PostDTO createNewPost(PostDTO inputPost);

    PostDTO getPostById(Long postId);

//    PostDTO updatedPost(PostDTO inputPost, Long postId);
}
