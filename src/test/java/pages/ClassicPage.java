package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.CommonActions;

public class ClassicPage {
	
	private ChromeDriver driver;


	public ClassicPage(ChromeDriver driver) {
		this.driver= driver;
	}
	
	public ClassicPage clickCreateNew(){

		WebElement createNew=driver.findElement(By.xpath("//div[@id='createNewButton']"));
		CommonActions.waitClickMethod(driver, createNew);
		return this;
	}
	
	public CreateEventPage clickCreateNewEvent(){

		WebElement event=driver.findElement(By.xpath("//a[text()='Event']"));
		CommonActions.waitClickMethod(driver, event);
		return new CreateEventPage(driver);
	}
	
}
