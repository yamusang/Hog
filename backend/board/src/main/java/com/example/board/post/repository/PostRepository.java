package com.example.board.post.repository;

import com.example.board.post.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // 기본적인 CRUD 기능은 JpaRepository가 제공함
    // findAll(), save(), findById() <- 얘네 제공함
}
/*
 * extends JpaRepository<Post, Long> : Post 엔티티를 기본키(Long) 기준으로 CRUD 처리하겠다는 뜻
 * PostRepository는 JpaRepository를 상속받았기 때문에
 * 스프링이 자동으로 구현체를 만들어서 **Bean(객체)**으로 등록함
 */