package com.gopali.fetchFromExternalApiSaveToFile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopali.fetchFromExternalApiSaveToFile.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
