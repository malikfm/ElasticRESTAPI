package com.malik.ElasticRESTAPI.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.malik.ElasticRESTAPI.model.NewsModel;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {
    public List<NewsModel> getAll(TransportClient elasticClient) throws IOException {
        List<NewsModel> data = new ArrayList<>();
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();

        SearchResponse response = elasticClient
                .prepareSearch("testen")
                .setQuery(queryBuilder)
                .setSize(100)
                .get();

        for (SearchHit searchHit : response.getHits().getHits()) {
            data.add(new ObjectMapper().readValue(searchHit.getSourceAsString(), NewsModel.class));
        }

        return data;
    }

    public List<NewsModel> getByQuery(TransportClient elasticClient, String category, String headline, String authors, String shortDescription, String date) throws IOException {
        List<NewsModel> data = new ArrayList<>();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

        if (!category.isEmpty())
            boolQueryBuilder.must(QueryBuilders.matchQuery("category", category));
        if (!headline.isEmpty())
            boolQueryBuilder.must(QueryBuilders.matchQuery("headline", headline));
        if (!authors.isEmpty())
            boolQueryBuilder.must(QueryBuilders.matchQuery("authors", authors));
        if (!shortDescription.isEmpty())
            boolQueryBuilder.must(QueryBuilders.matchQuery("short_description", shortDescription));
        if (!date.isEmpty())
            boolQueryBuilder.must(QueryBuilders.matchQuery("date", date));

        SearchResponse response = elasticClient
                .prepareSearch("testen")
                .setQuery(boolQueryBuilder)
                .setSize(100)
                .get();

        for (SearchHit searchHit : response.getHits().getHits()) {
            data.add(new ObjectMapper().readValue(searchHit.getSourceAsString(), NewsModel.class));
        }

        return data;
    }
}
