package com.demo.hystrix.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchResponse {


    private String documentd;

    private SearchRequest searchRequest;

    private List<SearchPromise> searchPromises;


    @JsonCreator
    public SearchResponse(@JsonProperty("docId")String documentd,
                          @JsonProperty("searchRequest")SearchRequest searchRequest,
                          @JsonProperty("promises")List<SearchPromise> searchPromises) {
        this.documentd = documentd;
        this.searchRequest = searchRequest;
        this.searchPromises = searchPromises;
    }

    public String getDocumentd() {
        return documentd;
    }

    public SearchRequest getSearchRequest() {
        return searchRequest;
    }

    public List<SearchPromise> getSearchPromises() {
        return searchPromises;
    }
}
