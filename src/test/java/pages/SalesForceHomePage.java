package pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import testCases.BaseClass;
import utilities.CommonActions;


public class SalesForceHomePage{

	public static String homeWindow;
	private ChromeDriver driver;
	
	public SalesForceHomePage(ChromeDriver driver) {

		this.driver=driver;
	}

	public SalesForceHomePage toggleButtonClick() {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement toggle = driver
				.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle_container')]"));
		toggle.click();

		return this;

	}

	public SalesForceHomePage viewAllButtonClick() {

		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		viewAll.click();

		return this;
	}

	public SalesHomePage salesButtonClick() {

		WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
		sales.click();
		return new SalesHomePage(driver);

	}
	
	public SalesHomePage compaignButtonClick() {

		WebElement campaigns = driver.findElement(By.xpath("//p[text()='Campaigns']"));
		driver.executeScript("arguments[0].click();", campaigns);
		return new SalesHomePage(driver);

	}
	
	public ServiceTerritoryHomePage serviceTerritoriesButtonClick() throws InterruptedException {

		WebElement serviceTerritories = driver.findElement(By.xpath("//a[@data-label='Service Territories']"));
		driver.executeScript("arguments[0].click();", serviceTerritories);
		Thread.sleep(2000);
		return new ServiceTerritoryHomePage(driver);

	}

	public MobileAppsPage mobilePublisher() {

		WebElement mobilePublisher=driver.findElement(By.
				xpath("//span[text()='Mobile Publisher']//ancestor::div[@class='tileHelp']//div[@class='tileNavButton']/button"
						)); 
		driver.executeScript("arguments[0].click();", mobilePublisher);

		homeWindow=driver.getWindowHandle();

		Set<String> allWIndows=driver.getWindowHandles();

		for (String string : allWIndows) {

			driver.switchTo().window(string);	
		}
		return new MobileAppsPage(driver);
	}
	
	public AppManagerPage clickCommunity() {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement communityLink= driver.findElement(By.xpath("//span[text()='Most Recently Used']//following::a[text()='Community']"));
		CommonActions.waitClickMethod(driver, communityLink);
		return new AppManagerPage(driver);
	}
}
