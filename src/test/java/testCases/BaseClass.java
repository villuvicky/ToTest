package testCases;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.UserMenuPage;
import utilities.ReadExcel;

public class BaseClass {

	public ChromeDriver driver;
	public String sheetName;
	public Properties prop;
	public FileInputStream fis;

	@DataProvider(name = "fecthData")
	public String[][] getData() throws IOException {

		ReadExcel data = new ReadExcel();
		return data.excelData(sheetName);
	}


	public Properties initProp() {

		try {
			fis = new FileInputStream("./src/test/resources/configFiles/config.properties");
			prop = new Properties();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;
	}

	@BeforeMethod(alwaysRun = true)
	public void openBrowserAndLogin() throws InterruptedException {	

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get(initProp().getProperty("url"));

		LoginPage lp =new LoginPage(driver);
		lp.enterUserName(initProp().getProperty("admin")).enterPassword(initProp().getProperty("password")).clickLogin();

		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		By lightningElement= By.xpath("//a[@class='switch-to-lightning']");
		
		List<WebElement> elements=driver.findElements(lightningElement);

		if(elements.size()>=1) {

			elements.get(0).click();
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		

		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		By lightningElement= By.xpath("//a[@class='switch-to-lightning']");

		if(driver.findElements(lightningElement).size()>=1) {

			driver.findElement(lightningElement).click();
		}
		
		  UserMenuPage userMenuPage = new UserMenuPage(driver); 
		  userMenuPage.clickUserMenu().logOut(); 
		  driver.quit();
		 

	}

}
