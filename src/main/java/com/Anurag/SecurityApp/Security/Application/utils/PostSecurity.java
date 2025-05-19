package com.Anurag.SecurityApp.Security.Application.utils;

import com.Anurag.SecurityApp.Security.Application.dto.PostDTO;
import com.Anurag.SecurityApp.Security.Application.entities.PostEntity;
import com.Anurag.SecurityApp.Security.Application.entities.User;
import com.Anurag.SecurityApp.Security.Application.services.PostServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostSecurity {

    private  final PostServices postServices;
    boolean isOwnerOfPost(Long postId){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PostDTO post = postServices.getPostById(postId);
        return post.getAuthor().getId().equals(user.getId());

    }
}
