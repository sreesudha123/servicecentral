package Configurations;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

import db.EmpBean;
import db.SqlConnector;

public class Util extends Config{
	
	SqlConnector sq=new SqlConnector();
	ArrayList<EmpBean> dataget = new ArrayList<EmpBean>();


	

	/*public Util() throws IOException {
		super();
		
	}*/
		
	public void TextElementLocaters(String element,String action, String data) throws InterruptedException{
				
		String[] str=element.split("##");
		if(str[0].equals("id")){
			if(action.equals("click")){
				Thread.sleep(2000);
				wd.findElement(By.id(str[1])).click();
			}
			else if(action.equals("send")){
				wd.findElement(By.id(str[1])).sendKeys(data);
			}
			
		}
		if(str[0].equals("name")){
			if(action.equals("click")){
				wd.findElement(By.name(str[1])).click();
			}
			else if(action.equals("send")){
				wd.findElement(By.name(str[1])).sendKeys(data);
			}
			
		}
		if(str[0].equals("xpath")){
			if(action.equals("click")){
				wd.findElement(By.xpath(str[1])).click();
			}
			else if(action.equals("send")){
				wd.findElement(By.xpath(str[1])).sendKeys(data);
			}
			
		}
		
		if(str[0].equals("cssSelector")){
			if(action.equals("click")){
				wd.findElement(By.cssSelector(str[1])).click();
			}
			else if(action.equals("send")){
				wd.findElement(By.cssSelector(str[1])).sendKeys(data);
			}
			
		}
		
		if(str[0].equals("linkText")){
			if(action.equals("click")){
				wd.findElement(By.linkText(str[1])).click();
			}
			else if(action.equals("send")){
				wd.findElement(By.linkText(str[1])).sendKeys(data);
			}
			
		}
		
		
	}
	
	public boolean checkElement(String element,String action ){
		String str[]=element.split("##");
		boolean check=false;
		if(str[0].equals("id")){
			
			if(action.equals("isDisplayed")){
				 check=wd.findElement(By.id(str[1])).isDisplayed();
				
			}
			else if(action.equals("isSelected")){
				check=wd.findElement(By.id(str[1])).isSelected();
			}
			else if(action.equals("isEnabled")){
				check=wd.findElement(By.id(str[1])).isEnabled();
			}
			
		}
		if(str[0].equals("name")){
			if(action.equals("isDisplayed")){
				 check=wd.findElement(By.name(str[1])).isDisplayed();
				
			}
			else if(action.equals("isSelected")){
				check=wd.findElement(By.name(str[1])).isSelected();
			}
			else if(action.equals("isEnabled")){
				check=wd.findElement(By.name(str[1])).isEnabled();
			}
			
		}
		if(str[0].equals("xpath")){
			if(action.equals("isDisplayed")){
				 check=wd.findElement(By.xpath(str[1])).isDisplayed();
				
			}
			else if(action.equals("isSelected")){
				check=wd.findElement(By.xpath(str[1])).isSelected();
			}
			else if(action.equals("isEnabled")){
				check=wd.findElement(By.xpath(str[1])).isEnabled();
			}
			
		}
		
		if(str[0].equals("cssSelector")){
			if(action.equals("isDisplayed")){
				 check=wd.findElement(By.cssSelector(str[1])).isDisplayed();
				
			}
			else if(action.equals("isSelected")){
				check=wd.findElement(By.cssSelector(str[1])).isSelected();
			}
			else if(action.equals("isEnabled")){
				check=wd.findElement(By.cssSelector(str[1])).isEnabled();
			}
			
		}
		
		return check;
		
	}
	public String getAttributeValue(String element, String attributeName){
		String str[]=element.split("##");
		
		String getAttributeValue=null;
		if(str[0].equals("id")){
			getAttributeValue=wd.findElement(By.id(str[1])).getAttribute(attributeName);
		}
		
		else if(str[0].equals("name")){
			getAttributeValue=wd.findElement(By.name(str[1])).getAttribute(attributeName);
		}
		else if(str[0].equals("xpath")){
			getAttributeValue=wd.findElement(By.xpath(str[1])).getAttribute(attributeName);
		}
		else if(str[0].equals("cssSelector")){
			getAttributeValue=wd.findElement(By.cssSelector(str[1])).getAttribute(attributeName);
		}
		else if(str[0].equals("linkText")){
			getAttributeValue=wd.findElement(By.linkText(str[1])).getAttribute(attributeName);
		}
		else if(str[0].equals("partialLinkText")){
			getAttributeValue=wd.findElement(By.partialLinkText(str[1])).getAttribute(attributeName);
		}
		return getAttributeValue;
		
	}
	
