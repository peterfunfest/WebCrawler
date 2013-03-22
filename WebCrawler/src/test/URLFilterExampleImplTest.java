/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import webcrawler.URLFilter;
import application.URLFilterExampleImpl;

/**
 * Test cases for the URLFilterExampleImpl class, accessed via the URLFilter interface
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 * 
 */
public class URLFilterExampleImplTest {
	
	/**
	 * Test method for
	 * {@link application.URLFilterExampleImpl#search(java.lang.String)}. Tests
	 * the case where the search method should return true.
	 */
	@Test
	public void testSearchCaseOne() {
		URLFilter urlFilter = new URLFilterExampleImpl();
		String testFilterString = new String("about");
		boolean valueReturned;
		valueReturned = urlFilter.search(testFilterString);
		assertEquals("Wrong value returned", true, valueReturned);
	}
	
	/**
	 * Test method for
	 * {@link application.URLFilterExampleImpl#search(java.lang.String)}. Tests
	 * the case where the search method should return false.
	 */
	@Test
	public void testSearchCaseTwo() {
		URLFilter urlFilter = new URLFilterExampleImpl();
		String testFilterString = new String("nothing");
		boolean valueReturned;
		valueReturned = urlFilter.search(testFilterString);
		assertEquals("Wrong value returned", false, valueReturned);
	}
	
}
