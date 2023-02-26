package com.tarun.springboot.model.externalApiModels;

import lombok.Data;

import java.util.List;

@Data
public class SearchAPIResp {
    private String  _type;
    private String  didUMean;
    private String  totalCount;
    private List<String> relatedSearch;
    private List<SearchAPIResults>  value;
}
