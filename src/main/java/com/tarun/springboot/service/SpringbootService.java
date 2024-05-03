package com.tarun.springboot.service;

import com.tarun.springboot.model.SearchResp;

import java.io.IOException;
import java.util.Map;

public interface SpringbootService {

    public SearchResp webSearch();

    Map<String, Object> streamingCountries() throws IOException;
}
