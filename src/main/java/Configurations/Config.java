package Configurations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;




public class Config {
	public WebDriver wd = null;
	//Properties p = new Properties();
	public String getProperty(String data) throws IOException{
		Properties p = new Properties();
		InputStream ios = new FileInputStream("E:\\SeleniumFresh\\serviceCentral\\src\\main\\java\\propertyFiles\\Login.properties");
		p.load(ios);
		return (p.getProperty(data));
		
		
	}	
	public void getBrowserDetails(String Browser){
		switch(Browser){
		case "firefox":
			wd = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver","E:\\jars\\chromedriver.exe");
			wd=new ChromeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "E:\\jars\\IEDriverServer.exe");
			wd=new InternetExplorerDriver();
			break;
			
		
	}
		
		
		
		
	}

}
