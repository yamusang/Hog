package com.example.board.post.controller;

import com.example.board.post.model.input.PostRequestDto;
import com.example.board.post.model.output.PostResponseDto;
import com.example.board.post.service.PostService;
import com.example.board.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    // 게시글 작성
    @PostMapping
    public void createPost(@RequestBody PostRequestDto requestDto) {
        // 추후 인증된 사용자 정보로 대체 예정
        User mockUser = new User();  // 임시 User 객체
        mockUser.setEmail("junwoo@example.com");  // 더미 데이터
        postService.createPost(requestDto, mockUser);
    }
    

    // 게시글 전체 조회
    @GetMapping
    public List<PostResponseDto> getAllPosts() {
        return postService.getAllPosts();
    }

    // 게시글 단건 조회
    @GetMapping("/{id}")
    public PostResponseDto getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }
}
