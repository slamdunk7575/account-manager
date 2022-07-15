package com.jun.accountmanager.member.dto;

import com.jun.accountmanager.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberResponse {
    private long id;
    private String name;
    private Integer age;

    protected MemberResponse() {
    }

    public MemberResponse(long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static MemberResponse of(Member member) {
        return new MemberResponse(member.getId(), member.getName(), member.getAge());
    }
}
