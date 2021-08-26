package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.CommonActions;

public class UserMenuPage{
	private ChromeDriver driver;


	public UserMenuPage(ChromeDriver driver) {
		this.driver= driver;
	}

	public UserMenuPage clickUserMenu() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement userMenuIcon=driver.findElement(By.xpath(
				"(//img[@title='User']//parent::span[@class='uiImage'])[1]"));
		CommonActions.waitClickMethod(driver, userMenuIcon);
		return this;
	}

	public ClassicPage clickClassicView() {

		WebElement classicView= driver.findElement(By.xpath("//a[text()='Switch to Salesforce Classic']"));
		CommonActions.waitClickMethod(driver, classicView);
		return new ClassicPage(driver);
	}

	public UserMenuPage logOut() {

		WebElement logOut=driver.findElement(By.xpath("//a[text()='Log Out']"));
		CommonActions.waitClickMethod(driver, logOut);
		return this;
	}

}
