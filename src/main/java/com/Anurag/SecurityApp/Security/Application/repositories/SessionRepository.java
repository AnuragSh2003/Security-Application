package com.Anurag.SecurityApp.Security.Application.repositories;

import com.Anurag.SecurityApp.Security.Application.entities.Session;
import com.Anurag.SecurityApp.Security.Application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session,Long> {
    List<Session> findByUser(User user);


    Optional<Session> findByRefreshToken(String refreshToken);
}
