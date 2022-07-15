package com.jun.accountmanager.member.ui;

import com.jun.accountmanager.member.application.MemberService;
import com.jun.accountmanager.member.dto.MemberRequest;
import com.jun.accountmanager.member.dto.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<MemberResponse> addMember(@RequestBody MemberRequest memberRequest) {
        MemberResponse memberResponse = memberService.addMember(memberRequest);
        return ResponseEntity.created(URI.create("/member/" + memberResponse.getId())).build();
    }

    @GetMapping("/member/list")
    public ResponseEntity<List<MemberResponse>> getMembers() {
        List<MemberResponse> members = memberService.getMembers();
        return ResponseEntity.ok().body(members);
    }

}
