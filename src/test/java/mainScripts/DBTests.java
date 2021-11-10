package mainScripts;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import testMethods.QueriesMethods;

public class DBTests extends QueriesMethods{
	Logger log = Logger.getLogger(QueriesMethods.class);
	@Test
	public void dbTest() throws SQLException {
		List<String> list = retrieveData();
		Assert.assertTrue(list.get(0).contains("Industrial engineering"), "Major for first pupil is not the one expected");
		log.info("Major for 1st pupil has been verified");
	}
	
	@Test
	public void twoTablesAssertion() throws SQLException {
		int expectedLocationNo = retrieveDataFromTwoTables();
		Assert.assertTrue(expectedLocationNo == 67, "Location number is not the one expected");
		log.info("Location number has been verified");
	}
}
