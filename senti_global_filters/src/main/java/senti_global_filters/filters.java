package senti_global_filters;
import sentimentanalyse.*;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class filters extends data_provi {
	//WebDriver m;
	
	@Test(priority = 1, dataProvider = "Login_credentials")
	public void senti(String username, String password) throws InterruptedException, IOException
	{
	SA s = new SA();
	WebDriver pa = s.launch();
		pageobject p = PageFactory.initElements(pa,pageobject.class);
		p.senti_execution(username, password);
		s.close();
	}

}
