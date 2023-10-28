package com.example.semi_2.dto.request;

import com.example.semi_2.domain.SOPT;
import lombok.Data;

public record MemberCreateRequest (
    String name,
    String nickname,
    int age,
    SOPT sopt
) {}
