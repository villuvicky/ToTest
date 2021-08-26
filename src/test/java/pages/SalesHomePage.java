package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import testCases.BaseClass;
import utilities.CommonActions;


public class SalesHomePage extends BaseClass{

	public SalesHomePage(ChromeDriver driver) {

		this.driver=driver;
	}

	public SalesHomePage opportunityTab() {

		WebElement opportunities = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunities);
		return this;
	}


	public NewOpportunityPage newOpportunityButton() {

		WebElement newOpportunities = driver.findElement(By.xpath("//a[@title='New']"));
		newOpportunities.click();
		return new NewOpportunityPage(driver);

	}

	public SalesHomePage searchOpportunity(String opportunityName) throws InterruptedException {

		WebElement searchOppurtunity=driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		searchOppurtunity.sendKeys(opportunityName);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		return this;
	}

	public SalesHomePage opportunityDropDown(String opportunityName) {

		WebElement dropdown= driver.findElement(By.xpath(String.format("//a[@title='%s']//ancestor::tr//td[8]", opportunityName)));

		CommonActions.waitClickMethod(driver, dropdown);

		return this;
	}

	public NewOpportunityPage OpenExistingOpportunity() {

		WebElement editOppurtunity=driver.findElement(By.xpath("//a[@title='Edit']"));
		editOppurtunity.click();

		return new NewOpportunityPage(driver);
	}

	public SalesHomePage deleteOpportunity() {

		WebElement deleteOppurtunity=driver.findElement(By.xpath("//a[@title='Delete']"));
		deleteOppurtunity.click();

		WebElement confirmDelete=driver.findElement(By.xpath("//button[@title='Delete']"));
		confirmDelete.click();
		return this;
	}
	
	public String opportunityCreatedMessage() {

		WebElement messageElement=driver
				.findElement(By.xpath("(//div[@data-aura-class='forceToastMessage']//div)[1]/div"));

		CommonActions.waitVisibleMethod(driver, messageElement);

		return messageElement.getText();
	}

	public String editOpportunityMessage(String opportunityName,String stageType) {

		WebElement actualStage=driver.findElement(By.xpath(String.format("(//a[@title='%s']//ancestor::tr/td[5])[1]/span/span[text()='%s']", opportunityName,stageType)));
		CommonActions.waitVisibleMethod(driver, actualStage);
		return actualStage.getText();
	}


	
	public String deleteOpportunityMessage() {

		WebElement messageElement =driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));

		CommonActions.waitVisibleMethod(driver, messageElement);
		return messageElement.getText();
		
	}
}
