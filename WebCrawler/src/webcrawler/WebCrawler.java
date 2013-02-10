package webcrawler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class WebCrawler {
	
    private HTMLReader hr;
    
    private List<String> urlsToVisit;
    private List<String> urlsVisited;
    
    WebCrawler(HTMLReader hr) {
    	this.hr = hr;
    	urlsToVisit = new ArrayList<String>();
    	urlsVisited = new ArrayList<String>();
    }

	public void visit(int level, String url) throws IOException  {

		URL u = new URL(url);
		InputStream ins = u.openStream();

		while (hr.readUntil(ins, '<', '>')) {
           String line = hr.readString(ins, '>', '>').toLowerCase();
		   if (line.startsWith("a ") && line.toLowerCase().contains("href")) {
	           urlsToVisit.add("<"+line);
		   }
		}
	
		ins.close();
		
		System.out.println(urlsToVisit);

	}

	public void crawl(String url) throws IOException  {

	   visit(1,url);
	}

	public static void main(String[] args) {
		
		// Refactor the new HTMLReaderImpl bit with either factory method or abstract factory.
		WebCrawler wc = new WebCrawler(new HTMLReaderImpl());
		
		try {
			wc.crawl("http://www.dcs.bbk.ac.uk");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
