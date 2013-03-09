package application;

import webcrawler.HTMLReader;
import webcrawler.HTMLReaderImpl;
import webcrawler.URLList;
import webcrawler.URLListDBTempImpl;
import webcrawler.WebCrawler;

public class Launcher {

	public static void main(String[] args) {

		// TODO - FACTORY HERE!!!!

		HTMLReader hTMLReader = new HTMLReaderImpl();

// Either This
//		URLList    uRLList = new URLListArrayListImpl();
//		((URLListArrayListImpl)uRLList).addObserver(new URLListArrayListObserver("Observer"));
// Or This
		URLList    uRLList = new URLListDBTempImpl();
		
		WebCrawler wc = new WebCrawler(hTMLReader, uRLList);

		wc.setMaximumDepth(3);
		wc.crawl("http://www.dcs.bbk.ac.uk/~keith");
//		wc.crawl("http://www.bcc.co.uk/news");

	}

}
