package senti_global_filters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class data_provi {

	String FL = "C:\\Users\\20112\\Desktop\\Usernames.xlsx";
@DataProvider(name="Login_credentials")
public ListIterator<Object> login_data() throws IOException
{
	FileInputStream file = new FileInputStream(FL);
	XSSFWorkbook w = new XSSFWorkbook(file);
	XSSFSheet sh = w.getSheetAt(0);
	int ro = sh.getLastRowNum();
	List<Object> ls = new ArrayList<Object>();
	
	for(int i =1;i<=ro;i++)
	{
		Object[] v = new Object[2];
		for(int j=0;j<=1;j++)
		{
		
		v[j] = sh.getRow(i).getCell(j).getStringCellValue();
		
		}
		ls.add(v);
		}
	System.out.println(ls.size());
	return ls.listIterator();
	
	
	}
	
}

