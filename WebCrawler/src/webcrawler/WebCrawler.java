package webcrawler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class WebCrawler {

	private HTMLReader hr;

	private URLList urlsToVisit;
	private URLList urlsVisited;

	WebCrawler(HTMLReader hr) {
		this.hr = hr;
		urlsToVisit = new URLList();
		urlsVisited = new URLList();
	}

	public void visitURL(int level, String url) throws IOException {

		URL u = new URL(url);

		InputStream ins;

		ins = u.openStream();

		// Trundle through the HTML one element at a time.

		while (hr.readUntil(ins, '<', '<')) {
			// Inside an element - may be a closing element - but an element at
			// least.
			String token = hr.readString(ins, ' ', '>');
			if (token != null) {
				System.out.println("ELEMENT: <" + token.trim() + ">");
				token = hr.readString(ins, '=', '>');
				// if (token != null) {
				while (token != null) {
					System.out.println("   ATRBT:" + token.replace(" ","").replace("=",""));
					char nextChar = hr.skipSpace(ins, '>');
					if (nextChar == '"') {
						// Looks like the element value is enclosed in quotes so
						// read to the next double quote.
						// This time there is no need for special terminal test
						// of '>' as it will be valid inside a quote.
						token = hr.readString(ins, '"', '"');
						if (token != null) {
							System.out.println("   VALUE:" + token.substring(0,token.length()-1));
						}
					} else {
						// TODO - element value is not quoted - presents a
						// problem!!
						// need some test cases for this.
					}
					token = hr.readString(ins, '=', '>');
				}
			}
		}

		ins.close();

		// System.out.println(urlsToVisit);

	}

	public void crawl(String url) throws IOException {

		visitURL(1, url);
	}

	public static void main(String[] args) {

		// Refactor the new HTMLReaderImpl bit with either factory method or
		// abstract factory.
		WebCrawler wc = new WebCrawler(new HTMLReaderImpl());

		try {
			wc.crawl("http://www.bbc.co.uk");
			// wc.crawl("http://www.bbk.ac.uk");
			// wc.crawl("http://www.guardian.co.uk");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
