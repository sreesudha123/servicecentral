package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnector {
	public static void  main(String[] args) throws ClassNotFoundException, SQLException {													
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
        String dbUrl = "jdbc:sqlserver://192.168.100.14:1434;" + "databaseName=TrainingDB;user=sa;passWord=Sql2012";
        System.out.println("Test");
        //String dburl = "jdbc:sqlserver://.\\SQLEXPRESS;TrainingDB=Northwind; Integrated Security = SSPI ";
     //System.out.println(dburl);
		//Database Username		
		//String username = "sa";	
        
		//Database Password		
		//String password = "Sql2012";				

		//Query to Execute		
		String query = "select * from Timesheet;";	
        
 	    //Load mysql jdbc driver		
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   
   		//Create Connection to DB		
    	Connection con = DriverManager.getConnection(dbUrl);
    	System.out.println("Test");
  		//Create Statement Object		
	   Statement stmt = con.createStatement();					

			// Execute the SQL Query. Store results in ResultSet		
 		ResultSet rs= stmt.executeQuery(query);							
 
 		
		while (rs.next()){
	        		String myName = rs.getString(1);								        
                    String myAge = rs.getString(2);					                               
                    System. out.println(myName+"  "+myAge);		
            }		
			 
}
}


