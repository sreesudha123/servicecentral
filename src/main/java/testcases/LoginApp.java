package testcases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Configurations.Services;

public class LoginApp extends Services  {
		 	LoginApp() throws IOException {
				super();
				
			}
		   @Test(priority=1)
			public void userLogin() throws IOException, InterruptedException, SQLException{
				login();
				String compare=getTextp(getProperty("SagarText"));
				System.out.println(compare);
				Assert.assertEquals(compare, "Sagarsoft");
				String userattribute=getAttributeValue(getProperty("submit"),"class");
				System.out.println(userattribute);
				TextElementLocaters(getProperty("username"),"send","SIL-0418");
				TextElementLocaters(getProperty("password"),"send","sreedevi@123");
				TextElementLocaters(getProperty("submit"),"click","");
				TextElementLocaters(getProperty("Timesheet"),"click","");
				Thread.sleep(3000);	
				wd.switchTo().frame(0);
				TextElementLocaters(getProperty("Dashboard"),"click","");
				DashBoard(getProperty("date"));
				addButton(2);
				
		   }
		   
		   /*@Test(priority=2)	
			public void LeaveApplication{
			   
				
				
			}
			*/
			
				
				
				
		
				
				
				
				
				
				
			
			}
			
	

