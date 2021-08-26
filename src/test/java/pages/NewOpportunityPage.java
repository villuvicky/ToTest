package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import testCases.BaseClass;


public class NewOpportunityPage extends BaseClass{

	WebElement dates;
	WebElement chooseDate;

	public NewOpportunityPage(ChromeDriver driver) {

		this.driver=driver;
	}

	public NewOpportunityPage opportunityName(String opportunityName) {

		WebElement newOpportunitiesName = driver.findElement(By.xpath("//input[@name='Name']"));
		newOpportunitiesName.sendKeys(opportunityName);
		System.out.println(newOpportunitiesName.getAttribute("value"));
		return this;
	}
	public NewOpportunityPage selectTodayDate() {

		dates = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		dates.click();

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/y");

		chooseDate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		chooseDate.sendKeys(sdf.format(date));

		return this;
	}

	public NewOpportunityPage selectTomorrowDate() {

		dates=driver.findElement(By.xpath("//input[@name='CloseDate']"));
		dates.clear();

		Date date = new Date();
		String dateToStr = DateFormat.getInstance().format(date); 
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/y"); //hh is to print 12 hours format
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);  // number of days to add
		dateToStr = sdf.format(c.getTime());
		
		dates.sendKeys(dateToStr);

		return this;
	}

	public NewOpportunityPage stage(String stageType) {

		WebElement stageDropdown=driver.findElement(By.xpath("//label[text()='Stage']/following::input[1]//parent::div"));
		driver.executeScript("arguments[0].click();", stageDropdown);

		WebElement selectStage = driver.findElement(By.xpath(String.format("(//span[@title='%s'])",stageType)));
		selectStage.click();
		return this;
	}
	
	public NewOpportunityPage deliveryStatus(String deliveryStatus) {
		
		WebElement statusBox=driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[7]//parent::div"));
		driver.executeScript("arguments[0].click();", statusBox);
		
		WebElement deliverStatus=driver.findElement(By.xpath(String.format("(//span[@title='%s'])",deliveryStatus)));
		deliverStatus.click();
		
		return this;
	}

	public NewOpportunityPage description(String descriptionValue ) {
		
		WebElement description=driver.findElement(By.xpath("//label[text()='Description']//parent::lightning-textarea/div/textarea"));
		description.clear();
		description.sendKeys(descriptionValue);
		return this;
	}
	
	public NewOpportunityPage saveButton() {

		WebElement saveChanges = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		saveChanges.click();
		return this;
	}

	public List<String> mandatoryFieldError() {
		
		String opportunityText=driver.findElement(By.xpath("(//input[@name='Name']/following::div)[1]")).getText();
		
		String stageText=driver.findElement(By.xpath("(//label[text()='Stage']/following::div)[6]")).getText();
		
		System.out.println(opportunityText);
		
		System.out.println(stageText);
		
		String warningText=driver.findElement(By.xpath("//h2[@title='We hit a snag.']")).getText();
		
		List<WebElement> allMessagesPath=driver.findElements(By.xpath("//li[@force-recordediterror_recordediterror]/a"));
		
		List<String> actualMessages= new ArrayList<String>();
		
		actualMessages.add(warningText);
		
		for (WebElement MessagePath : allMessagesPath) {
			
			actualMessages.add(MessagePath.getText());
		}

		WebElement cancel=driver.findElement(By.xpath("//button[@name='CancelEdit']"));
		cancel.click();
		
		return actualMessages;
	}
	
}
