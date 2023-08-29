package rough;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;

import page_validation.base_class;
import tech.tablesaw.api.Table;
import tech.tablesaw.io.xlsx.XlsxReadOptions;
import tech.tablesaw.io.xlsx.XlsxReader;

public class roughwork extends base_class{
	
	public static void main (String[] args)  {
		try {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sayan\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
		

}
