package application;

import webcrawler.URLFilter;

public class URLFilterExampleImpl implements URLFilter {

	@Override
	public boolean search(String url) {
		return false;
	}

}
