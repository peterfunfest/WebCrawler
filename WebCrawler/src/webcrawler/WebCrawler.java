package webcrawler;

import java.io.IOException;
import java.util.Iterator;

public class WebCrawler {

	private int maximumDepth;

	private HTMLReader hTMLReader;

	private URLList uRLList;

	public WebCrawler(HTMLReader hTMLReader, URLList urlsToVisit) {
		this.hTMLReader = hTMLReader;
		this.uRLList = urlsToVisit;
		this.maximumDepth = 1;
	}

	public int getMaximumDepth() {
		return maximumDepth;
	}

	public void setMaximumDepth(int maximumDepth) {
		if (maximumDepth < 1) {
			throw new IllegalArgumentException("maximumDepth must be >= 1.");
		}
		this.maximumDepth = maximumDepth;
	}


	public void crawl(String url) {

		LinkExtractor linkExtractor = new LinkExtractor(hTMLReader);

		uRLList.add(0, url);

		Iterator<URLListElement> uRLListIterator = uRLList.iterator();

		while (uRLListIterator.hasNext()) {

			URLListElement uRLListElement = uRLListIterator.next();

			try {

				if (uRLListElement.getPriority() < maximumDepth) {

				    System.out.println("Visiting (depth=" + uRLListElement.getPriority() + ") - " + uRLListElement.getUrl());
					URLList extractedURLs = linkExtractor.extractLinks(uRLListElement.getPriority(), uRLListElement.getUrl());

					Iterator<URLListElement> extractedURLsIterator = extractedURLs.iterator();

					while (extractedURLsIterator.hasNext()) {
						URLListElement element = extractedURLsIterator.next();
					    uRLList.add(element);
					    System.out.println("   Found " + element.getUrl());
				    }

				}
			} catch (IOException ex) {
				// Display the error, but continue.
				ex.printStackTrace();
			}

		}

	}
	
}
