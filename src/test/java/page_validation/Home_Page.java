package page_validation;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page extends base_class{
	
	@FindBy(xpath = "//button[text()='✕']")
	private List<WebElement> close_login_popup;
	
	@FindBy(xpath = "//input[@name='q' or @title = 'Search for products, brands and more' or @title = 'Search for products, Brands and More']")
	private WebElement product_search_box;
	
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean close_login_popup() throws Throwable{
		boolean res = false;
		try {
			if(close_login_popup.size() > 0) {
				close_login_popup.get(0).click();
			}
			res = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean search_products()throws Throwable{
		boolean res = false;
		try {
			product_search_box.sendKeys(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	
	
	
	

}
