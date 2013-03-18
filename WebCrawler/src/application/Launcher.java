package application;

import webcrawler.HTMLReader;
import webcrawler.HTMLReaderImpl;
import webcrawler.URLFilterNullImpl;
import webcrawler.URLList;
import webcrawler.URLListDBFinalImpl;
import webcrawler.URLListDBTempImpl;
import webcrawler.WebCrawler;

public class Launcher {

	public static void main(String[] args) {

		// TODO - FACTORY HERE!!!!
        // OR EVEN USE SPRING.
		// NEARLY ALL OF THE INJECTION CAN TAKE PLACE HERE... !!!!
		
		HTMLReader hTMLReader = new HTMLReaderImpl();

// Either This
//		URLList    uRLList = new URLListArrayListImpl();
//		((URLListArrayListImpl)uRLList).addObserver(new URLListArrayListObserver("Observer"));
// Or This
		URLList    tempURLList = new URLListDBTempImpl();
		URLList    finalURLList = new URLListDBFinalImpl();

		finalURLList.setuRLFilter(new URLFilterNullImpl());

		WebCrawler wc = new WebCrawler(hTMLReader, tempURLList, finalURLList);

		wc.setMaximumDepth(3);
		wc.crawl("http://www.dcs.bbk.ac.uk/~keith");
//		wc.crawl("http://www.bcc.co.uk/news");

	}

}
