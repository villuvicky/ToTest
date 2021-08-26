package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AttachFilePage {
	private ChromeDriver driver;


	public AttachFilePage(ChromeDriver driver) {
		this.driver= driver;
	}
	
	public AttachFilePage chooseFile(String location){

		WebElement chooseFile= driver.findElement(By.xpath("//input[@id='file']"));
		chooseFile.sendKeys(location);
		return this;
	}
	
	public AttachFilePage attachFile(){

		WebElement attachFile=driver.findElement(By.xpath("//input[@id='Attach']"));
		driver.executeScript("arguments[0].click();", attachFile);
		return this;
	}
	

	public AttachFilePage uploadFileDone(){

		WebElement doneButton= driver.findElement(By.xpath("//input[@name='cancel']"));
		driver.executeScript("arguments[0].click();", doneButton);
		return this;
	}
}
