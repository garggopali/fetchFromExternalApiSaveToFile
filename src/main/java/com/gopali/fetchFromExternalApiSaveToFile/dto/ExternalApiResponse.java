package com.gopali.fetchFromExternalApiSaveToFile.dto;

import java.util.List;

public class ExternalApiResponse {
    private List<ExternalItem> items;

    // Constructor
    public ExternalApiResponse(List<ExternalItem> items) {
        this.items = items;
    }

    // Getter
    public List<ExternalItem> getItems() {
        return items;
    }

    // Setter
    public void setItems(List<ExternalItem> items) {
        this.items = items;
    }

}
