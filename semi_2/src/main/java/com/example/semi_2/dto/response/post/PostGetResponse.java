package com.example.semi_2.dto.response.post;

import com.example.semi_2.domain.Post;
import jdk.jfr.Category;

public record PostGetResponse(
        Long id,
        String title,
        String content
) {
    public static PostGetResponse of(Post post) {
        return new PostGetResponse(
                post.getPostId(),
                post.getTitle(),
                post.getContent()
        );
    }
}
