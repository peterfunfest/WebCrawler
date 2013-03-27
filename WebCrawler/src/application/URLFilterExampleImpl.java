package application;

import webcrawler.URLFilter;

/**
 * Example implementation of the search method which can be substituted as
 * required through dependency injection, setting an alternative implementation
 * via a configuration file
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 * 
 */
public class URLFilterExampleImpl implements URLFilter {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see webcrawler.URLFilter#search(java.lang.String)
	 */
	@Override
	public boolean search(String url) {
		return (url.toLowerCase().contains("about"));
	}
	
}
