package com.tarun.springboot.model;

import lombok.Data;

import java.util.List;

@Data
public class SearchResp {

    private List<SearchResult> searchResultList;

}
