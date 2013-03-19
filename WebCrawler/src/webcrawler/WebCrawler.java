package webcrawler;

import java.io.IOException;
import java.util.Iterator;

/**
 * Starts and managed the crawl process with corresponding crawl depth
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 */

public class WebCrawler {
	
	private int maximumDepth;
	private int maximumDistinctURLs;
	
	private HTMLReader hTMLReader;
	private URLList tempURLList;
	private URLList finalURLList;
	
	/**
	 * Constructor - Sets the instances of HTMLReader, and the temporary and
	 * final URLList to be used
	 * 
	 * @param hTMLReader
	 *            The HTMLReader instance to be used
	 * @param tempURLList
	 *            The URLList to be used for temporary URLs
	 * @param finalURLList
	 *            The URLList to be used for final URLs
	 */
	public WebCrawler(HTMLReader hTMLReader, URLList tempURLList,
			URLList finalURLList) {
		this.hTMLReader = hTMLReader;
		this.tempURLList = tempURLList;
		this.finalURLList = finalURLList;
		this.maximumDepth = 0;
		this.maximumDistinctURLs = 1;
	}
	
	/**
	 * Get the maximum depth of the crawler
	 * 
	 * @return The maximum depth of the crawler
	 */
	public int getMaximumDepth() {
		return maximumDepth;
	}
	
	/**
	 * Set the maximum depth of the crawler
	 * 
	 * @param maximumDepth
	 *            The maximum depth of the crawler, which should be greater than
	 *            0
	 */
	public void setMaximumDepth(int maximumDepth) {
		if (maximumDepth < 0) {
			throw new IllegalArgumentException("maximumDepth must be >= 0.");
		}
		this.maximumDepth = maximumDepth;
	}
	
	/**
	 * Get the maximum number of distinct URLs
	 * 
	 * @return The maximum number of distinct URLs
	 */
	public int getMaximumDistinctURLs() {
		return maximumDistinctURLs;
	}
	
	/**
	 * Set the maximum number of distinct URLs
	 * 
	 * @param maximumDistinctURLs
	 *            The maximum number of distinct URLs which should be at least 1
	 */
	public void setMaximumDistinctURLs(int maximumDistinctURLs) {
		if (maximumDistinctURLs < 1) {
			throw new IllegalArgumentException(
					"maximumDistinctURLs must be >= 1.");
		}
		this.maximumDistinctURLs = maximumDistinctURLs;
	}
	
	/**
	 * Start the crawl from a URL
	 * 
	 * @param url
	 *            The base URL to start the crawl from
	 */
	public void crawl(String url) {
		
		LinkExtractor linkExtractor = new LinkExtractor(hTMLReader);
		
		tempURLList.add(0, url);
		
		System.out.println("\n\nCRAWLING: " + url + "\n\n");
		
		Iterator<URLListElement> tempURLListIterator = tempURLList.iterator();
		
		while (tempURLListIterator.hasNext()
				&& tempURLList.size() < getMaximumDistinctURLs()) {
			
			URLListElement uRLListElement = tempURLListIterator.next();
			
			try {
				
				if (uRLListElement.getPriority() <= maximumDepth) {
					
					System.out.println("Visiting (depth="
							+ uRLListElement.getPriority() + ") - "
							+ uRLListElement.getUrl());
					URLList extractedURLs = linkExtractor.extractLinks(
							uRLListElement.getPriority(),
							uRLListElement.getUrl());
					
					Iterator<URLListElement> extractedURLsIterator = extractedURLs
							.iterator();
					
					while (extractedURLsIterator.hasNext()
							&& tempURLList.size() < getMaximumDistinctURLs()) {
						URLListElement element = extractedURLsIterator.next();
						if (tempURLList.add(element)) {
							System.out.println("   Found       "
									+ element.getUrl());
						} else {
							System.out.println("   Found (DUP) "
									+ element.getUrl());
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
