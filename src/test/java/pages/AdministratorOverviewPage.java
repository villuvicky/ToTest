package pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdministratorOverviewPage {

	String logoSRC;

	URL imageURL;

	BufferedImage saveImage;
	
	private ChromeDriver driver;

	public AdministratorOverviewPage(ChromeDriver driver){

		this.driver=driver;
	}
	public AdministratorOverviewPage salesForceArchitect() {

		WebElement salesforceArchitect=driver.findElement(By.xpath("//div[text()='Salesforce Architect']"));
		salesforceArchitect.click();
		return this;
	}

	public AdministratorOverviewPage salesForceArchitectDescription() {

		String text= driver.findElement(By.xpath("(//h2[normalize-space(text()) = 'Salesforce Architect']//parent::div/child::div)[1]")).getText();
		System.out.println(text);
		return this;
	}

	public AdministratorOverviewPage geTtechnicalArchitectLogo() throws IOException {


		WebElement technicalArchitectLogo = driver.findElement(By.xpath("//img[@src='https://developer.salesforce.com/resources2/certification-site/images/architect-pyramid-1.png']"));

		logoSRC = technicalArchitectLogo.getAttribute("src");

		imageURL = new URL(logoSRC);

		saveImage = ImageIO.read(imageURL);

		ImageIO.write(saveImage, "png", new File("./Screenshots/technicalArchitectLogo.png"));

		return this;
	}

	public AdministratorOverviewPage getSolutionArchitectLogo() throws IOException {

		WebElement solutionArchitectLogo =   driver.findElement(By.xpath("//img[@src='https://developer.salesforce.com/resources2/certification-site/images/architect-pyramid-2.png']"));

		logoSRC = solutionArchitectLogo.getAttribute("src");

		imageURL = new URL(logoSRC);

		saveImage = ImageIO.read(imageURL);

		ImageIO.write(saveImage, "png", new File("./Screenshots/solutionArchitectLogo.png"));

		return this;
	}
	
	public AdministratorOverviewPage listOfCertification() {
		
		List<WebElement> certificateElements= driver.findElements(By.xpath("//div[text()='Certification']//ancestor::div[@class='cs-card tile']//div[3]/a"));

		List<String> certificates= new ArrayList<String>();

		for (WebElement webElement : certificateElements) {
			certificates.add(webElement.getText());
		}

		System.out.println(certificates);

		driver.switchTo().window(SalesForceHomePage.homeWindow);
		return this;
	}
}
