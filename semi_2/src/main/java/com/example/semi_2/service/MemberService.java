package com.example.semi_2.service;

import com.example.semi_2.MemberJpaRepository;
import com.example.semi_2.domain.Member;
import com.example.semi_2.dto.request.MemberCreateRequest;
import com.example.semi_2.dto.response.MemberGetResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public MemberGetResponse getByIdV1(Long memberId) {
        Member member = memberJpaRepository.findById(memberId).get();
        MemberGetResponse response = MemberGetResponse.of(member);
        return response;
    }

    public MemberGetResponse getByIdV2(Long memberId) {
        Member member = memberJpaRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 회원이 없습니다."));
        return MemberGetResponse.of(member);
    }

    public List<MemberGetResponse> getMembers() {
       return memberJpaRepository.findAll() // Entity가 그대로 return
                .stream()
                .map(member -> MemberGetResponse.of(member)) // 각 멤버에 대해서 mapping을 해주는데, MemberGetResponse를 사용해서 매핑하라
               // .map(MemberGetResponse::of)와 동일
               .collect(Collectors.toList()); // list로 만들어라
        // DTO로 바꿔주기
    }

    @Transactional
    public String create(MemberCreateRequest request) {
        Member member = Member.builder()
                .name(request.name())
                .nickname(request.nickname())
                .age(request.age())
                .sopt(request.sopt())
                .build();
        // 멤버 저장
        return memberJpaRepository.save(member).getId().toString();
    }

    private Member findById(Long memberId) {
        return memberJpaRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("해당하는 회원이 없습니다."));
    }
}
