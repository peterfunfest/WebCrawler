<<<<<<< HEAD
/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import webcrawler.HTMLReader;
import webcrawler.HTMLReaderImpl;

/**
 * @author IAINLAPTOP
 * 
 */
public class HTMLReaderTest {

	private static InputStream testInputStream;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readUntil(java.io.InputStream, char, char)}.
	 */
	@Test
	public void testReadUntilTestOne() {
		String testInputString = "<html this is fun - no it isn't />";
		try {
			testInputStream = new ByteArrayInputStream(
					testInputString.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		HTMLReader htmlReader = new HTMLReaderImpl();
		boolean returnedValue = false;
		char ch1;
		char ch2;

		// Checks the case where ch1 is encountered and ch2 is not
		ch1 = 'h';
		ch2 = 'z';
		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, true);

		// Checks the case where ch1 is encountered and ch2 is not, checking for case sensitivity
		ch1 = 'H';
		ch2 = 'z';
		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, true);

		// Checks the case where ch1 is not encountered and ch2 is.
		ch1 = 'z';
		ch2 = 'h';
		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, false);

		// Checks the case where ch1 and ch2 are the same, with neither in the stream
		ch1 = 'z';
		ch2 = 'z';
		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, false);

		
		// Checks the case where ch1 and ch2 are the same, with ch1 and ch2 in the stream
		ch1 = 'h';
		ch2 = 'h';
		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, true);
		

	}

	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#skipSpace(java.io.InputStream, char)}.
	 */
	@Test
	public void testSkipSpace() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readString(java.io.InputStream, char, char)}
	 * .
	 */
	@Test
	public void testReadString() {
		fail("Not yet implemented"); // TODO
	}

}
=======
/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import webcrawler.HTMLReader;
import webcrawler.HTMLReaderImpl;

/**
 * @author IAINLAPTOP
 * 
 */
public class HTMLReaderTest {

	private static InputStream testInputStream;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readUntil(java.io.InputStream, char, char)}.
	 */
	@Test
	public void testReadUntilTestOne() {
		String testInputString = "<html this is fun - no it isn't />";
		try {
			testInputStream = new ByteArrayInputStream(
					testInputString.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		HTMLReader htmlReader = new HTMLReaderImpl();
		boolean returnedValue = false;
		char ch1;
		char ch2;

		// Checks the case where ch1 is encountered and ch2 is not
		ch1 = 'h';
		ch2 = 'z';
		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, true);

		// Checks the case where ch1 is encountered and ch2 is not, checking for case sensitivity
		ch1 = 'H';
		ch2 = 'z';
		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, true);

		// Checks the case where ch1 is not encountered and ch2 is.
		ch1 = 'z';
		ch2 = 'h';
		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, false);

		// Checks the case where ch1 and ch2 are the same, with ch1 in the
		// stream
		ch1 = 'h';
		ch2 = 'h';
		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, true);
		
		// Checks the case where ch1 and ch2 are the same, with neither in the stream
		ch1 = 'z';
		ch2 = 'z';
		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, true);

	}

	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#skipSpace(java.io.InputStream, char)}.
	 */
	@Test
	public void testSkipSpace() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readString(java.io.InputStream, char, char)}
	 * .
	 */
	@Test
	public void testReadString() {
		fail("Not yet implemented"); // TODO
	}

}
>>>>>>> branch 'master' of https://github.com/peterfunfest/WebCrawler.git
