package webcrawler;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

public class WebCrawler {

	private final static int MAXIMUM_DEPTH = 2;

	private HTMLReader hr;

	private URLList urlsToVisit;
	private URLList urlsVisited;

	WebCrawler(HTMLReader hr) {
		this.hr = hr;
		urlsToVisit = new URLList();
		urlsVisited = new URLList();
	}

	private String expandURL2(URL url, String urlString) throws MalformedURLException  {
	// WORKING ON - alternative implementation
        String result = new URL(url,urlString).toString();
//		System.out.println("URL:"+url.toString());
	//	System.out.println("REL:"+urlString);
		//System.out.println("  =:"+result);
	    return result;
	}
	
	private String expandURL(URL url, String urlString) {

		if (urlString != null && !urlString.startsWith("http")) {
			return url.getProtocol()
					+ "://"
					+ url.getHost()
					+ ((url.getPort() == -1) ? "" : url.getPort())
					+ ((url.getPath().endsWith("/")) ? url.getPath().substring(0, url.getPath().length() - 1) : url.getPath())
					+ ((!urlString.equals("") && urlString.charAt(0) == '/') ? urlString : "/" + urlString);
		} else {
			return urlString;
		}

	}

	public URLList extractLinks(int level, String url) throws IOException {

		System.out.println("Extracting " + level + " - " + url);

		URLList uRLList = new URLList();

		URL u = new URL(url);

		InputStream ins;

		ins = u.openStream();

		// Traverse the HTML one element at a time.

		while (hr.readUntil(ins, '<', '<')) {

			// Inside an element - may be a closing element - but an element at
			// least.

			String token = hr.readString(ins, ' ', '>');
			String element;
			String attribute;
			String attributeValue = null;

			if (token != null) {
				
				element = token.trim();

				if (element.equals("a")) {

					token = hr.readString(ins, '=', '>');

					while (token != null) {
						
						attribute = token.replace(" ", "").replace("=", "");
						
						if (attribute.equals("href")) {
							
							char nextChar = hr.skipSpace(ins, '>');
							
							if (nextChar == '"') {
								// Looks like the element value is enclosed in quotes so
								// read to the next double quote.
								// This time there is no need for special terminal
								// test of '>' as it will be valid inside a quote.
								token = hr.readString(ins, '"', '"');
								if (token != null) {
									attributeValue = token.substring(0,token.length() - 1);
								}
								
							} else {

								// Element value is not quoted 
								token = hr.readString(ins, ' ', '>');
								attributeValue = token;

							}
							
//							System.out.println("   " + element + "-" + attribute
	//								+ "-" + attributeValue);

//							uRLList.add(level+1, expandURL(u,attributeValue));
							uRLList.add(level+1, expandURL2(u,attributeValue));
							

						}

						token = hr.readString(ins, '=', '>');
					}

				}

			}

		}

		ins.close();

		for (URLListElement e : uRLList.getUrls()) {
			System.out.println("   " + e.toString());
		}

		return uRLList;

	}

	public void crawl(String url) {

		urlsToVisit.add(0, url);

		//
		// Because we are about to transmogrify urlsToVisit, we can't iterate
		// over it in the conventional way - lest there is a
		// java.util.ConcurrentModificationException
		//

		int idx = 0;

		while (idx < urlsToVisit.getUrls().size()) {

			try {

				URLListElement e = urlsToVisit.getUrls().get(idx);

				if (e.getPriority() < MAXIMUM_DEPTH) {

					URLList extractedURLs = extractLinks(e.getPriority(),
							e.getUrl());
					urlsVisited.add(e);

					Iterator<URLListElement> innerItr = extractedURLs.getUrls()
							.iterator();

					while (innerItr.hasNext()) {
						urlsToVisit.add(innerItr.next());
					}

				}
			} catch (IOException e) {
				// Display the error, but continue.
				e.printStackTrace();
			}

			idx++;

		}

	}

}
