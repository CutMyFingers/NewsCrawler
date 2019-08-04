package com.ukr.net.crawler.data.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.ukr.net.crawler.data.config.LinksConfig;
import com.ukr.net.crawler.data.model.Feed;
import com.ukr.net.crawler.data.model.FeedProperties;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SourcePageParser {

    private final LinksConfig links;

    public List<Feed> findAndReturngetFeedsFromSize(FeedProperties feedProperties) throws IOException {

        String linkOfTitle = links.linksOfTopics().get(feedProperties.getName()).toString();

        Document doc = Connector.connectURLAndReturnReadContext(linkOfTitle + "/page/" + feedProperties.getPage() + "/");

        Elements feeds = doc.select("a.post-link");

        List<Feed> listOfFeeds = new ArrayList<>();
        for (Element feed : feeds) {
            listOfFeeds.add(new Feed(feed.text(), feed.attr("href")));
        }

        return listOfFeeds;
    }
}
