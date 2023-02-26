package com.tarun.springboot.model.externalApiModels;

import lombok.Data;

@Data
public class SearchAPIResults {
    private String  id;
    private String  title;
    private String  didUMean;
    private String  url;
    private String  description;
    private String body;
    private String  snippet;
    private String  keywords;
    private String  language;
    private String  isSafe;
    private String  datePublished;
    private Object  provider;
    private Object  image;


}
