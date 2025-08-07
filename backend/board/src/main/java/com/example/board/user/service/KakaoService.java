package com.example.board.user.service;

import com.example.board.security.jwt.JwtProvider;
import com.example.board.user.model.entity.User;
import com.example.board.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KakaoService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public String kakaoLogin(String kakaoEmail) {
        // 1. 기존 회원인지 확인
        Optional<User> userOptional = userRepository.findByEmail(kakaoEmail);

        User user = userOptional.orElseGet(() -> {
            // 2. 없으면 새로 가입
            User newUser = new User();
            newUser.setEmail(kakaoEmail);
            newUser.setPassword("kakao"); // 실제로는 비번 없이 처리
            return userRepository.save(newUser);
        });

        // 3. JWT 발급
        return jwtProvider.createToken(user.getEmail());
    }
}
