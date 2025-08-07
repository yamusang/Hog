package com.example.board.post.model.input;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto {
    private String title;
    private String content;
}

/*
 * 사용자가 글을 작성할 때 보내는 데이터 (title, content)
 * 생성자 없어도 @NoArgsConstructor + Setter 안 써도 JSON에서 자동 주입됨
 */