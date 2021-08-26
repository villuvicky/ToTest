package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.CommonActions;

public class CreateEventPage {
	
	private ChromeDriver driver;
	private String parentWindow;


	public CreateEventPage(ChromeDriver driver) {
		this.driver= driver;
	}

	public CreateEventPage enterSubject(String subject){

		WebElement subjectBox=driver.findElement(By.xpath("//label[text()='Subject']/ancestor::tr/td[@class='dataCol col02']//input"));
		
		//label[text()='Subject']/parent::td/parent::tr/td[@class='dataCol col02']//input
		subjectBox.sendKeys(subject);
		return this;
	}

	public CreateEventPage enterStartDate(){

		WebElement startDate=driver.findElement(By.xpath("//input[@name='StartDateTime']"));
		startDate.clear();

		startDate.sendKeys(CommonActions.selectDate(1));

		return this;
	}

	public CreateEventPage enterEndDate(){

		WebElement endDate=driver.findElement(By.xpath("//input[@name='EndDateTime']"));
		endDate.clear();

		endDate.sendKeys(CommonActions.selectDate(2));

		return this;
	}

	public AddInviteePage clickAddToInvitees() {

		WebElement addToInvitees=driver.findElement(By.xpath("//a[@title='Name Lookup (New Window)']"));
		addToInvitees.click();

		parentWindow= driver.getWindowHandle();
		CommonActions.getwindow(driver, 1);

		return new AddInviteePage(driver);
	}

	public AttachFilePage clickAttachFile(){

		driver.switchTo().window(parentWindow);

		WebElement attachFileOption=driver.findElement(By.xpath("//input[@name='attachFile']"));
		attachFileOption.click();

		CommonActions.getwindow(driver, 1);
		return new AttachFilePage(driver);
	}
	
	public boolean isFileUploaded(String fileName){

		driver.switchTo().window(parentWindow);

		WebElement uploadedFileName= driver.findElement(By.xpath("//tr//th[text()='File Name']//following::tr/td[2]/span"));

		if(uploadedFileName.getText().equals(fileName)) {
			
			return true;
		}

		return false;
	}

	public CreateEventPage clickSaveButton() {
		
		WebElement saveEventButon=driver.findElement(By.xpath("//td[@id='bottomButtonRow']/input[@name='save']"));
		saveEventButon.click();
		return this;
	}
	
}
