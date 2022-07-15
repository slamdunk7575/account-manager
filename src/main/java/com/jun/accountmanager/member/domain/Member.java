package com.jun.accountmanager.member.domain;

import com.jun.accountmanager.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("이름")
    private String name;

    @Comment("나이")
    private Integer age;

    @Builder
    public Member(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
