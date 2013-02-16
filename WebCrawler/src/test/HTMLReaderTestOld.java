package test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * I am canning this class to use the eclipse generated Junit template instead, just to keep things consistent.
 * Will be deleted eventually.
 */

public class HTMLReaderTestOld {

	private static InputStream testInputStream;
	
	// Template pinched from wikipedia
	
	    @BeforeClass
	    public static void setUpClass() throws Exception {
	        // Code executed before the first test method 
	    	String testInputString="<html this is fun - no it isn't />";       
	        testInputStream = new ByteArrayInputStream(testInputString.getBytes("UTF-8"));
	    }
	 
	    @Before
	    public void setUp() throws Exception {
	        // Code executed before each test    
	    }
	 
	    @Test
	    public void testOneThing() {
	        // Code that tests one thing
	    }
	 
	    @Test
	    public void testAnotherThing() {
	        // Code that tests another thing
	    }
	 
	    @Test
	    public void testSomethingElse() {
	        // Code that tests something else
	    }
	 
	    @After
	    public void tearDown() throws Exception {
	        // Code executed after each test   
	    }
	 
	    @AfterClass
	    public static void tearDownClass() throws Exception {
	        // Code executed after the last test method 
	    }

}
