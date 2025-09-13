package selenium_mock;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import object_Repository.FacebookLoginPage;

public class FacebookLogin {
	
	WebDriver driver;
	@DataProvider()
	public Object[][] getData() throws IOException{
		FileInputStream fis=new FileInputStream("C:\\Users\\91790\\eclipse-workspace\\A11selenium_mock\\src\\test\\resources\\testdata.properties");
		Properties prop= new Properties();
		prop.load(fis);
		return new Object[][] {
			{prop.getProperty("username1"),prop.getProperty("password1")},
			{prop.getProperty("username2"),prop.getProperty("password2")},
			{prop.getProperty("username3"),prop.getProperty("password3")},
			{prop.getProperty("username4"),prop.getProperty("password4")},
			{prop.getProperty("username5"),prop.getProperty("password5")},
			{prop.getProperty("username6"),prop.getProperty("password6")},
			{prop.getProperty("username7"),prop.getProperty("password7")},
		};
	}	
		@Test(dataProvider ="getData")
		public void loginFacebook(String username, String password) throws IOException, InterruptedException {
			FileInputStream fis2=new FileInputStream("C:\\Users\\91790\\eclipse-workspace\\A11selenium_mock\\src\\test\\resources\\config.properties");
			Properties config=new Properties();
			config.load(fis2);
			String URL= config.getProperty("url");
			String BROWSER = config.getProperty("browser");
			
			if(BROWSER.equals("Chrome")) {
	  driver= new ChromeDriver();
			}else if(BROWSER.equals("Firefox")){
				  driver= new FirefoxDriver();
					}else if(BROWSER.equals("Edge")){
						driver= new EdgeDriver();
						
					}else {
						driver= new ChromeDriver();
					}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get(URL);
			
			FacebookLoginPage flp= new FacebookLoginPage(driver);
			WebElement un=flp.getUn();
			WebElement pwd=flp.getPwd();
			WebElement loginBtn= flp.getLogin();
			un.sendKeys(username);
			pwd.sendKeys(password);
			loginBtn.click();
			
			Thread.sleep(5000);
			driver.quit();
					
	}
	

}
