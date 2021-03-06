/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import webcrawler.HTMLReader;
import webcrawler.LinkExtractor;
import webcrawler.URLList;
import webcrawler.URLListArrayListImpl;
import webcrawler.WebCrawlerConfigurationFactory;

/**
 * Test case for the LinkExtractor class
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 * 
 */
public class LinkExtractorTest {
	
	private static HTMLReader hTMLReader;
	private static WebCrawlerConfigurationFactory webCrawlerConfigurationFactory;
	
	/**
	 * Initialise the required objects used in the test
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		webCrawlerConfigurationFactory = WebCrawlerConfigurationFactory
				.getInstance();
		
		hTMLReader = webCrawlerConfigurationFactory.getHTMLReader();
	}
	
	/**
	 * Test method for
	 * {@link webcrawler.LinkExtractor#extractLinks(int, java.lang.String)}.
	 * Ensures links extracted are corrected.
	 */
	@Test
	public void testExtractLinks() {
		
		LinkExtractor linkExtractor = new LinkExtractor(hTMLReader);
		String testURLString = "http://www.dcs.bbk.ac.uk/~iritch01/oodp/PageA.html";
		ArrayList<String> comparisonList = new ArrayList<String>();
		
		ArrayList<String> expectedList = new ArrayList<String>();
		expectedList.add("http://www.dcs.bbk.ac.uk/~iritch01/oodp/PageA.html");
		expectedList.add("http://www.dcs.bbk.ac.uk/~iritch01/oodp/PageB.html");
		expectedList.add("http://www.dcs.bbk.ac.uk/~iritch01/oodp/PageC.html");
		expectedList.add("http://www.dcs.bbk.ac.uk/~iritch01/contact.html");
		
		URLList urlList = new URLListArrayListImpl();
		
		try {
			urlList = linkExtractor.extractLinks(1, testURLString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < urlList.size(); i++) {
			comparisonList.add(urlList.get(i).getUrl());
		}
		
		System.out.println("Expected URLs: " + expectedList.toString());
		System.out.println("Retrieved URLs: " + comparisonList.toString());
		
		System.out.println("Expected List Size = " + expectedList.size());
		System.out.println("Comparison List Size = " + comparisonList.size());
		
		assertEquals("Wrong value returned", expectedList.size(),
				comparisonList.size());
		
		int expectedListOriginalSize = expectedList.size();
		expectedList.retainAll(comparisonList);
		int expectedListNewSize = expectedList.size();
		System.out.println("Expected List Original Size = "
				+ expectedListOriginalSize);
		System.out.println("Expected List New Size = " + expectedListNewSize);
		assertEquals("Wrong value returned", expectedListOriginalSize,
				expectedListNewSize);
		
	}
	
}
