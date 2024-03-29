package com.webcrawler;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.webcrawler.UrlController;
import com.webcrawler.models.URLRequest;
import com.webcrawler.models.URLRequest.ActionCode;
import com.webcrawler.service.WebCrawlerService;

@RunWith(MockitoJUnitRunner.class)

public class UrlControllerTest {

	@InjectMocks
	UrlController urlController = new UrlController();

	@Mock
	private WebCrawlerService webCrawlerService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void baseTest() throws Exception {

		URLRequest request = URLRequest.builder().action(ActionCode.CRAWL).url("Test.com").maxDepth(12).maxUrls(1000)
				.build();
		urlController.process(
				URLRequest.builder().action(ActionCode.CRAWL).url("Test.com").maxDepth(12).maxUrls(1000).build());
		verify(webCrawlerService, times(1)).crawl(request);

	}
}
