package com.example.semi_2.dto.response;

import com.example.semi_2.domain.Member;
import com.example.semi_2.domain.SOPT;
import lombok.Data;

    public record MemberGetResponse(
            String name,
            String nickname,
            int age,
            SOPT soptInfo
    ) {
        public static MemberGetResponse of(Member member) {
            return new MemberGetResponse(
                    member.getName(),
                    member.getNickname(),
                    member.getAge(),
                    member.getSopt()
            );
        }
    }

