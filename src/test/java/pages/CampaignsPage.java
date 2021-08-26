package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.CommonActions;

public class CampaignsPage{

	private ChromeDriver driver;
	public CampaignsPage(ChromeDriver driver) {

		this.driver=driver;
	}

	public NewContactPage newContact() {

		WebElement newContact=driver.findElement(By.xpath("//a[@title='New Contact']"));
		newContact.click();
		return new NewContactPage(driver);
	}

	public CampaignsPage campaignMembers() {

		CommonActions.actionsMethod(driver, driver.findElement(By.xpath("//span[@title='Campaign Members']")));
		return this;
	}

	public CampaignsPage addContactForCampaignOption() {
		WebElement addContact=driver.findElement(By.xpath("//span[@title='Campaign Members']//following::div[text()='Add Contacts'][1]"));
		driver.executeScript("arguments[0].click();", addContact);
		return this;
	}

	public CampaignsPage addContactForCampaign(String fullName) throws InterruptedException {

		WebElement searchContact=driver.findElement(By.xpath("//input[@title='Search Contacts']"));
		searchContact.sendKeys(fullName);
		CommonActions.act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		WebElement add=driver.findElement(By.xpath(String.format("//tr[1]//th//span//a[@title='%s']//preceding::td[1]/span/span/label[@class='slds-checkbox']",fullName)));
		driver.executeScript("arguments[0].click();", add);

		WebElement nextButton= driver.findElement(By.xpath("//span[text()='Next']"));
		nextButton.click();

		WebElement status= driver.findElement(By.xpath("//span[text()='Member Status']//following::a[text()='Sent']"));
		CommonActions.waitVisibleMethod(driver, status);

		WebElement submit= driver.findElement(By.xpath("//span[text()='Submit']"));
		submit.click();
		return this;
	}

	public boolean isAddedContactPresent(String fullName) {
		
		WebElement viewAllContacts= driver.findElement(By.xpath("(//div[@class='runtime_sales_campaignMemberRelatedList']//div//a//span[@class='view-all-label'])[1]"));
		CommonActions.waitClickMethod(driver, viewAllContacts);
		
		int size= driver.findElements(By.xpath(String.format("//a[@title='%s']//following::tr[1]/td[8]/span[1]",fullName))).size();

		if (size>=1) {
			return true;
		}
		else
			return false;
	}
}


