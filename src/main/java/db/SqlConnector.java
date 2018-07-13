package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class SqlConnector {
	Connection conn = null;
	   
	   
	public ArrayList<EmpBean> retData() throws SQLException{
		ArrayList<EmpBean> al=new ArrayList<EmpBean>();
		String url = "jdbc:sqlite:C:/Users/Sreedevi.Ajjuguttu/Desktop/sree.sqlite";
	       
	     conn = DriverManager.getConnection(url);
	     Statement stmt=conn.createStatement();
	     ResultSet rs=stmt.executeQuery("select * from timesheet");
	     while(rs.next()){
	    	EmpBean eb = new EmpBean();
	    	eb.setProject(rs.getString("project"));
	    	eb.setCategory(rs.getString("category"));
	    	eb.setTask(rs.getString("task"));
	    	eb.setFromTime(rs.getString("Fromtime"));
	    	eb.setToTime(rs.getString("ToTime"));
    
	    	al.add(eb);
	    	
	     }
		return al;
		
	}


}