package senti_global_filters;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class pageobject {

	WebDriver sm;
	public pageobject(WebDriver m)
	{
		this.sm = m;
		System.out.println("Test");
	}
	@FindBy(how = How.XPATH, using ="//*[@name='userId']") WebElement usern;
	@FindBy(how = How.XPATH, using = "//*[@name='password']") WebElement passw;
	@FindBy(how = How.XPATH, using = "//*[@type = 'submit']") WebElement submit;
	@FindBy(how = How.XPATH, using = "//*[@id='projects']/div[2]/div/div[1]/h4/a") WebElement project;
	@FindAll({@FindBy(how = How.XPATH, using = "//*[@id='projects']/div[*]/div/div[1]/h4/a[1]")}) public List<WebElement> projectlist;
	@FindAll({@FindBy(how = How.XPATH, using = "//*[@class='aside-inner']/nav/ul/li[*]/a/span")}) public List<WebElement> analysislist;
	@FindBy(how = How.XPATH, using = "//*[@class='aside-inner']/nav/ul/li[2]/a/span") WebElement sentiment;
	@FindBy(how = How.XPATH, using = "//*[@data-toggle='autorefresh']") WebElement autorefresh;
	@FindBy(how = How.XPATH, using = "//*[@class='nav-wrapper']/ul[1]/li[3]/a/span") WebElement Projectdash;
	@FindBy(how = How.XPATH, using = "//*[@data-target ='#gfilters']") WebElement filter;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/header/nav/div[2]/ul[1]/li[3]/a/span") WebElement Projects;
	@FindBy(how = How.XPATH, using = "//*[@id='gfilters']/div/div/div[3]/button[1]") WebElement filterclose;
	@FindBy(how = How.XPATH, using = "//*[@class='content']/span") WebElement Brandusername;
	@FindBy(how = How.XPATH, using = "//*[@data-key='source_group']") WebElement Sourcegroup;
	@FindAll({@FindBy(how = How.XPATH, using = "//*[@id='gfilters-source_group']/div[2]/div[1]/div")}) public List<WebElement> sourcelist;
	@FindBy(how = How.XPATH, using = "//input[@class = 'toggle_val']") WebElement sourcecheckbox;
	@FindBy(how = How.XPATH, using = "//*[@data-key='location']") WebElement filterlocation;
	@FindAll({@FindBy(how = How.XPATH, using = "//*[@id='gfilters-location']/div[2]/div[1]/div")}) public List<WebElement> locationlist; 
	@FindBy(how = How.XPATH, using ="//*[@value='volume']") WebElement volumechart;
	@FindBy(how = How.XPATH, using ="/html/body/div[1]/section/div/div[3]/div/div/div[1]/div[3]/label[1]/span") WebElement rollingchart;
	@FindBy(how = How.XPATH, using ="//div[@class='chart row']/svg/g/circle") WebElement CDDchart;
	
	public void senti_execution(String username,String password) throws InterruptedException
	{
		usern.sendKeys(username);
		passw.sendKeys(password);
		submit.click();
		Thread.sleep(3000);
		System.out.println("Total no of projects available : "+projectlist.size());
		for(int i=2;i<=projectlist.size();i++) {
			sm.findElement(By.xpath("//*[@id='projects']/div["+i+"]/div/div[1]/h4/a[1]")).click();
			try{
			//pm.click();
			Thread.sleep(3000);
			//System.out.println(filter);
			autorefresh.click();
			Thread.sleep(3000);
			filter.click();
			String brandtext = Brandusername.getText();
			System.out.println("Text in Branduser :" + brandtext);
			if(brandtext.equalsIgnoreCase("No Brand username filters available"))
			{
				System.out.println("No Brand user name found");
			}
			Thread.sleep(3000);
			Sourcegroup.click();
			Thread.sleep(3000);
			System.out.println("No of Sources found :" +sourcelist.size());
			sourcecheckbox.click();
			filterlocation.click();
			Thread.sleep(3000);
			int loclist = locationlist.size();
			System.out.println("Total locations : " +loclist);
			filterclose.click();
			Thread.sleep(3000);
			boolean status = rollingchart.isSelected();//getAttribute("checked");
			System.out.println("Status: " +status);
			if (status) {
				System.out.println("Rolling chart is selected");
				volumechart.click();
			} else {
				System.out.println("Volume Chart is Selected");
				rollingchart.click();
			}
			Thread.sleep(2000);
			WebElement cdchart = CDDchart;
			Actions a = new Actions(sm);
			a.click(cdchart).build().perform();
//			System.out.println("CDD Chart is available : " +ch);
			Projects.click();
			Thread.sleep(3000);
			
			
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		}
		
	}
}
