package webcrawler;

import java.util.Iterator;

/**
 * Interface which provides access to the underlying list of URLs during the
 * crawl, either through non-persistent in memory storage or through persistent
 * storage in a database
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 */

public interface URLList {
	
	/**
	 * Add URL to list
	 * 
	 * @param priority
	 *            Priority of the URL
	 * @param url
	 *            The URL
	 * @return True if the URL is added successfully and false otherwise
	 */
	public boolean add(int priority, String url);
	
	/**
	 * Add a URL as a URLListElement
	 * 
	 * @param e
	 *            The URLListElement to add
	 * @return True if the URLListElement is added successfully and false
	 *         otherwise
	 */
	public boolean add(URLListElement e);
	
	/**
	 * String representation of the URLList
	 * 
	 * @return A string representation of the URLList
	 */
	public String toString();
	
	/**
	 * Get the URLListElement based on the ID
	 * 
	 * @param idx
	 *            The ID of the URLListElement sought
	 * @return The URLList element requested based on the ID supplied
	 */
	public URLListElement get(int idx);
	
	/**
	 * Get the size of the URLList
	 * 
	 * @return The size of the URLList
	 */
	public int size();
	
	/**
	 * Gets the URLFilter
	 * 
	 * @return The URLFilter
	 */
	public URLFilter getuRLFilter();
	
	/**
	 * Sets the URLFilter
	 * 
	 * @param uRLFilter
	 *            The URLFilter to set
	 */
	public void setuRLFilter(URLFilter uRLFilter);
	
	/**
	 * Provide access to Iterator for the list
	 * 
	 * @return Iterator for the list
	 */
	public Iterator<URLListElement> iterator();
	
}
