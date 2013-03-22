/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import model.Finalurllist;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test cases for the DBUtil class
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 * 
 */
public class FinalurllistTest {
	
	static Finalurllist finalURLListGet;
	static Finalurllist finalURLListSet;
	
	/**
	 * Create an instance of Finalurllist to test the get methods, and another
	 * to test the set methods
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		finalURLListGet = new Finalurllist();
		finalURLListGet.setId(1);
		finalURLListGet.setPriority(1);
		finalURLListGet.setUrl("TestURL");
		finalURLListSet = new Finalurllist();
		
	}
	
	/**
	 * Test method for {@link model.Finalurllist#getId()}. Tests the get method
	 * for the ID.
	 */
	@Test
	public void testGetId() {
		int ID = finalURLListGet.getId();
		assertEquals("Wrong Value Returned", 1, ID);
	}
	
	/**
	 * Test method for {@link model.Finalurllist#setId(int)}. Tests the set
	 * method for the ID.
	 */
	@Test
	public void testSetId() {
		finalURLListSet.setId(2);
		int ID = finalURLListSet.getId();
		assertEquals("Wrong Value Returned", 2, ID);
	}
	
	/**
	 * Test method for {@link model.Finalurllist#getPriority()}. Tests the get
	 * method for the priority.
	 */
	@Test
	public void testGetPriority() {
		int priority = finalURLListGet.getPriority();
		assertEquals("Wrong Value Returned", 1, priority);
	}
	
	/**
	 * Test method for {@link model.Finalurllist#setPriority(int)}. Tests the
	 * set method for the priority.
	 */
	@Test
	public void testSetPriority() {
		finalURLListSet.setPriority(2);
		int priority = finalURLListSet.getPriority();
		assertEquals("Wrong Value Returned", 2, priority);
	}
	
	/**
	 * Test method for {@link model.Finalurllist#getUrl()}. Tests the get method
	 * for the URL.
	 */
	@Test
	public void testGetUrl() {
		String url = finalURLListGet.getUrl();
		assertEquals("Wrong Value Returned", "TestURL", url);
	}
	
	/**
	 * Test method for {@link model.Finalurllist#setUrl(java.lang.String)}.
	 * Tests the set method for the URL.
	 */
	@Test
	public void testSetUrl() {
		finalURLListSet.setUrl("TestURL");
		String url = finalURLListSet.getUrl();
		assertEquals("Wrong Value Returned", "TestURL", url);
	}
	
}
