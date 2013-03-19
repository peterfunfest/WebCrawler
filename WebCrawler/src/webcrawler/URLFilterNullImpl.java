package webcrawler;

/**
 * Default implementation of the search method which always returns true,
 * regardless of the URL
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 */

public class URLFilterNullImpl implements URLFilter {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see webcrawler.URLFilter#search(java.lang.String)
	 */
	@Override
	public boolean search(String url) {
		return true;
	}
	
}
