package com.gopali.fetchFromExternalApiSaveToFile.dto;


public class ExternalItem {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;

    ExternalItem() {

    }

    // Constructor
    public ExternalItem(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    // Getter and Setter for userId
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    // Getter and Setter for id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for body
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
