package testMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.testng.Assert;

import dbconection.Connection;

public class QueriesMethods extends Connection{
	public List<String> retrieveData() throws SQLException {
		List<String> data = new LinkedList<>();
		String pupilDetails = "";
		  ResultSet res = dbConecction("select");
		  while(res.next()) {
			  String name = res.getString("name");
			  String lastName = res.getString("lastname");
			  String major = res.getString("major");
			  
			  pupilDetails = "Pupil name is: "+ name+" "+lastName+ " and its corresponding major is: "+major;
			  data.add(pupilDetails);
			  
			  System.out.println("Pupil name is: "+ name+" "+lastName+ " and its corresponding major is: "+major);
		  }
		  return data;
	}
	
	public int retrieveDataFromTwoTables() throws SQLException {
		ResultSet res = dbConecction("selectFrom2Tables");
		int locationNumber = 0;
		while(res.next()) {
			locationNumber = res.getInt("locationNumber");
		}
		return locationNumber;
	}
}
