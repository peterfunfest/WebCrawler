package application;

import webcrawler.HTMLReader;
import webcrawler.URLList;
import webcrawler.WebCrawler;
import webcrawler.WebCrawlerConfigurationFactory;

/**
 * Launcher for the application, utlising Factory pattern for injecting various
 * configurable elements
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 * 
 */

public class Launcher {
	
	/**
	 * Main launch method for the application
	 * 
	 * @param args
	 *            Unused
	 */
	public static void main(String[] args) {
		
		WebCrawlerConfigurationFactory webCrawlerConfigurationFactory = WebCrawlerConfigurationFactory
				.getInstance();
		
		HTMLReader hTMLReader = webCrawlerConfigurationFactory.getHTMLReader();
		
		URLList tempURLList = webCrawlerConfigurationFactory.getTempURLList();
		tempURLList.setuRLFilter(webCrawlerConfigurationFactory
				.getTempURLFilter());
		
		URLList finalURLList = webCrawlerConfigurationFactory.getFinalURLList();
		finalURLList.setuRLFilter(webCrawlerConfigurationFactory
				.getFinalURLFilter());
		
		WebCrawler wc = new WebCrawler(hTMLReader, tempURLList, finalURLList);
		
		wc.setMaximumDepth(webCrawlerConfigurationFactory.getMaximumDepth());
		wc.setMaximumDistinctURLs(webCrawlerConfigurationFactory
				.getMaximumDistinctURLs());
		
		wc.crawl(webCrawlerConfigurationFactory.getStartURL());
		
	}
	
}
