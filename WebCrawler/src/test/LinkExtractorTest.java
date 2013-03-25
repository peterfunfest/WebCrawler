/**
 * 
 */
package test;

import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;
import webcrawler.HTMLReader;
import webcrawler.LinkExtractor;
import webcrawler.URLList;
import webcrawler.URLListArrayListImpl;
import webcrawler.WebCrawlerConfigurationFactory;

/**
 * @author IAINLAPTOP
 * 
 */
public class LinkExtractorTest {
	
	private static HTMLReader hTMLReader;
	private static WebCrawlerConfigurationFactory webCrawlerConfigurationFactory;
	
	/**
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
	 */
	@Test
	public void testExtractLinks() {
		
		LinkExtractor linkExtractor = new LinkExtractor(hTMLReader);
		//String testURLString = "http://www.dcs.bbk.ac.uk/~iritch01/oodp/PageA.html";
		String testURLString = "http://www.dcs.bbk.ac.uk/~iritch01/index.html";
		
		
		URLList uRLList = new URLListArrayListImpl();
		
		try {
			uRLList = linkExtractor.extractLinks(1, testURLString);
		} catch (IOException e) {
				e.printStackTrace();
		}
		
		System.out.println("URL = ");
		System.out.println(uRLList.get(0).getUrl().toString());
		
	}
	
}
