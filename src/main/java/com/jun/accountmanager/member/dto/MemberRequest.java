package com.jun.accountmanager.member.dto;

import com.jun.accountmanager.member.domain.Member;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
public class MemberRequest {

    @Size(min = 1, max = 50, message = "이름은 1~50 사이로 입력해주세요.")
    private String name;

    @Min(1)
    @Max(200)
    private Integer age = 1;

    protected MemberRequest() {
    }

    public MemberRequest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Member toEntity() {
        return Member.builder()
                .name(this.name)
                .age(this.age)
                .build();
    }
}
