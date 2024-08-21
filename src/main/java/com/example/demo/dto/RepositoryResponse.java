package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RepositoryResponse(String id, @JsonProperty("html_url") String htmlUrl,
                                 @JsonProperty("private") Boolean isPrivate) {
}