	public String getTextp(String element){
		String str[]=element.split("##");
		String getText=null;
		
		if(str[0].equals("id")){
			getText=wd.findElement(By.id(str[1])).getText();
		}
		
		else if(str[0].equals("name")){
			getText=wd.findElement(By.name(str[1])).getText();
		}
		else if(str[0].equals("xpath")){
			getText=wd.findElement(By.xpath(str[1])).getText();
		}
		else if(str[0].equals("cssSelector")){
			getText=wd.findElement(By.cssSelector(str[1])).getText();
		}
		else if(str[0].equals("linkText")){
			getText=wd.findElement(By.linkText(str[1])).getText();
		}
		else if(str[0].equals("partialLinkText")){
			getText=wd.findElement(By.partialLinkText(str[1])).getText();
		}
		//System.out.println(getText);
		return getText;
		
	}
	public void dropDownList(String element, String tagName,String action, String data,int j){
	
		
		String str[]=element.split("##");
		Select sel=null;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EXIT_LOOP:
		if(tagName.equals("select")){
			
			if(str[0].equals("id")){
				sel = new Select(wd.findElement(By.id(str[1]+j)));
				
			}
				else if(str[0].equals("name")){
					sel = new Select(wd.findElement(By.name(str[1]+j)));
			}
				else if(str[0].equals("xpath")){
					sel = new Select(wd.findElement(By.xpath(str[1]+j)));
			}
				else if(str[0].equals("cssSelector")){
					sel = new Select(wd.findElement(By.cssSelector(str[1]+j)));
			}
			//List<WebElement> ls = sel.getOptions();
			switch (action) {
            case "VisibleText":
             	sel.selectByVisibleText(data);
                break;
            case "Value":
            	sel.selectByValue(data);
                break;
            case "Index":
            	sel.selectByIndex(Integer.valueOf(data));
                break;
            }
		}
		else {
			System.out.println("entered in else");
			EXIT_LOOP1:
			if(str[0].equals("id")){
				List<WebElement> ls = wd.findElements(By.id(str[1]));
				for(int i=0; i<ls.size(); i++){
					if(ls.get(i).getText().equals(data)){
						ls.get(i).click();
					  	break EXIT_LOOP1;
					}
				}
			}
			else if(str[0].equals("name")){
				List<WebElement> ls = wd.findElements(By.name(str[1]));
				for(int i=0; i<ls.size(); i++){
					if(ls.get(i).getText().equals(data)){
						ls.get(i).click();
					  	break EXIT_LOOP1;
					}
				}
			}
			else if(str[0].equals("xpath")){
				System.out.println("in xpath");
				List<WebElement> ls = wd.findElements(By.xpath(str[1]));
				System.out.println(ls.size());
				for(int i=0; i<ls.size(); i++){
					System.out.println(ls.get(i).getText());
					if(ls.get(i).getText().equals(data)){
						System.out.println("matching record found");
						ls.get(i).click();
						break EXIT_LOOP1;
					}
				}
			
			}
			else if(str[0].equals("cssSelector")){
				System.out.println("in cssSelector");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<WebElement> ls = wd.findElements(By.cssSelector(str[1]));
				System.out.println(ls.size());
				for(int i=0; i<ls.size(); i++){
					System.out.println(ls.get(i).getText());
					if(ls.get(i).getText().equals(data)){
						ls.get(i).click();
					  	break EXIT_LOOP1;
					}
				}
			
			}
		
		
		}
		
		
	}
	// to click the dashboard dates
	public void DashBoard(String date){
		int count=wd.findElements(By.cssSelector(".month_view_box>tbody>tr>td")).size();
		//System.out.println(count);
		DLoop:
		for(int i=2; i<=6; i++){
			for(int j=1; j<=7; j++){
				String txt=wd.findElement(By.cssSelector(".month_view_box>tbody>tr:nth-child("+i+")>td:nth-child("+j+")>table>tbody>tr:nth-child(1)>td:nth-child(1)")).getText();
				//System.out.println(txt);
				if(txt.equals(date)){
					Actions action= new Actions(wd);
					action.contextClick(wd.findElement(By.cssSelector(".month_view_box>tbody>tr:nth-child("+i+")>td:nth-child("+j+")>table>tbody>tr:nth-child(1)>td:nth-child(1)"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
					break DLoop;
				}
				
			}
		
		}
	}
	
	
	
	
	
		
		
	
	public void movet(String ele,String ac,String da,int d){
		Actions act=new Actions(wd);
		String[] str1=ele.split("##");
		if(str1[0].equals("id")){
			if(ac.equals("click")){
				act.moveToElement(wd.findElement(By.id(str1[1]+d))).click().build().perform();
			}
			else if(ac.equals("send")){
				act.moveToElement(wd.findElement(By.id(str1[1]+d))).click().sendKeys(da).build().perform();
			}
			
		}
		if(str1[0].equals("name")){
			if(ac.equals("click")){
				wd.findElement(By.name(str1[1])).click();
			}
			else if(ac.equals("send")){
				wd.findElement(By.name(str1[1])).sendKeys(da);
			}
			
		}
		if(str1[0].equals("xpath")){
			if(ac.equals("click")){
				wd.findElement(By.xpath(str1[1])).click();
			}
			else if(ac.equals("send")){
				wd.findElement(By.xpath(str1[1])).sendKeys(da);
			}
			
		}
		
		if(str1[0].equals("cssSelector")){
			if(ac.equals("click")){
				wd.findElement(By.cssSelector(str1[1])).click();
			}
			else if(ac.equals("send")){
				wd.findElement(By.cssSelector(str1[1])).sendKeys(da);
			}
			
		}
		
		if(str1[0].equals("linkText")){
			if(ac.equals("click")){
				wd.findElement(By.linkText(str1[1])).click();
			}
			else if(ac.equals("send")){
				wd.findElement(By.linkText(str1[1])).sendKeys(da);
			}
			
		}
		
		
		
		
		
	}
	@AfterClass
	public void tearDown(){
		wd.close();
	}
	

}