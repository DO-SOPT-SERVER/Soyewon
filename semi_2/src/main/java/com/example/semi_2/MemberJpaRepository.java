package com.example.semi_2;

import com.example.semi_2.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

//    default Member findByIdOrThrow(Long memberId) {
//        //Member member =

    }
