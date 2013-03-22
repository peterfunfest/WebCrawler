/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import model.Temporaryurllist;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test cases for the DBUtil class
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 * 
 */
public class TemporaryurllistTest {
	
	static Temporaryurllist temporaryURLListGet;
	static Temporaryurllist temporaryURLListSet;
	
	/**
	 * Create an instance of Temporaryurllist to test the get methods, and
	 * another to test the set methods
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		temporaryURLListGet = new Temporaryurllist();
		temporaryURLListGet.setId(1);
		temporaryURLListGet.setPriority(1);
		temporaryURLListGet.setUrl("TestURL");
		temporaryURLListSet = new Temporaryurllist();
		
	}
	
	/**
	 * Test method for {@link model.Temporaryurllist#getId()}. Tests the get
	 * method for the ID.
	 */
	@Test
	public void testGetId() {
		int ID = temporaryURLListGet.getId();
		assertEquals("Wrong Value Returned", 1, ID);
	}
	
	/**
	 * Test method for {@link model.Temporaryurllist#setId(int)}. Tests the set
	 * method for the ID.
	 */
	@Test
	public void testSetId() {
		temporaryURLListSet.setId(2);
		int ID = temporaryURLListSet.getId();
		assertEquals("Wrong Value Returned", 2, ID);
	}
	
	/**
	 * Test method for {@link model.Temporaryurllist#getPriority()}. Tests the
	 * get method for the priority.
	 */
	@Test
	public void testGetPriority() {
		int priority = temporaryURLListGet.getPriority();
		assertEquals("Wrong Value Returned", 1, priority);
	}
	
	/**
	 * Test method for {@link model.Temporaryurllist#setPriority(int)}. Tests
	 * the set method for the priority.
	 */
	@Test
	public void testSetPriority() {
		temporaryURLListSet.setPriority(2);
		int priority = temporaryURLListSet.getPriority();
		assertEquals("Wrong Value Returned", 2, priority);
	}
	
	/**
	 * Test method for {@link model.Temporaryurllist#getUrl()}. Tests the get
	 * method for the URL.
	 */
	@Test
	public void testGetUrl() {
		String url = temporaryURLListGet.getUrl();
		assertEquals("Wrong Value Returned", "TestURL", url);
	}
	
	/**
	 * Test method for {@link model.Temporaryurllist#setUrl(java.lang.String)}.
	 * Tests the set method for the URL.
	 */
	@Test
	public void testSetUrl() {
		temporaryURLListSet.setUrl("TestURL");
		String url = temporaryURLListSet.getUrl();
		assertEquals("Wrong Value Returned", "TestURL", url);
	}
	
}
