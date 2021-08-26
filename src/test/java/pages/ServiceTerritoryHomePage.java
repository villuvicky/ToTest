package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import testCases.BaseClass;
import utilities.CommonActions;

public class ServiceTerritoryHomePage extends BaseClass{

	public ServiceTerritoryHomePage(ChromeDriver driver) {
		
		this.driver=driver;
	}
	
	public NewServiceTerritoryPage newTerritoryOption() {
		
		WebElement newTerritory = driver.findElement(By.xpath("//a[@title='New']"));
		newTerritory.click();
		return new NewServiceTerritoryPage(driver);
	}
	
	public String newTerritoryCreatedMessage() {
		
		WebElement messageElement= driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		
		CommonActions.waitVisibleMethod(driver, messageElement);
		return messageElement.getText();
	}
}
