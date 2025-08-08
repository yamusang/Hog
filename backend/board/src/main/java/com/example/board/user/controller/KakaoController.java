package com.example.board.user.controller;

import com.example.board.user.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class KakaoController {

    private final KakaoService kakaoService;

    @PostMapping("/kakao-login")
    public String kakaoLogin(@RequestBody KakaoLoginRequest request) {
        return kakaoService.kakaoLogin(request.getEmail());
    }

    // 카카오에서 받아온 사용자 이메일을 담는 DTO
    public static class KakaoLoginRequest {
        private String email;
        public String getEmail() { return email; }
    }
}