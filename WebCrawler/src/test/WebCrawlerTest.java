/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import model.Finalurllist;

import org.junit.BeforeClass;
import org.junit.Test;

import webcrawler.HTMLReader;
import webcrawler.URLList;
import webcrawler.URLListElement;
import webcrawler.WebCrawler;
import webcrawler.WebCrawlerConfigurationFactory;
import db.DatabaseUtil;

/**
 * Test cases for WebCrawler class
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 * 
 */
public class WebCrawlerTest {
	
	private static WebCrawler wc;
	private static WebCrawlerConfigurationFactory webCrawlerConfigurationFactory;
	private static URLList tempURLList;
	private static URLList finalURLList;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		webCrawlerConfigurationFactory = WebCrawlerConfigurationFactory
				.getInstance();
		
		HTMLReader hTMLReader = webCrawlerConfigurationFactory.getHTMLReader();
		
		tempURLList = webCrawlerConfigurationFactory.getTempURLList();
		tempURLList.setuRLFilter(webCrawlerConfigurationFactory
				.getTempURLFilter());
		
		finalURLList = webCrawlerConfigurationFactory.getFinalURLList();
		finalURLList.setuRLFilter(webCrawlerConfigurationFactory
				.getFinalURLFilter());
		
		wc = new WebCrawler(hTMLReader, tempURLList, finalURLList);
		
		wc.setMaximumDepth(webCrawlerConfigurationFactory.getMaximumDepth());
		wc.setMaximumDistinctURLs(webCrawlerConfigurationFactory
				.getMaximumDistinctURLs());
		
	}
	
	/**
	 * Test method for {@link webcrawler.WebCrawler#getMaximumDepth()}.
	 */
	@Test
	public void testGetMaximumDepth() {
		
		WebCrawler wc = new WebCrawler();
		wc.setMaximumDepth(5);
		assertEquals("Wrong value returned", 5, wc.getMaximumDepth());
	}
	
	/**
	 * Test method for {@link webcrawler.WebCrawler#setMaximumDepth(int)}.
	 */
	@Test
	public void testSetMaximumDepth() {
		WebCrawler wc = new WebCrawler();
		wc.setMaximumDepth(5);
		assertEquals("Wrong value returned", 5, wc.getMaximumDepth());
	}
	
	/**
	 * Test method for {@link webcrawler.WebCrawler#getMaximumDistinctURLs()}.
	 */
	@Test
	public void testGetMaximumDistinctURLs() {
		WebCrawler wc = new WebCrawler();
		wc.setMaximumDistinctURLs(1000);
		assertEquals("Wrong value returned", 1000, wc.getMaximumDistinctURLs());
	}
	
	/**
	 * Test method for {@link webcrawler.WebCrawler#setMaximumDistinctURLs(int)}
	 * .
	 */
	@Test
	public void testSetMaximumDistinctURLs() {
		WebCrawler wc = new WebCrawler();
		wc.setMaximumDistinctURLs(1000);
		assertEquals("Wrong value returned", 1000, wc.getMaximumDistinctURLs());
	}
	
	/**
	 * Test method for {@link webcrawler.WebCrawler#crawl(java.lang.String)}.
	 */
	@Test
	public void testCrawl() {
		
		wc.setMaximumDepth(2);
		wc.crawl("http://www.dcs.bbk.ac.uk/~iritch01/oodp/PageA.html");
		
		System.out.println("Done");
		
		ArrayList<URLListElement> expectedList = new ArrayList<URLListElement>();
		expectedList.add(new URLListElement(0,
				"http://www.dcs.bbk.ac.uk/~iritch01/oodp/PageA.html"));
		
		expectedList.add(new URLListElement(1,
				"http://www.dcs.bbk.ac.uk/~iritch01/oodp/PageB.html"));
		expectedList.add(new URLListElement(1,
				"http://www.dcs.bbk.ac.uk/~iritch01/oodp/PageC.html"));
		
		expectedList.add(new URLListElement(1,
				"http://www.dcs.bbk.ac.uk/~iritch01/contact.html"));
		expectedList.add(new URLListElement(2,
				"http://www.dcs.bbk.ac.uk/~iritch01/oodp/PageD.html"));
		expectedList.add(new URLListElement(3,
				"http://www.dcs.bbk.ac.uk/~iritch01/oodp/PageE.html"));
		expectedList.add(new URLListElement(3,
				"http://www.dcs.bbk.ac.uk/~iritch01/oodp/PageF.html"));
		
		ArrayList<URLListElement> retrievedList = new ArrayList<URLListElement>();
		
		DatabaseUtil dbUtil = new DatabaseUtil();
		List<Finalurllist> finalUrlList = dbUtil.queryFinalURLList();
		
		for (int i = 0; i < finalUrlList.size(); i++) {
			retrievedList.add(new URLListElement(finalUrlList.get(i)
					.getPriority(), finalUrlList.get(i).getUrl()));
		}
		
		System.out.println("Expected URLs: " + expectedList.toString());
		System.out.println("Retrieved URLs: " + retrievedList.toString());
		
		System.out.println("Expected List Size = " + expectedList.size());
		System.out.println("Comparison List Size = " + retrievedList.size());
		
		assertEquals("Wrong value returned", expectedList.size(),
				retrievedList.size());
		
		int expectedListOriginalSize = expectedList.size();
		expectedList.retainAll(retrievedList);
		int expectedListNewSize = expectedList.size();
		System.out.println("Expected List Original Size = "
				+ expectedListOriginalSize);
		System.out.println("Expected List New Size = " + expectedListNewSize);
		assertEquals("Wrong value returned", expectedListOriginalSize,
				expectedListNewSize);
		
	}
	
}
