package com.ukr.net.crawler.data.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeedTopic {

    private List<String> catalog = new ArrayList<>();
}
