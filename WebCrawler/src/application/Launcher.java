package application;

import webcrawler.HTMLReader;
import webcrawler.URLList;
import webcrawler.WebCrawler;
import webcrawler.WebCrawlerConfigurationFactory;

public class Launcher {

	public static void main(String[] args) {

		WebCrawlerConfigurationFactory webCrawlerFactory = WebCrawlerConfigurationFactory.getInstance();

		HTMLReader hTMLReader = webCrawlerFactory.getHTMLReader();

		URLList tempURLList = webCrawlerFactory.getTempURLList();
		tempURLList.setuRLFilter(webCrawlerFactory.getTempURLFilter());

		URLList finalURLList = webCrawlerFactory.getFinalURLList();
		finalURLList.setuRLFilter(webCrawlerFactory.getFinalURLFilter());

		WebCrawler wc = new WebCrawler(hTMLReader, tempURLList, finalURLList);

		wc.setMaximumDepth(webCrawlerFactory.getMaximumDepth());
		wc.setMaximumDistinctURLs(webCrawlerFactory.getMaximumDistinctURLs());

		wc.crawl(webCrawlerFactory.getStartURL());

	}

}
