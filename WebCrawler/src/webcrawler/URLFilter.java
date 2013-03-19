package webcrawler;

/**
 * Interface which provides method to implement alternative search method as
 * required
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 */

public interface URLFilter {
	
	/**
	 * Search method for the URL
	 * 
	 * @param url
	 *            The URL to evaluate
	 * @return True if URL passes search and false otherwise
	 */
	boolean search(String url);
	
}
