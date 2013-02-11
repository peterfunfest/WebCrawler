package webcrawler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class CopyOfWebCrawler {

	private HTMLReader hr;

	private URLList urlsToVisit;
	private URLList urlsVisited;

	CopyOfWebCrawler(HTMLReader hr) {
		this.hr = hr;
		urlsToVisit = new URLList();
		urlsVisited = new URLList();
	}

	public void visit(int level, String url) throws IOException {

		URL u = new URL(url);

		InputStream ins;

/*
		if (false) {
			// get rid of this if statement - it's here for debug.
			ins = u.openStream();
			int c;
			while ((c = ins.read()) != -1) {
				System.out.print((char) c);
			}
			ins.close();

			System.out.println("");
			System.out.println("");
			System.out.println("******************");
			System.out.println("******************");
			System.out.println("******************");
			System.out.println("******************");
			System.out.println("");
			System.out.println("");
		}
*/
		
		ins = u.openStream();

		while (hr.readUntil(ins, '<', '<')) {
			// inside an element - may be a closing element - but an element at
			// least.
			String token = hr.readString(ins, ' ', '>');
			if (token != null) {
				if (token.trim().equals("a")) {
					System.out.println("Element: <" + token.trim() + ">");
					token = hr.readString(ins, '=', '>');
					if (token != null) {
						System.out.println(">>>attr:" + token.trim());
						char nextChar = hr.skipSpace(ins, '>');
						if (nextChar=='"') {
							token=hr.readString(ins, '"', '>');
							if (token!=null) {
								System.out.println(">>>value:" + token.trim());
							}
						} else {
							// TODO - element value is not quoted - presents a problem!!
							// need some test cases for this.
						}
					}
				}
			}

		}

		ins.close();

		// System.out.println(urlsToVisit);

	}

	public void crawl(String url) throws IOException {

		visit(1, url);
	}

	public static void main(String[] args) {

		// Refactor the new HTMLReaderImpl bit with either factory method or
		// abstract factory.
		CopyOfWebCrawler wc = new CopyOfWebCrawler(new HTMLReaderImpl());

		try {
			 wc.crawl("http://www.bbc.co.uk");
			// wc.crawl("http://www.bbk.ac.uk");
			//wc.crawl("http://www.guardian.co.uk");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
