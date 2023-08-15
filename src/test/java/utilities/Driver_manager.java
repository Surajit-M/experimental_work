package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import page_validation.base_class;

public class Driver_manager extends base_class{
	
	public static WebDriver create_driver(String browser_name) {
		System.out.println("Inside create_driver --->");
		try {
			if(browser_name.equalsIgnoreCase("chrome")) {
				ChromeOptions chrome_options = new ChromeOptions();
				chrome_options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
				driver = new ChromeDriver(chrome_options);
				driver.manage().window().maximize();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("create_driver completed --->");
		return driver;
	}

}
