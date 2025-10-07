package com.wsomad.PublicSocialNetwork.controller;

import com.wsomad.PublicSocialNetwork.model.Post;
import com.wsomad.PublicSocialNetwork.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
            @RequestParam(required = false) Integer  userId,
            @RequestParam(required = false, defaultValue = "10") Integer  limit
            ) {

        Map<String, Object> params = new HashMap<>();
        if (userId != null) params.put("userId", userId);
        if (limit != null) params.put("limit", limit);
        return postService.getAllPosts(params);
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable int postId) {
        return postService.getPostById(postId);
    }
}
