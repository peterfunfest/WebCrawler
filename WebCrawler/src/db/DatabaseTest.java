package db;

import java.util.List;

import model.Finalurllist;
import model.Temporaryurllist;

public class DatabaseTest {

	public static void main(String[] args) {
		DatabaseUtil db = DatabaseUtil.getInstance();

		// First Delete all existing records
		System.out.println("Deleting all records from temporary table");
		db.deleteAllFromTemporaryTable();

		System.out.println("Deleting all records from final table");
		db.deleteAllFromFinalTable();

		// Insert some records into the temp table
		db.insertRecordTemporaryTable(1,"Test URL Temp1", 1);
		db.insertRecordTemporaryTable(2,"Test URL Temp2", 2);
		db.insertRecordTemporaryTable(3,"Test URL Temp3", 3);

		// Insert some records into the final table
		db.insertRecordFinalTable(1,"Test URL Final1",1);
		db.insertRecordFinalTable(2,"Test URL Final2",2);
		db.insertRecordFinalTable(3,"Test URL Fianl3",3);

		// Now we read back everything from the final URL table
		System.out.println("Checking SELECT From Final URL Table");

		List<Finalurllist> tempList = db.queryFinalURLList();
		for (Finalurllist furl : tempList) {
			System.out.println("ID: " + furl.getId());
			System.out.println("URL: " + furl.getUrl());
			System.out.println("Priority: " + furl.getPriority());
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
