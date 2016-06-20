package sentimentanalyse;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class sa_check extends SA{
	
	@Test
	public void sa_run() throws InterruptedException, IOException
	{
		sa_pajeobject sm = PageFactory.initElements(pa, sa_pajeobject.class);
		sm.sa_test();
	}

}
