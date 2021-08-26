package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AppManagerPage {

	private ChromeDriver driver;

	public AppManagerPage(ChromeDriver driver){

		this.driver=driver;
	}
	
	public AppManagerPage loadElementsNew() {
		
		List<WebElement> currentList=driver.findElements(By.xpath("//tr/td[5]"));
		
		for (int i=0;i<currentList.size(); i++) {
			
			currentList.get(currentList.size()-1).click();
			
			currentList=driver.findElements(By.xpath("//tr/td[5]"));
		}
		return this;
		
	}
	
	
	public AppManagerPage getApplicationNames() {

		List<String> appNames= new ArrayList<String>();
		List<WebElement> appNamesElement=driver.findElements(By.xpath("//div[text()='Lightning']//ancestor::tr/th"));

		for (WebElement webElement : appNamesElement) {
			appNames.add(webElement.getText());
		}
		System.out.println(appNames);

		return this;
	}

	public AppManagerPage getDeveloperNames() {

		List<String> Names= new ArrayList<String>();

		List<WebElement> developerNamesElement=driver.findElements(By.xpath("//div[text()='Lightning']//ancestor::tr/td[2]"));

		for (WebElement webElement : developerNamesElement) {
			Names.add(webElement.getText());
		}

		System.out.println(Names);
		return this;
	}
}
