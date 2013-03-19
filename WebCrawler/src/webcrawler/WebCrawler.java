package webcrawler;

import java.io.IOException;
import java.util.Iterator;

public class WebCrawler {

	private int maximumDepth;
	private int maximumDistinctURLs;

	private HTMLReader hTMLReader;
	private URLList tempURLList;
	private URLList finalURLList;

	public WebCrawler(HTMLReader hTMLReader, URLList tempURLList, URLList finalURLList) {
		this.hTMLReader = hTMLReader;
		this.tempURLList = tempURLList;
		this.finalURLList = finalURLList;
		this.maximumDepth = 1;
		this.maximumDistinctURLs = 1;
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

	public int getMaximumDistinctURLs() {
		return maximumDistinctURLs;
	}

	public void setMaximumDistinctURLs(int maximumDistinctURLs) {
		if (maximumDistinctURLs < 1) {
			throw new IllegalArgumentException("maximumDistinctURLs must be >= 1.");
		}
		this.maximumDistinctURLs = maximumDistinctURLs;
	}

	public void crawl(String url) {

		LinkExtractor linkExtractor = new LinkExtractor(hTMLReader);

		tempURLList.add(0, url);

	    System.out.println("\n\nCRAWLING: " + url + "\n\n");

	    Iterator<URLListElement> tempURLListIterator = tempURLList.iterator();

		while (tempURLListIterator.hasNext() && tempURLList.size() < getMaximumDistinctURLs()) {

			URLListElement uRLListElement = tempURLListIterator.next();

			try {

				if (uRLListElement.getPriority() <=+ maximumDepth) {

				    System.out.println("Visiting (depth=" + uRLListElement.getPriority() + ") - " + uRLListElement.getUrl());
					URLList extractedURLs = linkExtractor.extractLinks(uRLListElement.getPriority(), uRLListElement.getUrl());

					Iterator<URLListElement> extractedURLsIterator = extractedURLs.iterator();

					while (extractedURLsIterator.hasNext() && tempURLList.size() < getMaximumDistinctURLs()) {
						URLListElement element = extractedURLsIterator.next();
						if (tempURLList.add(element)) {
						    System.out.println("   Found       " + element.getUrl());							
						} else {
						    System.out.println("   Found (DUP) " + element.getUrl());														
						}
				    }

				}

			} catch (IOException ex) {

				// Display the error, but continue.
				ex.printStackTrace();
			}

		}

		Iterator<URLListElement> tempURLListIterator2 = tempURLList.iterator();

		while (tempURLListIterator2.hasNext()) {
			finalURLList.add(tempURLListIterator.next());
		}

	}

}
