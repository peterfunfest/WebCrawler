package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for all of the JUnit test cases
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ HTMLReaderTest.class, WebCrawlerTest.class })
public class AllTests {
	
}
