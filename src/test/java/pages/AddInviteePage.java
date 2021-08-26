package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.CommonActions;

public class AddInviteePage {

	private ChromeDriver driver;

	public AddInviteePage(ChromeDriver driver) {
		this.driver= driver;
	}
	
	public AddInviteePage searchInvitee(String name){

		driver.switchTo().frame("searchFrame");

		WebElement enterName=driver.findElement(By.xpath("//label[text()='Search']//following::input[@id='lksrch']"));
		enterName.sendKeys(name);

		CommonActions.enterButton(driver);

		driver.switchTo().defaultContent();
		return this;
	}
	
	public AddInviteePage addInvitee(){

		driver.switchTo().frame("resultsFrame");

		WebElement contact=driver.findElement(By.xpath("//tr[@class='dataRow even first' or @class='dataRow even last first']/th/a")); 
		contact.click();
		return this;
	}
	
	
}
