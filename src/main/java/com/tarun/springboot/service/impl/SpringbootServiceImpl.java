package com.tarun.springboot.service.impl;

import com.tarun.springboot.service.SpringbootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class SpringbootServiceImpl implements SpringbootService {

    @Override
    public String webSearch() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("X-RapidAPI-Key", "58bf538e1bmsh1f2969d21935a20p1e9720jsna7dd7817bac5");
        httpHeaders.set("X-RapidAPI-Host", "contextualwebsearch-websearch-v1.p.rapidapi.com");
        HttpEntity requestEntity = new HttpEntity(httpHeaders);
        String url = "https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/WebSearchAPI?q=taylor&pageNumber=1&pageSize=10&autoCorrect=true";
        log.info("Calling x rapid search API");
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,requestEntity,String.class);
        return responseEntity.getBody();
    }
}
