package com.example.demo.controller;

import com.example.demo.client.GithubClient;
import com.example.demo.dto.RepositoryResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1")
public class GithubController {

    private GithubClient githubClient;

    public GithubController(GithubClient githubClient) {
        this.githubClient = githubClient;
    }


    @GetMapping("/repos")
    public ResponseEntity<List<RepositoryResponse>> listRepos(@RequestHeader("token") String token) {

        var repos = githubClient.listRepos("Bearer " + token, null, "public");

        return ResponseEntity.ok(repos);
    }
}
