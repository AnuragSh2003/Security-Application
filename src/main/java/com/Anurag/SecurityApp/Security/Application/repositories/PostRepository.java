package com.Anurag.SecurityApp.Security.Application.repositories;


import com.Anurag.SecurityApp.Security.Application.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
