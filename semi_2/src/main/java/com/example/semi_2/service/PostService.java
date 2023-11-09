package com.example.semi_2.service;

import com.example.semi_2.domain.Member;
import com.example.semi_2.domain.Post;
import com.example.semi_2.dto.request.PostCreateRequest;
import com.example.semi_2.dto.response.post.PostGetResponse;
import com.example.semi_2.repository.MemberJpaRepository;
import com.example.semi_2.repository.PostJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostJpaRepository postJpaRepository;
    // 의존성 주입
    private final MemberJpaRepository memberJpaRepository;

    @Transactional // 생성이므로 entity의 정보를 가져옴
    public String create(PostCreateRequest request, Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        Post post = Post.builder()
                .title(request.title())
                .content(request.content())
                .member(member)
                .build();
        Post savedPost = postJpaRepository.save(post);
        return savedPost.getPostId().toString();
    }

    public List<PostGetResponse> getPosts(Long memberId) {
        return postJpaRepository.findAllByMemberId(memberId)
                .stream()
                .map(post -> PostGetResponse.of(post))
                .toList();
    }

    public PostGetResponse getById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        return PostGetResponse.of(post);
    }
}

