package com.wsomad.PublicSocialNetwork.controller;

import com.wsomad.PublicSocialNetwork.model.Post;
import com.wsomad.PublicSocialNetwork.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(
            @RequestParam(required = false) int userId,
            @RequestParam(defaultValue = "10") int limit
            ) {

        Map<String, Object> params = Map.of(
                "userId", userId,
                "limit", limit
        );
        return postService.getAllPosts(params);
    }
}
