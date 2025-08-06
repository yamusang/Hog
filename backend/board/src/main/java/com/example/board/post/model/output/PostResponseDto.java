package com.example.board.post.model.output;

import com.example.board.post.model.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto { // 응답용 DTO
    private Long id;
    private String title;
    private String content;
    private String authorEmail;
    private LocalDateTime createdAt;

    public PostResponseDto(Post post) { // ✅ 이건 생성자입니다. 모르시는건 아니겠죠? 🔥 객체(PostResponseDto) 만들 때 자동으로 호출되는 메소드
        this.id = post.getId(); 
        this.title = post.getTitle(); // Post 엔티티(클래스)에서 제목 가져옴
        this.content = post.getContent();
        this.authorEmail = post.getAuthor().getEmail();  // User 엔티티에 getEmail() 있어야 함
        this.createdAt = post.getCreatedAt();
    }
}
/*
* 클라이언트에 게시글 데이터를 보여줄 때 사용하는 응답 형태
* Post 엔티티를 받아서 필요한 값만 추출해서 가공
* author는 User 객체에서 이메일만 뽑음 (user.getEmail())

* 생성자는 "객체를 만들 때 필요한 데이터 받아서 초기화"
* 지금은 그 데이터가 Post 엔티티인 것!
 */