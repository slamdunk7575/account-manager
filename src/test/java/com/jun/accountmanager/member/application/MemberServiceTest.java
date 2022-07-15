package com.jun.accountmanager.member.application;

import com.jun.accountmanager.member.dto.MemberRequest;
import com.jun.accountmanager.member.dto.MemberResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @DisplayName("사용자를 추가할 수 있다.")
    @Test
    void addMember() {
        // given
        MemberRequest memberRequest = new MemberRequest("yanggang", 20);

        // when
        MemberResponse memberResponse = memberService.addMember(memberRequest);

        // then
        assertThat(memberResponse.getId()).isNotNull();
        assertThat(memberResponse.getName()).isEqualTo("yanggang");
    }

    @DisplayName("사용자 목록을 조회할 수 있다.")
    @Test
    void getMembers() {
        // given & when
        List<MemberResponse> members = memberService.getMembers();

        // then
        assertThat(members.size()).isNotEqualTo(0);
    }
}
