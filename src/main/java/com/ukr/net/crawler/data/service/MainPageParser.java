package com.ukr.net.crawler.data.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ukr.net.crawler.data.config.LinksConfig;
import com.ukr.net.crawler.data.model.FeedTopic;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainPageParser {

    private final LinksConfig links;
    
    public FeedTopic findAndReturnFeedTopics() throws IOException {
        
        List<String> listOfLinks = new ArrayList<>(links.linksOfTopics().keySet());
                
        return new FeedTopic(listOfLinks);
    }
}