package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class CampaignsHomePage {
	
	private ChromeDriver driver;
	public CampaignsHomePage(ChromeDriver driver) {

		this.driver=driver;
	}

	public CampaignsHomePage searchCampaign(String CampaignName) throws InterruptedException {

		WebElement searchcampain = driver.findElement(By.xpath("//input[@name='Campaign-search-input']"));
		searchcampain.sendKeys(CampaignName);
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		return this;			
	}

	public CampaignsPage openCampaign(String CampaignName) throws InterruptedException {
		
		List<WebElement> campaignRow=driver.findElements(By.xpath(String.format("//tr//a[@title='%s']",CampaignName)));
		campaignRow.get(0).click();;
		return new CampaignsPage(driver);			
	} 
	
}
