package webcrawler;

public class Launcher {

	public static void main(String[] args) {

		// TODO
		// Refactor the new HTMLReaderImpl bit with either factory method or
		// abstract factory. That would be fun.

		WebCrawler wc = new WebCrawler(new HTMLReaderImpl());

		// wc.crawl("http://localhost:8080/www.bbc.co.uk/this/is/a/path/thisisafile.php?qry=3&qry2=2");
		//wc.crawl("http://www.bbc.co.uk");
		// wc.crawl("http://www.bbk.ac.uk");
		// wc.crawl("http://www.guardian.co.uk");
		// wc.crawl("http://www.cwjobs.co.uk");
		// wc.crawl("http://www.searchenginejournal.com/25-ways-to-get-penalized-in-2012/47245/");
		 wc.crawl("http://www.dcs.bbk.ac.uk/~keith");

	}

}
