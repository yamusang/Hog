package com.example.board.post.model.entity;

import java.time.LocalDateTime;

import com.example.board.user.model.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Post {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue : 자동증가, IDENTITY : MySQL의 AUTO_INCREMENT 방식
    private Long id; // Long은 null 가능. long은 기본형으로 초기값이 0 -> null 체크 불가

    private String title;

    @Column(columnDefinition = "TEXT") // TEXT 타입으로 하는 이유 : 긴 내용을 받기 위해
    private String content;

    @ManyToOne(fetch = FetchType.LAZY) // @ManyToOne: 여러 게시글이 하나의 사용자에게 속함
    @JoinColumn(name = "user_id") // 작성자
    private User author;

    private LocalDateTime createdAt; // 게시글 작성 시간

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now(); // 현재 시간 값
    }
}
/*
 * fetch = LAZY: 성능을 위해 처음엔 User를 가져오지 않고, 나중에 접근할 때 가져옴
 * @JoinColumn(name = "user_id"): DB에서 외래키 컬럼명은 user_id
 * 
 * @PrePersist: DB에 저장되기 전에 자동으로 실행되는 메서드
 * 게시글이 저장되기 전 createdAt에 현재 시간을 넣어줌
 * 
 * ✅ 자바 기본 개념
 * 
 * int < long < Long
 * 
 * private : 오직 Post 클래스 내부에서만 필드/메서드 접근 가능
 *           🔥 쓰는 이유 : 객체의 속성 캡슐화 -> 외부에서 못 건드니까. 그래서 getter/setter를 쓰는거임ㅋㅋ
 * 
 * protected : 같은 패키지 or 상속받은 자식 클래스만 접근 가능
 *             🔥 쓰는 이유 : JPA 내부에서 onCreate() 메서드 호출해야하니까. private 쓰면 JPA도 못 쓰잖음. public은 너무 개방적인 새끼라 안됨.
 * 
 * this. : 현재 클래스 자기 자신 가리키는 예약어. 같은 클래스 안의 변수나 메서드를 호출할 때 사용
 *         🔥 쓰는 이유 : 메소드 안에서 멤버 변수와 지역변수 이름이 겹칠 때 구분하려고.
 * 
 * 멤버 변수 : 클래스 필드
 * 지역 변수 : 메소드 필드
 * 매개 변수 : 메소드 인자
 */