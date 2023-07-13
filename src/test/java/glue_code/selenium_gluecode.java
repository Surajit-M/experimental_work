package glue_code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import page_validation.base_class;

public class selenium_gluecode extends base_class{
	
	@Given("User is preparing to test {string}")
	public void user_is_preparing_to_test(String test_keyword) throws Throwable {
		scenario_keyword = test_keyword;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		System.out.println("driver opened");
		Thread.sleep(5000);
	}

	@When("User closes the login popup")
	public void test_step_one() {
		driver.findElement(By.xpath("//button[text()='✕']")).click();
	}

	@Then("test step_two")
	public void test_step_two() {
		System.out.println("step 2");
	}

}
