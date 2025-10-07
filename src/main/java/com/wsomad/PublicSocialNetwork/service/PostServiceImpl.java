package com.wsomad.PublicSocialNetwork.service;

import com.wsomad.PublicSocialNetwork.model.Post;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
    private final String uriPath = "posts";
    private final RestClient restClient;

    public PostServiceImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    public Post getPostById(int postId) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/" + uriPath + "/{id}")
                        .build(postId)
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Post.class);
    }

    public List<Post> getAllPosts(Map<String, Object> params) {
        List<Post> posts = restClient.get()
                .uri(uriBuilder -> {
                    var builder = uriBuilder.path("/" + uriPath);
                    params.forEach(builder::queryParam);
                    return builder.build();
                })
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {});

        Object limitObject = params.getOrDefault("limit", 10);
        if (posts != null && limitObject != null) {
            int limit = Integer.parseInt(limitObject.toString());
            posts = posts.stream().limit(limit).toList();
        }
        return posts;
    }
}
