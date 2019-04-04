package com.malik.ElasticRESTAPI.controller;

import com.malik.ElasticRESTAPI.model.NewsModel;
import com.malik.ElasticRESTAPI.service.NewsService;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class NewsController {
    private TransportClient elasticClient;
    private NewsService newsService;

    @Autowired
    public NewsController(TransportClient elasticClient, NewsService newsService) {
        this.elasticClient = elasticClient;
        this.newsService = newsService;
    }

    @GetMapping("/all")
    public List<NewsModel> getAll() throws IOException {
        return newsService.getAll(elasticClient);
    }

    @GetMapping("/query")
    public List<NewsModel> getByQuery(@RequestParam(defaultValue = "") String category,
                                      @RequestParam(defaultValue = "") String headline,
                                      @RequestParam(defaultValue = "") String authors,
                                      @RequestParam(defaultValue = "", name = "desc") String shortDescription,
                                      @RequestParam(defaultValue = "") String date) throws IOException {
        return newsService.getByQuery(elasticClient, category, headline, authors, shortDescription, date);
    }
}
