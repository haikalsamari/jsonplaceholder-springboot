package com.wsomad.PublicSocialNetwork.service;

import com.wsomad.PublicSocialNetwork.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PostService {
    List<Post> getAllPosts(Map<String, Object> params);
    Post getPostById(int postId);
}
