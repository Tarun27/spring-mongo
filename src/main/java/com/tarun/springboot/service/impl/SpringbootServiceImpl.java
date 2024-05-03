package com.tarun.springboot.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tarun.springboot.model.SearchResult;
import com.tarun.springboot.model.externalApiModels.SearchAPIResp;
import com.tarun.springboot.model.SearchResp;
import com.tarun.springboot.service.SpringbootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SpringbootServiceImpl implements SpringbootService {

    @Value("${spring.rapidAPI.url}")
    private String url;
    @Value("${spring.rapidAPI.headers.key}")
    private String key;
    @Value("${spring.rapidAPI.headers.key-val}")
    String keyVal;
    @Value("${spring.rapidAPI.headers.host}")
    String host;
    @Value("${spring.rapidAPI.headers.host-val}")
    String hostVal;


   // @Override
    public SearchResp webSearch() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.set(key, keyVal);
        httpHeaders.set(host, hostVal);

        HttpEntity requestEntity = new HttpEntity(httpHeaders);
        log.info("Calling x rapid search API");
        ResponseEntity<SearchAPIResp> responseEntity = restTemplate.exchange(url, HttpMethod.GET,requestEntity
                ,SearchAPIResp.class);
        SearchResp resp = new SearchResp();
        resp.setSearchResultList(responseEntity.getBody().getValue().stream().map(val->{
            SearchResult searchResult = new SearchResult();
            searchResult.setBody(val.getBody());
            searchResult.setSnippet(val.getSnippet());
            searchResult.setDescription(val.getDescription());
            return searchResult;
        }).collect(Collectors.toList()));

        return resp;
    }


     public Map<String, Object> streamingCountries() throws IOException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://streaming-availability.p.rapidapi.com/countries"))
                .header("X-RapidAPI-Key", "58bf538e1bmsh1f2969d21935a20p1e9720jsna7dd7817bac5")
                .header("X-RapidAPI-Host", "streaming-availability.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> jsonResponse = null;
        ObjectMapper objectMapper = new ObjectMapper();


        try {
            jsonResponse = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Map<String, Object> jsonMap = objectMapper.readValue(jsonResponse.body(), Map.class);

        //System.out.println(response.body());

         return jsonMap;
     }
}
