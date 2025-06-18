package com.gopali.fetchFromExternalApiSaveToFile.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gopali.fetchFromExternalApiSaveToFile.dto.ExternalItem;
import com.gopali.fetchFromExternalApiSaveToFile.model.ProcessedPost;
import com.gopali.fetchFromExternalApiSaveToFile.repository.ProcessedPostRepository;

@Service
public class ExternalPostService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ProcessedPostRepository postRepository;

    public ExternalPostService(ProcessedPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<ExternalItem> fetchPosts() {
        String apiUrl = "https://jsonplaceholder.typicode.com/posts";

        ResponseEntity<List<ExternalItem>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ExternalItem>>() {
                });

        return response.getBody(); // List of posts
    }

    // step 2 -transform and save to h2 file
    public void fetchTransformAndSave() {
        String apiUrl = "https://jsonplaceholder.typicode.com/posts";

        ResponseEntity<List<ExternalItem>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        List<ExternalItem> externalPosts = response.getBody();

        // Transform data (e.g., shorten body to 100 characters)
List<ProcessedPost> processedPosts = externalPosts.stream()
    .map(post -> new ProcessedPost(
        post.getTitle().toUpperCase(),
        post.getBody().length() > 100
            ? post.getBody().substring(0, 100) + "..."
            : post.getBody()
    )) // ✅ THIS closing parenthesis was missing
    .collect(Collectors.toList());

        postRepository.saveAll(processedPosts);
    }

    public List<ProcessedPost> getAllProcessedPosts() {
        return postRepository.findAll();
    }
}
