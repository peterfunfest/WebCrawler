/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.List;

import model.Finalurllist;
import model.Temporaryurllist;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.DatabaseUtil;

/**
 * Test cases for the DBUtil class
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 * 
 */
public class DatabaseUtilTest {
	
	/**
	 * Clean up the database after executing test
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		DatabaseUtil databaseUtil = new DatabaseUtil();
		databaseUtil.deleteAllFromTemporaryTable();
		databaseUtil.deleteAllFromFinalTable();
	}
	
	/**
	 * Clean up the database after executing test
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		DatabaseUtil databaseUtil = new DatabaseUtil();
		databaseUtil.deleteAllFromTemporaryTable();
		databaseUtil.deleteAllFromFinalTable();
	}
	

	/**
	 * Test method for
	 * {@link db.DatabaseUtil#insertRecordTemporaryTable(int, java.lang.String, int)}
	 * 
	 * . Tests the insertion of records in the temporary URL table.
	 */
	@Test
	public void testInsertRecordTemporaryTable() {
		DatabaseUtil databaseUtil = new DatabaseUtil();
		databaseUtil.insertRecordTemporaryTable(1, "URL1", 1);
		databaseUtil.insertRecordTemporaryTable(2, "URL2", 2);
		List<Temporaryurllist> list = databaseUtil.queryTemporaryURLList();
		
		assertEquals("Wrong Value Returned", 2, list.size());
		
		assertEquals("Wrong Value Returned", 1, list.get(0).getId());
		assertEquals("Wrong Value Returned", "URL1", list.get(0).getUrl());
		assertEquals("Wrong Value Returned", 1, list.get(0).getPriority());
		
		assertEquals("Wrong Value Returned", 2, list.get(1).getId());
		assertEquals("Wrong Value Returned", "URL2", list.get(1).getUrl());
		assertEquals("Wrong Value Returned", 2, list.get(1).getPriority());
	}
	
	/**
	 * Test method for
	 * {@link db.DatabaseUtil#insertRecordFinalTable(int, java.lang.String, int)}
	 * . Tests for the insertion of record in the final URL table.
	 */
	@Test
	public void testInsertRecordFinalTable() {
		DatabaseUtil databaseUtil = new DatabaseUtil();
		databaseUtil.insertRecordFinalTable(1, "URL1", 1);
		databaseUtil.insertRecordFinalTable(2, "URL2", 2);
		List<Finalurllist> list = databaseUtil.queryFinalURLList();
		
		assertEquals("Wrong Value Returned", 2, list.size());
		
		assertEquals("Wrong Value Returned", 1, list.get(0).getId());
		assertEquals("Wrong Value Returned", "URL1", list.get(0).getUrl());
		assertEquals("Wrong Value Returned", 1, list.get(0).getPriority());
		
		assertEquals("Wrong Value Returned", 2, list.get(1).getId());
		assertEquals("Wrong Value Returned", "URL2", list.get(1).getUrl());
		assertEquals("Wrong Value Returned", 2, list.get(1).getPriority());
	}
	
	/**
	 * Test method for {@link db.DatabaseUtil#getTemporaryURLListById(int)}. Tests for the retrieval of records in the temporary URL table based on a supplied ID.
	 */
	@Test
	public void testGetTemporaryURLListById() {
		DatabaseUtil databaseUtil = new DatabaseUtil();
		databaseUtil.insertRecordTemporaryTable(1, "URL1", 1);
		databaseUtil.insertRecordTemporaryTable(2, "URL2", 2);
		Temporaryurllist url1 = databaseUtil.getTemporaryURLListById(1);
		Temporaryurllist url2 = databaseUtil.getTemporaryURLListById(2);
		
		assertEquals("Wrong Value Returned", 1, url1.getId());
		assertEquals("Wrong Value Returned", "URL1", url1.getUrl());
		assertEquals("Wrong Value Returned", 1, url1.getPriority());
		
		assertEquals("Wrong Value Returned", 2, url2.getId());
		assertEquals("Wrong Value Returned", "URL2", url2.getUrl());
		assertEquals("Wrong Value Returned", 2, url2.getPriority());
	}
	
	
	/**
	 * Test method for {@link db.DatabaseUtil#getFinalURLListById(int)}. Tests for the retrieval of records in the final URL table based on a supplied ID.
	 */
	@Test
	public void testGetFinalURLListById() {
		DatabaseUtil databaseUtil = new DatabaseUtil();
		databaseUtil.insertRecordFinalTable(1, "URL1", 1);
		databaseUtil.insertRecordFinalTable(2, "URL2", 2);
		Finalurllist url1 = databaseUtil.getFinalURLListById(1);
		Finalurllist url2 = databaseUtil.getFinalURLListById(2);
		
		assertEquals("Wrong Value Returned", 1, url1.getId());
		assertEquals("Wrong Value Returned", "URL1", url1.getUrl());
		assertEquals("Wrong Value Returned", 1, url1.getPriority());
		
		assertEquals("Wrong Value Returned", 2, url2.getId());
		assertEquals("Wrong Value Returned", "URL2", url2.getUrl());
		assertEquals("Wrong Value Returned", 2, url2.getPriority());
	}
	
