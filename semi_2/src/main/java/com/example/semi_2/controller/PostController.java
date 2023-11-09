package com.example.semi_2.controller;

import com.example.semi_2.dto.request.PostCreateRequest;
import com.example.semi_2.service.PostService;
import com.example.semi_2.dto.response.post.PostGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    // 서버랑 클라랑 약속을 정해서 값을 넣어놓음 -> 편리 !
    // header에 memberId를 넣어서 전달받음
    private static final String CUSTOM_AUTH_ID = "X-Auth-Id";
    private final PostService postService;

    /**
     * 단건 조회
     */
    @GetMapping("{postId}")
    public ResponseEntity<PostGetResponse> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getById(postId));
    }

    /**
     * 전체 조회
     */
//    @GetMapping
//    public ResponseEntity<List<PostGetResponse>> getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long memberId) {
//        return ResponseEntity.ok(postService.getPosts(memberId));
//    }
    @PostMapping
    public ResponseEntity<Void> createPost(@RequestHeader(CUSTOM_AUTH_ID) Long memberId,
                                           @RequestBody PostCreateRequest request) {
        URI location = URI.create("/api/post/" + postService.create(request, memberId));
        return ResponseEntity.created(location).build();
    }
}
