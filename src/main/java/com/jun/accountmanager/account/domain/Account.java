package com.jun.accountmanager.account.domain;

import com.jun.accountmanager.member.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Comment("계좌번호")
    @Column(nullable = false)
    private String number;

    @OneToMany(mappedBy = "account")
    private List<AccountDetail> accountDetails = new ArrayList<>();

    @Builder
    public Account(Member member, String number) {
        this.member = member;
        this.number = number;
    }

    public long getMemberId() {
        return this.member.getId();
    }
}
