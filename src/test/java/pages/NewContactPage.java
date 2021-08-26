package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import testCases.BaseClass;

public class NewContactPage extends BaseClass{


	public NewContactPage(ChromeDriver driver) {

		this.driver=driver;
	}

	public NewContactPage salutation(String salutationValue) {

		WebElement salutationDropdown=driver.findElement(By.xpath("//span[text()='Salutation']//following::a[@class='select']"));
		salutationDropdown.click();

		WebElement salutation=driver.findElement(By.xpath(String.format("//span[text()='Salutation']//following::a[@title='%s']",salutationValue)));
		salutation.click();
		return this;
	}
	
	public NewContactPage firstName(String contactFirstName) {

		WebElement firstName=driver.findElement(By.xpath("//span[text()='First Name']//following::input[@placeholder='First Name']"));
		firstName.sendKeys(contactFirstName);
		return this;
	}
	
	public NewContactPage lastName(String contactLastName) {

		WebElement lastName=driver.findElement(By.xpath("//span[text()='First Name']//following::input[@placeholder='Last Name']"));
		lastName.sendKeys(contactLastName);
		return this;
	}
	
	public NewContactPage saveNewContact() {

		WebElement saveButon= driver.findElement(By.xpath("//h2[text()='New Contact']//following::span[text()='Save'][2]"));
		saveButon.click();
		return this;
	}
	
	
}
