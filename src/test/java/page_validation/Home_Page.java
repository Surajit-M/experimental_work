package page_validation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page extends base_class{
	
	@FindBy(xpath = "//button[text()='✕']")
	private WebElement close_login_popup;
	
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean close_login_popup() throws Throwable{
		boolean res = false;
		try {
			close_login_popup.click();
			res = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	
	
	
	

}
