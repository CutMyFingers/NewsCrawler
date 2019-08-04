package com.ukr.net.crawler.api.contoller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ukr.net.crawler.data.model.Feed;
import com.ukr.net.crawler.data.model.FeedProperties;
import com.ukr.net.crawler.data.model.FeedTopic;
import com.ukr.net.crawler.data.service.MainPageParser;
import com.ukr.net.crawler.data.service.SourcePageParser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/catalog")
public class RequestHandler {

    private final MainPageParser mainPageParser;
    private final SourcePageParser soursePageParser;

    @GetMapping
    public FeedTopic getFeedTopics() throws IOException {
        return mainPageParser.findAndReturnFeedTopics();
    }

    @PostMapping("/topic")
    public List<Feed> getFeedsFromSize(@RequestBody FeedProperties feedProperties) throws IOException {
        return soursePageParser.findAndReturngetFeedsFromSize(feedProperties);
    }
}