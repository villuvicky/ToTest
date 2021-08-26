package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import testCases.BaseClass;

public class NewServiceTerritoryPage extends BaseClass{

	public NewServiceTerritoryPage(ChromeDriver driver) {

		this.driver=driver;
	}
	
	public NewServiceTerritoryPage enterTerritoryName(String newTerritoryName) {

		WebElement newTerritoryNameBox= driver.findElement(By.xpath("//span[text()='Name']//parent::label//following::input[1]"));
		newTerritoryNameBox.sendKeys(newTerritoryName);
		return this;
	} 
	
	public NewServiceTerritoryPage enterOperatingHours() {

		WebElement operatingHours= driver.findElement(By.xpath("(//span[text()='Operating Hours']//following::input[1])[2]"));
		operatingHours.click();
		return this;
	} 
	
	public NewServiceTerritoryPage activeField() {

		WebElement checkBox=driver.findElement(By.xpath("(//span[text()='Active'])[2]//following::input[@type='checkbox']"));
		checkBox.click();
		WebElement firstOperatingHour= driver.findElement(By.xpath("//span[text()='Operating Hours']//following::ul[@class='lookup__list  visible']/li[1]"));
		firstOperatingHour.click();
		return this;
	} 
	
	public NewServiceTerritoryPage enterCityName(String city) {

		WebElement cityBox= driver.findElement(By.xpath("//span[text()='City']//following::input[@placeholder='City']"));
		cityBox.sendKeys(city);
		return this;
	} 
	
	public NewServiceTerritoryPage enterAddress(String address) {

		WebElement addressBox= driver.findElement(By.xpath("//span[text()='Address']//following::textarea[1]"));
		addressBox.sendKeys(address);
		return this;
	} 
	
	public NewServiceTerritoryPage enterCountry(String country) {

		WebElement countryBox=driver.findElement(By.xpath("//span[text()='Country']//following::input[@placeholder='Country']"));
		countryBox.sendKeys(country);
		return this;
	}
	
	public NewServiceTerritoryPage enterPostal(String postalCode) {

		WebElement postalCodeBox= driver.findElement(By.xpath("//span[text()='Zip/Postal Code']//following::input[@placeholder='Zip/Postal Code']"));
		postalCodeBox.sendKeys(postalCode);
		return this;
	} 
	
	public NewServiceTerritoryPage saveTerritory() {
		WebElement saveButton= driver.findElement(By.xpath("//button[@title='Save']"));
		saveButton.click();
		return this;
	} 
}
