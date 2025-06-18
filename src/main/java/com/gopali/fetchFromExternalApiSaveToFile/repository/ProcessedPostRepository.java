package com.gopali.fetchFromExternalApiSaveToFile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopali.fetchFromExternalApiSaveToFile.model.ProcessedPost;

public interface ProcessedPostRepository extends JpaRepository<ProcessedPost, Long> {

}
