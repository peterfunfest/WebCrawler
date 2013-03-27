/**
 * 
 */
package test;

import static org.junit.Assert.*;
import org.junit.Test;
import webcrawler.URLFilter;
import webcrawler.URLFilterNullImpl;

/**
 * Test cases for the URLFilterNullImpl class, accessed via the URLFilter
 * interface
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 * 
 */
public class URLFilterNullImplTest {
	
	/**
	 * Test method for
	 * {@link webcrawler.URLFilterNullImpl#search(java.lang.String)}. Ensures
	 * that all URLs passed through this search method return as true.
	 */
	@Test
	public void testSearch() {
		
		URLFilter urlFilter = new URLFilterNullImpl();
		assertTrue(urlFilter.search("Test Search String"));
		assertTrue(urlFilter.search("This should always return true"));
		
	}
	
}
