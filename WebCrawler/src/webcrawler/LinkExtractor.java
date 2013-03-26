package webcrawler;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Manages link extraction and URL expansion
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 */

public class LinkExtractor {

	private HTMLReader hTMLReader;

	/**
	 * Constructor - Set the instance of HTMLReader to be used
	 * 
	 * @param hTMLReader
	 *            The instance of HTMLReader to be used
	 */
	public LinkExtractor(HTMLReader hTMLReader) {
		this.sethTMLReader(hTMLReader);
	}

	/**
	 * Gets the instance of HTMLReader currently being used
	 * 
	 * @return The instance of HTMLReader currently being used
	 */
	private HTMLReader gethTMLReader() {
		return hTMLReader;
	}

	/**
	 * Sets the instance of HTMLReader to be used
	 * 
	 * @param hTMLReader
	 *            The instance of HTMLReader to use
	 */
	private void sethTMLReader(HTMLReader hTMLReader) {
		this.hTMLReader = hTMLReader;
	}

	/**
	 * Expands the URL
	 * 
	 * @param url
	 *            The URL to expand
	 * @param urlString
	 *            The string representation of the URL to expand
	 * @return The expanded URL
	 */
	private String expandURL(URL url, String urlString)
			throws MalformedURLException {

		String rv = urlString;
		
		if (urlString != null) {

			int protocolPtr = urlString.indexOf(':');
		
			String protocol = null;
		
			if (protocolPtr != -1) {
				protocol = urlString.substring(0, protocolPtr);			
			}
		
			if (protocol != null && !protocol.equals("http")) {
				return urlString;
			}
		
			try {

				while (urlString.startsWith("/")) {
					urlString = urlString.substring(1);
				}

				String baseRef = url.toString();

				if (baseRef.lastIndexOf('.') > baseRef.lastIndexOf('/')) {
					// last part of url is a file reference
					rv = new URL(url, urlString).toString();
				} else {
					// last part of url is a path reference so check it ends
					// with a '/' character.
					if ((baseRef.lastIndexOf("/") + 1) < baseRef.length()) {
						url = new URL(baseRef + "/");
						rv = new URL(url, urlString).toString();
					} else {
						rv = new URL(url, urlString).toString();
					}
				}

				return (rv);

			} catch (Exception e) {

				System.out.println("ERROR: baseref:" + url.toString() + ", url:" + urlString);
				e.printStackTrace();

			}

		}

		return rv;
	}

	/**
	 * Extract the links for a URL
	 * 
	 * @param level
	 *            The level of the URL
	 * @param urlString
	 *            The string representation of the URL
	 * @return List of URLs found
	 * @throws IOException
	 */
	public URLList extractLinks(int level, String urlString) throws IOException {

		URLList uRLList = new URLListArrayListImpl();

		URL url = new URL(urlString);

		InputStream ins;

		ins = url.openStream();

		// Traverse the HTML one element at a time.

		while (this.gethTMLReader().readUntil(ins, '<', '<')) {

			// Inside an element - may be a closing element - but an element at
			// least.

			String token = this.gethTMLReader().readString(ins, ' ', '>');
			String element;
			String attribute;
			String attributeValue = null;

			if (token != null) {

				element = token.trim();

				if (element.equals("a")) {

					token = this.gethTMLReader().readString(ins, '=', '>');

					while (token != null) {

						attribute = token.replace(" ", "").replace("=", "");

						if (attribute.equals("href")) {

							char nextChar = this.gethTMLReader().skipSpace(ins,'>');

							if (nextChar == '"') {
								// Looks like the element value is enclosed in
								// quotes so
								// read to the next double quote.
								// This time there is no need for special
								// terminal
								// test of '>' as it will be valid inside a
								// quote.
								token = this.gethTMLReader().readString(ins,
										'"', '"');
								if (token != null) {
									attributeValue = token.substring(0,token.length() - 1);
								}

							} else {

								// Element value is not quoted
								token = this.gethTMLReader().readString(ins,
										' ', '>');
								attributeValue = token;

							}

							String expandedURL = expandURL(url, attributeValue);

							if (expandedURL != null && expandedURL.startsWith("http:")) {
								uRLList.add(level + 1, expandedURL);
							}

						}

						token = this.gethTMLReader().readString(ins, '=', '>');
					}

				}

			}

		}

		ins.close();

		return uRLList;

	}

}
