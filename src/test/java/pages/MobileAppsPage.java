package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MobileAppsPage{
	
	private ChromeDriver driver;

	public MobileAppsPage(ChromeDriver driver){

		this.driver=driver;
	}


	public MobileAppsPage resources() {

		WebElement resources=driver.findElement(By.xpath("//span[text()='Resources']"));
		resources.click();
		return this;

		
	}
	
	public AdministratorOverviewPage salesForceCertification() {
		
		WebElement salesForceCertification=driver.findElement(By.xpath("//span[text()='Salesforce Certification ']"));
		driver.executeScript("arguments[0].click();", salesForceCertification);

		Set<String> windows2=driver.getWindowHandles();

		List<String> currentWindows=new ArrayList<String>(windows2);

		driver.switchTo().window(currentWindows.get(2));
		
		return new AdministratorOverviewPage(driver);
	}
}

