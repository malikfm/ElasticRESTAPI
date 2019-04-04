package com.malik.ElasticRESTAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsModel {
    private String category;
    private String headline;
    private String authors;
    private String link;

    @JsonProperty("short_description")
    private String shortDescription;

    private String date;
    private String id;

    public String getCategory() {
        return category;
    }

    public String getHeadline() {
        return headline;
    }

    public String getAuthors() {
        return authors;
    }

    public String getLink() {
        return link;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }
}
