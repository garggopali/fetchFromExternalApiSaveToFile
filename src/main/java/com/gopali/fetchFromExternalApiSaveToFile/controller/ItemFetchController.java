package com.gopali.fetchFromExternalApiSaveToFile.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopali.fetchFromExternalApiSaveToFile.dto.ExternalItem;
import com.gopali.fetchFromExternalApiSaveToFile.model.ProcessedPost;
import com.gopali.fetchFromExternalApiSaveToFile.service.ExternalPostService;

@RestController
public class ItemFetchController {

    private final ExternalPostService externalItemService;

    public ItemFetchController(ExternalPostService externalItemService) {
        this.externalItemService = externalItemService;
    }

    @GetMapping("/fetch-posts")
    public List<ExternalItem> getPosts() {
        return externalItemService.fetchPosts();
    }

    @PostMapping("/sync-posts")
    public String syncPosts() {
        externalItemService.fetchTransformAndSave();
        return "Posts fetched and saved to H2 database.";
    }

    @GetMapping("/processed-posts")
    public List<ProcessedPost> getAllProcessed() {
        return externalItemService.getAllProcessedPosts();
    }

}
