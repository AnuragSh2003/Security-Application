package com.Anurag.SecurityApp.Security.Application.repositories;

import com.Anurag.SecurityApp.Security.Application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByEmail(String username);
}
