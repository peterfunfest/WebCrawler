package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import webcrawler.HTMLReader;
import webcrawler.URLFilter;
import webcrawler.URLFilterNullImpl;
import webcrawler.URLList;
import webcrawler.URLListDBFinalImpl;
import webcrawler.URLListDBTempImpl;
import webcrawler.WebCrawlerConfigurationFactory;

public class WebCrawlerConfigurationFactoryTest {
	
	@Test
	public void testGetInstance() {
		WebCrawlerConfigurationFactory instance1 = WebCrawlerConfigurationFactory.getInstance();
		WebCrawlerConfigurationFactory instance2 = WebCrawlerConfigurationFactory.getInstance();
		assertEquals("Wrong Value Returned", instance1, instance2);
	}
	
	@Test
	public void testGetHTMLReader() {
		HTMLReader htmlReader = WebCrawlerConfigurationFactory.getInstance().getHTMLReader();
		assertTrue("Wrong Value Returned", htmlReader instanceof HTMLReader);
	}
	
	@Test
	public void testGetTempURLList() {
		URLList tempUrlList = WebCrawlerConfigurationFactory.getInstance().getTempURLList();
		assertTrue("Wrong Value Returned", tempUrlList instanceof URLListDBTempImpl);
	}
	
	@Test
	public void testGetFinalURLList() {
		URLList finalUrlList = WebCrawlerConfigurationFactory.getInstance().getFinalURLList();
		assertTrue("Wrong Value Returned", finalUrlList instanceof URLListDBFinalImpl);
	}
	
	@Test
	public void testGetTempURLFilter() {
		URLFilter tempUrlFilter = WebCrawlerConfigurationFactory.getInstance().getTempURLFilter();
		assertTrue("Wrong Value Returned", tempUrlFilter instanceof URLFilterNullImpl );
	}
	
	@Test
	public void testGetFinalURLFilter() {
		URLFilter finalUrlFilter = WebCrawlerConfigurationFactory.getInstance().getFinalURLFilter();
		assertTrue("Wrong Value Returned", finalUrlFilter instanceof URLFilterNullImpl );
	}
	
	@Test
	public void testGetMaximumDepth() {
		int maximumDepth = WebCrawlerConfigurationFactory.getInstance().getMaximumDepth();
		assertEquals("Wrong Value Returned", 2, maximumDepth);
	}
	
	@Test
	public void testGetMaximumDistinctURLs() {
		int maximumDistinctUrls = WebCrawlerConfigurationFactory.getInstance().getMaximumDistinctURLs();
		assertEquals("Wrong Value Returned", 2000, maximumDistinctUrls);
	}
	
	@Test
	public void testGetStartURL() {
		String startUrl = WebCrawlerConfigurationFactory.getInstance().getStartURL();
		assertEquals("Wrong Value Returned", "http://www.dcs.bbk.ac.uk/~keith", startUrl);
	}
	
}
