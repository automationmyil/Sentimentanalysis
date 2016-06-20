package sentimentanalyse;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;



public class sa_pajeobject {
	
WebDriver ms;

public sa_pajeobject(WebDriver pa)
{
	this.ms = pa;
}
@FindBy(how = How.XPATH, using ="//*[@name='userId']" ) WebElement user;
@FindBy(how = How.XPATH, using = "//*[@name='password']") WebElement pass;
@FindBy(how = How.XPATH, using = "//*[@type = 'submit']") WebElement submit;
@FindBy(how = How.XPATH, using = "//*[@id='projects']/div[2]/div/div[1]/h4/a") WebElement project;
@FindAll({@FindBy(how = How.XPATH, using = "//*[@id='projects']/div[*]/div/div[1]/h4/a[1]")}) public List<WebElement> projectlist;
@FindAll({@FindBy(how = How.XPATH, using = "//*[@class='aside-inner']/nav/ul/li[*]/a/span")}) public List<WebElement> analysislist;
@FindBy(how = How.XPATH, using = "//*[@class='aside-inner']/nav/ul/li[2]/a/span") WebElement sentiment;
@FindBy(how = How.XPATH, using = "//*[@data-toggle='autorefresh']") WebElement autorefresh;
@FindBy(how = How.XPATH, using = "//*[@class='nav-wrapper']/ul[1]/li[3]/a/span") WebElement Projectdash;
public void sa_test() throws InterruptedException, IOException
{
user.sendKeys("ananth218@123.com");
pass.sendKeys("welcome");
submit.click();
Thread.sleep(3000);;
int proj_total = projectlist.size();
System.out.println("Total projects : " + proj_total);
for(WebElement tes:projectlist)
{
	//String a = tes.getText();
	//System.out.println("Project Name is : " + a);
	tes.click();
	int anal_total = analysislist.size();
	System.out.println("No of Analysis found : " +anal_total);
	sentiment.click();
	Thread.sleep(2000);
	File fs = ((TakesScreenshot)ms).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(fs, new File("c:\\users\\20112\\desktop\\My.jpg"));
	for(int i=0;i<=5;i++)
	{
	try{
		String refresh = autorefresh.getText();
	System.out.println("Auto refresh text : " +refresh);
	}catch (Exception e)
	{
		System.out.println("Error");
	}
	
}
	Projectdash.click();
	Thread.sleep(5000);
}
}
}