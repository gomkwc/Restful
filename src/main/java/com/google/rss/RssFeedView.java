package com.google.rss;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.google.bean.Fruit;
import com.sun.syndication.feed.rss.Content;
import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Item;

public class RssFeedView extends AbstractRssFeedView {

	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed,
			HttpServletRequest request) {

		feed.setTitle("Sample Title");
		feed.setDescription("Sample Description");
		feed.setLink("http://google.com");

		super.buildFeedMetadata(model, feed, request);
	}

	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Fruit fruit = (Fruit) model.get("model");
		String msg = fruit.getName() + fruit.getQuality();

		List<Item> items = new ArrayList<Item>(1);
		Item item = new Item();
		item.setAuthor("Test");
		item.setLink("http://www.google.com");

		Content content = new Content();
		content.setValue(msg);
		item.setContent(content);

		items.add(item);

		return items;
	}
}