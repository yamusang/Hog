package com.example.board.user.repository;

import com.example.board.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // 이메일로 사용자 조회하는 커스텀 쿼리 메서드
    Optional<User> findByEmail(String email);
}