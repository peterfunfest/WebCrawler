package db;

import java.util.List;

import model.Finalurllist;
import model.Temporaryurllist;

public class DatabaseTest {

	public static void main(String[] args) {
		DatabaseUtil db = new DatabaseUtil();

		// First Delete all existing records
		System.out.println("Deleting all records from temporary table");
		db.deleteAllFromTemporaryTable();

		System.out.println("Deleting all records from final table");
		db.deleteAllFromFinalTable();

		// Insert some records into the temp table
		db.insertRecordTemporaryTable("Test URL Temp1", 1);
		db.insertRecordTemporaryTable("Test URL Temp2", 2);
		db.insertRecordTemporaryTable("Test URL Temp3", 3);

		// Insert some records into the final table
		db.insertRecordFinalTable("Test URL Final1");
		db.insertRecordFinalTable("Test URL Final2");
		db.insertRecordFinalTable("Test URL Fianl3");

		// Now we read back everything from the final URL table
		System.out.println("Checking SELECT From Final URL Table");

		List<Finalurllist> tempList = db.queryFinalURLList();
		for (Finalurllist furl : tempList) {
			System.out.println("ID: " + furl.getId());
			System.out.println("URL: " + furl.getUrl());
		}
		System.out.println("Size: " + tempList.size());

		// Now we read back everything from the temporary URL Table
		System.out.println("Checking SELECT From Temp URL Table");

		List<Temporaryurllist> tempList2 = db.queryTemporaryURLList();
		for (Temporaryurllist furl : tempList2) {
			System.out.println("ID: " + furl.getId());
			System.out.println("URL: " +  furl.getUrl());
			System.out.println("Priority: " + furl.getPriority());
		}
		System.out.println("Size: " + tempList2.size());

	}

}
