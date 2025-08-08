package com.example.board.post.controller;

import com.example.board.post.model.input.PostRequestDto;
import com.example.board.post.model.output.PostResponseDto;
import com.example.board.post.service.PostService;
import com.example.board.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // REST API 전용 컨트롤러 (응답을 JSON으로 반환)
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    // 게시글 작성
    @PostMapping
    public void createPost(@RequestBody PostRequestDto requestDto) { // 얘를 통해서 json으로 받은걸 dto로 자동 전환됨.
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

/*
 * @PostMapping 
 * 데이터 생성(예: 회원가입, 게시글 작성 등)에 사용
 * 
 * 어노테이션	설명
@GetMapping	데이터 조회용 (GET 요청)
@PostMapping	데이터 생성용 (POST 요청)
@PutMapping	데이터 전체 수정용 (PUT 요청)
@PatchMapping	데이터 일부 수정용 (PATCH 요청)
@DeleteMapping	데이터 삭제용 (DELETE 요청)

 */