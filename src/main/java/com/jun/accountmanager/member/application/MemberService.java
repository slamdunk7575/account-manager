package com.jun.accountmanager.member.application;

import com.jun.accountmanager.member.dao.MemberRepository;
import com.jun.accountmanager.member.dto.MemberRequest;
import com.jun.accountmanager.member.dto.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponse addMember(MemberRequest memberRequest) {
        return MemberResponse.of(memberRepository.save(memberRequest.toEntity()));
    }

    @Transactional(readOnly = true)
    public List<MemberResponse> getMembers() {
        return memberRepository.findAll()
                .stream()
                .map(MemberResponse::of)
                .collect(Collectors.toList());
    }
}
