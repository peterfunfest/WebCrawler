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
 * @author Peter Hayes, Iain Ritchie JUnit test cases for HTMLReader Need to
 *         refactor so that each test contains one assertion Currently if an
 *         assertion fails it does not proceed to the next.
 */

public class HTMLReaderTest {

	private static InputStream testInputStream;
	private static boolean returnedValue;

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
	 * Checks the case where ch1 is encountered and ch2 is not, checking for
	 * case sensitivity
	 */
	@Test
	public void testReadUntilCaseOne() {
		String testInputString = "<html this is fun - no it isn't />";
		char ch1 = 'H';
		char ch2 = 'z';
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, true);

	}

	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readUntil(java.io.InputStream, char, char)}.
	 * Checks the case where ch1 and ch2 are the same, with ch1 and ch2 in the
	 * stream
	 */
	@Test
	public void testReadUntilCaseEight() {
		String testInputString = "<html this is fun - no it isn't />";
		char ch1 = 'h';
		char ch2 = 'h';
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, true);
	}

	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readUntil(java.io.InputStream, char, char)}.
	 * Tests the case where InputStream is a space character
	 */
	@Test
	public void testReadUntilCaseSeven() {
		String testInputString = " ";
		char ch1 = 'h';
		char ch2 = 'h';

		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, false);
	}

	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readUntil(java.io.InputStream, char, char)}.
	 * Test the case where InputStream is an empty string
	 */
	@Test
	public void testReadUntilCaseSix() {
		String testInputString = "";
		char ch1 = 'h';
		char ch2 = 'h';

		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, false);
	}

	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readUntil(java.io.InputStream, char, char)}.
	 * Test the case where InputStream is null
	 */
	@Test
	public void testReadUntilCaseFive() {
		char ch1 = 'h';
		char ch2 = 'h';

		testInputStream = null;
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, false);
	}

	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readUntil(java.io.InputStream, char, char)}.
	 * Checks the case where ch1 and ch2 are the same, with neither in the
	 * stream
	 */
	@Test
public void testReadUntilCaseFour() {
		String testInputString = "<html this is fun - no it isn't />";
		char ch1 = 'z';
		char ch2 = 'z';
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", returnedValue, false);
	}

	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readUntil(java.io.InputStream, char, char)}.
	 * Checks the case where ch1 is not encountered and ch2 is.
	 */
	@Test
	public void testReadUntilCaseThree() {
		String testInputString = "<html this is fun - no it isn't />";
		char ch1 = 'z';
		char ch2 = 'h';
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();
		try {
			returnedValue = htmlReader.readUntil(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals("Wrong value returned", returnedValue, false);
	}

	/**
	 * @param testInputString
	 */
	private void getInputStream(String testInputString) {
		try {
			testInputStream = new ByteArrayInputStream(
					testInputString.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readUntil(java.io.InputStream, char, char)}.
	 * Checks the case where ch1 is encountered and ch2 is not
	 */

	@Test
	public void testReadUntilCaseTwo() {
		String testInputString = "<html this is fun - no it isn't />";
		char ch1 = 'h';
		char ch2 = 'z';
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

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