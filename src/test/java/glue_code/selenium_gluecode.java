package glue_code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import page_validation.Home_Page;
import page_validation.base_class;
import utilities.Driver_manager;


public class selenium_gluecode extends base_class{
	
	@Before
	public void before_method(Scenario scenario)throws Throwable{
		initialize_scenario(scenario);
	}
	
	Home_Page home_page = null;
	
	@Given("User is preparing to test {string}")
	public void user_is_preparing_to_test(String test_keyword) throws Throwable {
		 
		scenario_keyword = test_keyword;
		driver = Driver_manager.create_driver("chrome");
		home_page = new Home_Page(driver);
		driver.get("https://www.flipkart.com/");
		step_log("Driver opened!");
		capture_screenshot();
		Assert.assertTrue(true);
	}

	@When("User closes the login popup")
	public void test_step_one() throws Throwable {
		Assert.assertTrue(home_page.close_login_popup());
	}

	@Then("test step_two")
	public void test_step_two() {
		System.out.println("step 2");
	}

}
