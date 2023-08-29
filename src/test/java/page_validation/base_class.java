package page_validation;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

import io.cucumber.java.Scenario;

public class base_class {
	
	public static WebDriver driver;
	public static String scenario_keyword = "";
	public static Actions actions_obj = null;
	
	public static Scenario scenario;
	
	@BeforeTest
	public void initialize_scenario(Scenario scenario) {
		base_class.scenario = scenario;
	}
	
	public static void step_log(String log_msg) {
		scenario.log(log_msg);
	}
	
	public static void capture_screenshot() {
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "screenshot");
	}

}
