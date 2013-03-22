package test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import webcrawler.URLListElement;

/**
 * Test cases for the URLListElement class
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 * 
 */
public class URLListElementTest {
	
	static URLListElement urlListElementGet;
	static URLListElement urlListElementSet;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		urlListElementGet = new URLListElement(1, "TestURL");
		urlListElementSet = new URLListElement(2, "TestURL2");
	}
	
	/**
	 * Test method for {@link webcrawler.URLListElement#getPriority()}.
	 */
	@Test
	public void testGetPriority() {
		int ID = urlListElementGet.getPriority();
		assertEquals("Wrong Value Returned", 1, ID);
		
	}
	
	/**
	 * Test method for {@link webcrawler.URLListElement#setPriority(int)}.
	 */
	@Test
	public void testSetPriority() {
		urlListElementSet.setPriority(3);
		int ID = urlListElementSet.getPriority();
		assertEquals("Wrong Value Returned", 3, ID);
	}
	
	/**
	 * Test method for {@link webcrawler.URLListElement#getUrl()}.
	 */
	@Test
	public void testGetUrl() {
		String url = urlListElementGet.getUrl();
		assertEquals("Wrong Value Returned", "TestURL", url);
	}
	
	/**
	 * Test method for
	 * {@link webcrawler.URLListElement#setUrl(java.lang.String)}.
	 */
	@Test
	public void testSetUrl() {
		urlListElementSet.setUrl("TestURL3");
		String url = urlListElementSet.getUrl();
		assertEquals("Wrong Value Returned", "TestURL3", url);
	}
	
	/**
	 * Test method for {@link webcrawler.URLListElement#toString()}.
	 */
	@Test
	public void testToString() {
		String toString = urlListElementGet.toString();
		assertEquals("Wrong Value Returned", "Priority:1, url:TestURL",
				toString);
		
	}
	
}
