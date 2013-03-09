package test;

import static org.junit.Assert.assertEquals;

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

		assertEquals("Wrong value returned", true, returnedValue);

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

		assertEquals("Wrong value returned", true, returnedValue);
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

		assertEquals("Wrong value returned", false, returnedValue);
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

		assertEquals("Wrong value returned", false, returnedValue);
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

		assertEquals("Wrong value returned", false, returnedValue);
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

		assertEquals("Wrong value returned", false, returnedValue);
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
		assertEquals("Wrong value returned", false, returnedValue);
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

		assertEquals("Wrong value returned", true, returnedValue);

	}

	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#skipSpace(java.io.InputStream, char)}.
	 * Test for the case where ch1 is not found and the first non-whitespace character is returned.
	 */
	@Test
	public void testSkipSpaceCaseOne() {
		
		String testInputString = "<html this is fun - no it isn't />";
		char ch1 = 'h';
		char returnedValue = ' ';
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.skipSpace(testInputStream, ch1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", '<', returnedValue);

	}
	
	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#skipSpace(java.io.InputStream, char)}.
	 * Test for the case where ch1 is not found and the first non-whitespace character is returned.
	 * This time the InputStream has whitespace at the start
	 */
	@Test
	public void testSkipSpaceCaseTwo() {
		
		String testInputString = " <html this is fun - no it isn't />";
		char ch1 = 'h';
		char returnedValue = ' ';
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.skipSpace(testInputStream, ch1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", "<", returnedValue);

	}
	
	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#skipSpace(java.io.InputStream, char)}.
	 * Tests for the case where ch1 is encountered and the smallest possible value for a char is returned
	 */
	@Test
	public void testSkipSpaceCaseThree() {
		
		String testInputString = "<html this is fun - no it isn't />";
		char ch1 = '<';
		char returnedValue = ' ';
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.skipSpace(testInputStream, ch1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", Character.MIN_VALUE, returnedValue);

	}
	
	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#skipSpace(java.io.InputStream, char)}.
	 * Tests for the case where ch1 is encountered and the smallest possible value for a char is returned
	 * This time with whitespace at the start
	 */
	@Test
	public void testSkipSpaceCaseFour() {
		
		String testInputString = " <html this is fun - no it isn't />";
		char ch1 = '<';
		char returnedValue = ' ';
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.skipSpace(testInputStream, ch1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", Character.MIN_VALUE, returnedValue);

	}
	
	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#skipSpace(java.io.InputStream, char)}.
	 * Tests for the case where the inputStream supplied is null
	 * NOT SURE HOW WE HANDLE THIS ONE!
	 */
	@Test
	public void testSkipSpaceCaseFive() {
		
		char ch1 = '<';
		char returnedValue = ' ';
		testInputStream = null;
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.skipSpace(testInputStream, ch1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", Character.MIN_VALUE, returnedValue);

	}
	
	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#skipSpace(java.io.InputStream, char)}.
	 * Tests for the case where the InputSteam is an empty string
	 * NOT SURE HOW WE HANDLE THIS ONE!
	 */
	@Test
	public void testSkipSpaceCaseSix() {
		
		String testInputString = "";
		char ch1 = '<';
		char returnedValue = ' ';
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.skipSpace(testInputStream, ch1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", Character.MIN_VALUE, returnedValue);

	}
	
	
	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#skipSpace(java.io.InputStream, char)}.
	 * Tests for the case where the InputSteam contains only white space
	 * NOT SURE HOW WE HANDLE THIS ONE!
	 */
	@Test
	public void testSkipSpaceCaseSeven() {
		
		String testInputString = "    ";
		char ch1 = '<';
		char returnedValue = ' ';
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.skipSpace(testInputStream, ch1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", Character.MIN_VALUE, returnedValue);

	}
	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readString(java.io.InputStream, char, char)}
	 * Tests the base case where ch1 is encountered, and a string is returned containing all of the characters that have been read
	 */
	@Test
	public void testReadStringCaseOne() {
		
		String testInputString = "<html this is fun - no it isn't />";
		char ch1 = 't';
		char ch2 = 'z';
		String returnedValue = "";
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.readString(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", "<ht", returnedValue);
	}

	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readString(java.io.InputStream, char, char)}
	 * Tests the case where ch2 is encountered and a null string is returned.
	 */
	@Test
	public void testReadStringCaseTwo() {
		
		String testInputString = "<html this is fun - no it isn't />";
		char ch1 = 'z';
		char ch2 = 't';
		String returnedValue = "";
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.readString(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", null, returnedValue);
	}
	
	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readString(java.io.InputStream, char, char)}
	 * Exception case where the input stream submitted is null
	 */
	@Test
	public void testReadStringCaseThree() {
		
		char ch1 = 'z';
		char ch2 = 't';
		String returnedValue = "";
		testInputStream = null;
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.readString(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", null, returnedValue);
	}
	
	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readString(java.io.InputStream, char, char)}
	 * Exception case where neither ch1 or ch2 is found
	 */
	@Test
	public void testReadStringCaseFour() {
		
		String testInputString = "<html this is fun - no it isn't />";
		char ch1 = 'z';
		char ch2 = 'z';
		String returnedValue = "";
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.readString(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", "<html this is fun - no it isn't />", returnedValue );
	}
	
	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readString(java.io.InputStream, char, char)}
	 * Tests the base case where ch1 is encountered, and a string is returned containing all of the characters that have been read
	 * This time with leading whitespace
	 */
	@Test
	public void testReadStringCaseFive() {
		
		String testInputString = "   <html this is fun - no it isn't />";
		char ch1 = 't';
		char ch2 = 'z';
		String returnedValue = "";
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.readString(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", "   <ht", returnedValue);
	}
	
	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readString(java.io.InputStream, char, char)}
	 * Tests the base case where ch1 is encountered, and a string is returned containing all of the characters that have been read
	 * This time checking that case is ignored
	 */
	@Test
	public void testReadStringCaseSix() {
		
		String testInputString = "<html This is fun - no it isn't />";
		char ch1 = 'T';
		char ch2 = 'z';
		String returnedValue = "";
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.readString(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", "<html T", returnedValue);
	}
	
	/**
	 * Test method for
	 * {@link webcrawler.HTMLReader#readString(java.io.InputStream, char, char)}
	 * Tests the case where ch2 is encountered and a null string is returned.
	 * This time making sure the case is ignored
	 */
	@Test
	public void testReadStringCaseSeven() {
		
		String testInputString = "<html This is fun - no it isn't />";
		char ch1 = 'z';
		char ch2 = 'T';
		String returnedValue = "";
		getInputStream(testInputString);
		HTMLReader htmlReader = new HTMLReaderImpl();

		try {
			returnedValue = htmlReader.readString(testInputStream, ch1, ch2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Wrong value returned", null, returnedValue);
	}
	
}
