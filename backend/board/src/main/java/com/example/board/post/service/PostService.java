package com.example.board.post.service;

import com.example.board.post.model.entity.Post;
import com.example.board.post.model.input.PostRequestDto;
import com.example.board.post.model.output.PostResponseDto;
import com.example.board.post.repository.PostRepository;
import com.example.board.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // final 필드를 모아서 자동으로 생성자를 만들어주는 어노테이션
public class PostService {

    private final PostRepository postRepository;

    // 게시글 작성
    public void createPost(PostRequestDto requestDto, User user) {
        Post post = Post.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .author(user)
                .build();

        postRepository.save(post);
    }

    // 전체 게시글 조회
    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostResponseDto::new) // Post → PostResponseDto
                .collect(Collectors.toList());
    }

    // 게시글 단건 조회
    public PostResponseDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostResponseDto(post);
    }
}
/*
 * User user는 로그인한 사용자에서 받아와야 하므로,
 * → 나중에 @AuthenticationPrincipal로 컨트롤러에서 주입 예정
 * stream().map(PostResponseDto::new) → Post 리스트를 PostResponseDto로 바꿈
 * 
 * PostService는 @Service로 등록된 스프링 컴포넌트이고,
 * 생성자에서 PostRepository를 받게 돼 있음
 * 
 * ✅ 자바 기본 개념
 * 
 * final : 값을 한 번 할당해주면 못 바꾸는 변수.
 *         final로 선언하면 → 생성자에서만 초기화 가능
 * 
 * 
 */