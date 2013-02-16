package webcrawler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class URLList {

	private List<URLListElement> urls;

	public URLList() {
		urls = new ArrayList<URLListElement>();
	}

	public URLList add(int priority, String url) {
		return this.add(new URLListElement(priority, url));
	}

	public URLList add(URLListElement e) {
		urls.add(e);
		return this;
	}

	public URLList remove(URLListElement e) {
		urls.remove(urls.indexOf(e));
		return this;
	}

	public String toString() {
		return urls.toString();
	}

	public List<URLListElement> getUrls() {
		return this.urls;
	}

}