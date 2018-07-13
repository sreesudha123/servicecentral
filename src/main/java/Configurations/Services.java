package Configurations;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;


public class Services extends Util {
	public Services() throws IOException {
		super();
		
	}
    @BeforeClass
	public void login() throws IOException {
		getBrowserDetails(getProperty("browser"));
		wd.get(getProperty("url"));
		wd.manage().window().maximize();
		waitCommand();

	}
	public void addButton(int noOfRecords) throws IOException, SQLException, InterruptedException{
		dataget = sq.retData();

	for(int m=0; m<noOfRecords; m++){
		dropDownList(getProperty("projectdrp"),"select", "VisibleText",dataget.get(m).getProject(),m);
		dropDownList(getProperty("Categorydrp"),"select","VisibleText",dataget.get(m).getCategory(),m);
		dropDownList(getProperty("Taskdrp"),"select","VisibleText",dataget.get(m).getTask(),m);
		movet(getProperty("SubTask"),"send","Java with selenium",m);
		/*FromHours(m);
		ToHours(m);	*/	
		dataget = sq.retData();
		String s=dataget.get(m).getFromTime();
		TextElementLocaters(getProperty("FromTime")+m,"click","");
		 String[] s1=s.split(":");
		int Fromhours=wd.findElements(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[1]/td")).size();
		OUTER_LOOP:
		if(s1[0].equals("Am")){
			for(int a=1; a<=2; a++){
				for(int b=1; b<=Fromhours;b++){
					String val = wd.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+a+"]/td["+b+"]/a")).getText();
					if(val.equals(s1[1])){
						wd.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+a+"]/td["+b+"]/a")).click();
						  break OUTER_LOOP;
						
					} 
						
					}
					
				}
			}else if (s1[0].equals("Pm")){
		    	 for(int c=3; c<=4; c++){
			  		   for(int d=1; d<=Fromhours; d++ ){
			  			   String value = wd.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+c+"]/td["+d+"]/a")).getText();
			  			   if (value.equals(s1[1])){
			  				   wd.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+c+"]/td["+d+"]/a")).click();
			  				   break  OUTER_LOOP;
			  			   }
			  		   }
			 		 }
			     }
		

		System.out.println("entering");
      int Fromminutes = wd.findElements(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr")).size();
		OUTER_LOOP2:
			for (int e = 1; e <= 4; e++) {
			     for (int f = 1; f <= 3; f++) {
				 String minValue = wd.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr["
										+ e + "]/td[" + f + "]")).getText();
				 System.out.println(minValue);
				     if (minValue.equals(s1[2])) {
					    wd.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr["+ e + "]/td[" + f + "]/a")).click();
					    break OUTER_LOOP2;
				     }
			     }
		     }
      dataget = sq.retData();
		String s2=dataget.get(m).getToTime();
		System.out.println(s2);
		String s3[]=s2.split(":");
      TextElementLocaters(getProperty("ToTime")+m,"click","");
      int hours=wd.findElements(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[1]/td")).size();
		OUTER_LOOP:
		if(s3[0].equals("Am")){
			System.out.println("entered");
			for(int t=1; t<=2; t++){
				for(int k=1; k<=hours;k++){
					String val = wd.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+t+"]/td["+k+"]/a")).getText();
						if(val.equals(s3[1])){
						wd.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+t+"]/td["+k+"]/a")).click();
						System.out.println("clicked");
						break OUTER_LOOP;
						
					} 
						
					}
					
				}
			}else if (s3[0].equals("Pm")){
		    	 for(int k=3; k<=4; k++){
			  		   for(int i=1; i<=hours; i++ ){
			  			   String value = wd.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+i+"]/a")).getText();
			  			   if (value.equals(s3[1])){
			  				   wd.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+i+"]/a")).click();
			  				   break  OUTER_LOOP;
			  			   }
			  		   }
			 		 }
			     }
		
				
				
	
    int minutes = wd.findElements(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr")).size();
		OUTER_LOOP2:
			for (int m1 = 1; m1 <= 4; m1++) {
			     for (int n = 1; n <= 3; n++) {
				 String minValue = wd.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr["+m1+"]/td["+n+"]")).getText();
				     if (minValue.equals(s3[2])) {
					    wd.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr["+m1+"]/td["+n+"]/a")).click();
					    break OUTER_LOOP2;
				     }
			     }
		     }
    if( m != (noOfRecords-1)){
		Thread.sleep(2000);
		TextElementLocaters(getProperty("addButton"),"click","");
		
		
	}
      
	 }
	}


	

	public void waitCommand(){
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	

}
