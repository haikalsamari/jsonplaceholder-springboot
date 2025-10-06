package com.wsomad.PublicSocialNetwork.service;

import com.wsomad.PublicSocialNetwork.model.Post;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class PostService {
    private final RestClient restClient;

    public PostService(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<Post> getAllPosts(Map<String, Object> params) {
        return restClient.get()
                .uri(uriBuilder -> {
                    var builder = uriBuilder.path("/posts");
                    params.forEach(builder::queryParam);
                    return builder.build();
                })
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {});
    }
}
