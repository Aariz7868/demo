package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {
	public FacebookLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id="email")
	private WebElement un;
	@FindBy(id="pass")
	private WebElement pwd;
	
	@FindBy(name="login")
	private WebElement login;

	public WebElement getUn() {
		return un;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLogin() {
		return login;
	}
	public void loginToFacebook(String username, String password) {
		un.sendKeys(username);
		pwd.sendKeys(username);
		login.click();
	}
}
	
