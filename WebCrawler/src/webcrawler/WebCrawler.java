package webcrawler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.logging.Logger;

public class WebCrawler {

	private final static Logger LOGGER = Logger.getLogger(WebCrawler.class.getName());

	private HTMLReader hr;

	private URLList urlsToVisit;
	private URLList urlsVisited;

	WebCrawler(HTMLReader hr) {
		this.hr = hr;
		urlsToVisit = new URLList();
		urlsVisited = new URLList();
	}

	private String expandURL(URL url, String urlString) {

		if (!urlString.startsWith("http")) {
			return url.getProtocol() + "://" + url.getHost() + url.getPath() + urlString;
//			return url.getProtocol() + "://" + url.getHost() + url.getPort() + url.getPath() + urlString;
//			return url.getProtocol() + "://" + url.getPath() + urlString;
		} else {
			return urlString;
		}

	}

	public URLList visitURL(int level, String url) throws IOException {

		LOGGER.info("Visiting " + url);

		URLList uRLList = new URLList();

		URL u = new URL(url);

//		LOGGER.info("Protocol  : " + u.getProtocol());
//		LOGGER.info("Host      : " + u.getHost());
//		LOGGER.info("Port      : " + u.getPort());
//		LOGGER.info("Path      : " + u.getPath());
//		LOGGER.info("Query     : " + u.getQuery());

//		LOGGER.info("File      : " + u.getFile());
//		LOGGER.info("Dflt Port : " + u.getDefaultPort());

//		LOGGER.info("Ref       : " + u.getRef());
//		LOGGER.info("UserInfo  : " + u.getUserInfo());

		InputStream ins;

		ins = u.openStream();

		// Trundle through the HTML one element at a time.

		while (hr.readUntil(ins, '<', '<')) {

			// Inside an element - may be a closing element - but an element at
			// least.

			String token = hr.readString(ins, ' ', '>');
			String element;
			String attribute;
			String attributeValue;

			if (token != null) {
				element = token.trim();
//				LOGGER.info("ELEMENT" + level + ": <" + element + ">");
				token = hr.readString(ins, '=', '>');
				// if (token != null) {

				while (token != null) {
					attribute = token.replace(" ", "").replace("=", "");
			//		LOGGER.info("   ATTRI:" + attribute);
					char nextChar = hr.skipSpace(ins, '>');
					if (nextChar == '"') {
						// Looks like the element value is enclosed in quotes so
						// read to the next double quote.
						// This time there is no need for special terminal test
						// of '>' as it will be valid inside a quote.
						token = hr.readString(ins, '"', '"');
						if (token != null) {
							if (element.equals("a")) {
								attributeValue = token.substring(0,
										token.length() - 1);
							//	LOGGER.info("   VALUE:" + attributeValue);
							//	LOGGER.info(" X-VALUE:" + expandURL(u, attributeValue));
//								uRLList.add(level, attributeValue);
								uRLList.add(level, expandURL(u, attributeValue));
							}
						}
					} else {
						// TODO - element value is not quoted - presents a
						// problem!!
						// need some test cases for this.
						// ignore for now as it is a rare event - I hope.
						if (element.equals("a")) {
							uRLList.add(level, "TODO-UNKNOWN");
						}
					}
					token = hr.readString(ins, '=', '>');
				}

			}

		}

		ins.close();

		LOGGER.info(uRLList.toString());

		return uRLList;

	}

	public void crawl(String url) {

		urlsToVisit.add(0, url);

		//
		// Because we are about to transmogrify urlsToVisit, we can't iterate
		// over it
		// in the conventional way - lest there is a
		// java.util.ConcurrentModificationException
		// which would drive any normal person to suicide.
		//
		// GOOD JOB I'M NOT NORMAL.
		//
		// ;-)
		//

		int idx = 0;

		while (idx < urlsToVisit.getUrls().size()) {

			try {
				
				URLListElement e = urlsToVisit.getUrls().get(idx);
				URLList visitedUrls = visitURL(e.getPriority() + 1, e.getUrl());
				urlsVisited.add(e);

				Iterator<URLListElement> innterItr = visitedUrls.getUrls()
						.iterator();

				while (innterItr.hasNext()) {
					urlsToVisit.add(innterItr.next());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			idx++;

		}

	}

	public static void main(String[] args) {

		// Refactor the new HTMLReaderImpl bit with either factory method or
		// abstract factory.
		WebCrawler wc = new WebCrawler(new HTMLReaderImpl());

			// wc.crawl("http://localhost:8080/www.bbc.co.uk/this/is/a/path/thisisafile.php?qry=3&qry2=2");
			wc.crawl("http://www.bbc.co.uk");
			// wc.crawl("http://www.bbk.ac.uk");
			// wc.crawl("http://www.guardian.co.uk");

	}

}
