package com.wsomad.PublicSocialNetwork.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Post {
    private int userId;
    @JsonProperty("id")
    private int postId;
    @JsonProperty("title")
    private String postTitle;
    @JsonProperty("body")
    private String postBody;
}