	/**
	 * Test method for {@link db.DatabaseUtil#queryTemporaryURLList()}. Tests for the retrieval of all record from the temporary URL table.
	 */
	@Test
	public void testQueryTemporaryURLList() {
		DatabaseUtil databaseUtil = new DatabaseUtil();
		databaseUtil.insertRecordTemporaryTable(1, "URL1", 1);
		databaseUtil.insertRecordTemporaryTable(2, "URL2", 2);
		List<Temporaryurllist> list = databaseUtil.queryTemporaryURLList();
		
		assertEquals("Wrong Value Returned", 2, list.size());
		
		assertEquals("Wrong Value Returned", 1, list.get(0).getId());
		assertEquals("Wrong Value Returned", "URL1", list.get(0).getUrl());
		assertEquals("Wrong Value Returned", 1, list.get(0).getPriority());
		
		assertEquals("Wrong Value Returned", 2, list.get(1).getId());
		assertEquals("Wrong Value Returned", "URL2", list.get(1).getUrl());
		assertEquals("Wrong Value Returned", 2, list.get(1).getPriority());
	}
	
	/**
	 * Test method for {@link db.DatabaseUtil#queryFinalURLList()}. Tests for the retrieval of all record from the final URL table.
	 */
	@Test
	public void testQueryFinalURLList() {
		DatabaseUtil databaseUtil = new DatabaseUtil();
		databaseUtil.insertRecordFinalTable(1, "URL1", 1);
		databaseUtil.insertRecordFinalTable(2, "URL2", 2);
		List<Finalurllist> list = databaseUtil.queryFinalURLList();
		
		assertEquals("Wrong Value Returned", 2, list.size());
		
		assertEquals("Wrong Value Returned", 1, list.get(0).getId());
		assertEquals("Wrong Value Returned", "URL1", list.get(0).getUrl());
		assertEquals("Wrong Value Returned", 1, list.get(0).getPriority());
		
		assertEquals("Wrong Value Returned", 2, list.get(1).getId());
		assertEquals("Wrong Value Returned", "URL2", list.get(1).getUrl());
		assertEquals("Wrong Value Returned", 2, list.get(1).getPriority());
		
	}
	
	/**
	 * Test method for {@link db.DatabaseUtil#deleteAllFromTemporaryTable()}. Tests for the deletion of all records from the temporary URL table.
	 */
	@Test
	public void testDeleteAllFromTemporaryTable() {
		DatabaseUtil databaseUtil = new DatabaseUtil();
		databaseUtil.deleteAllFromTemporaryTable();
		List<Temporaryurllist> emptyList = databaseUtil.queryTemporaryURLList();
		assertEquals("Wrong value returned", 0, emptyList.size());
	}
	
	/**
	 * Test method for {@link db.DatabaseUtil#deleteAllFromFinalTable()}. Tests for the deletion of all records from the final URL table.
	 */
	@Test
	public void testDeleteAllFromFinalTable() {
		DatabaseUtil databaseUtil = new DatabaseUtil();
		databaseUtil.deleteAllFromFinalTable();
		List<Finalurllist> emptyList = databaseUtil.queryFinalURLList();
		assertEquals("Wrong value returned", 0, emptyList.size());
	}
	
}
