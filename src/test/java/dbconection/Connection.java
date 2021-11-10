package dbconection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection extends Queries{
	public static ResultSet dbConecction(String consulta) {
		ResultSet res = null;
		try {
			//Step 1. Load sql driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			//Step 2: Make connection to DB
			  String connectionUrl = "jdbc:sqlserver://localhost:1433;database=NagarroTesting;integratedSecurity=true;";
			  java.sql.Connection con = DriverManager.getConnection(connectionUrl, "", "");
			  System.out.println("Conectado.");
			  Statement queryCon = con.createStatement();
			  String query = returnQuery(consulta);
			  res = queryCon.executeQuery(query);
			}
			catch (SQLException ex) 
			{
				ex.printStackTrace();
			  System.out.println("Error.");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return res;
	}
	
	/*public static void main (String[] args) {
		try {
			//Step 1. Load sql driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			//Step 2: Make connection to DB
			  String connectionUrl = "jdbc:sqlserver://localhost:1433;database=NagarroTesting;integratedSecurity=true;";
			  java.sql.Connection con = DriverManager.getConnection(connectionUrl, "", "");
			  System.out.println("Conectado.");
			  
			//Execute queries to retrieve data
			  Statement queryCon = con.createStatement();
			  String query = returnQuery("select");
			  ResultSet res = queryCon.executeQuery(query);
			  
			  while(res.next()) {
				  String name = res.getString("name");
				  String lastName = res.getString("lastname");
				  String major = res.getString("major");
				  
				  System.out.println("Pupil name is: "+ name+" "+lastName+ " and its corresponding major is: "+major);
			  }
			}
			catch (SQLException ex) 
			{
				ex.printStackTrace();
			  System.out.println("Error.");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}*/
}
