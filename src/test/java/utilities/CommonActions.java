package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions{

	static WebDriverWait wait;
	public static Actions act;

	public static void waitClickMethod(ChromeDriver driver, WebElement locator) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public static void waitVisibleMethod(ChromeDriver driver, WebElement locator) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(locator));
	}


	public static void actionsMethod(ChromeDriver driver, WebElement element) {

		act= new Actions(driver);
		act.moveToElement(element).perform();
	}

	public static void enterButton(ChromeDriver driver) {

		act= new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	public static void getwindow(ChromeDriver driver, int index) {

		List<String> windows=new ArrayList<String>(driver.getWindowHandles()); 
		driver.switchTo().window(windows.get(index));
		driver.manage().window().maximize();
	}

	public static void uploadFileRobot(String fileLocation) throws AWTException, InterruptedException {

		Robot rb = new Robot();

		// copying File path to Clipboard
		StringSelection str = new StringSelection(fileLocation);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		// press Contol+V for pasting
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		// release Contol+V for pasting
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		// for pressing and releasing Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
	}

	public static String selectDate(int count) {

		Date date = new Date();
		String dateToStr = DateFormat.getInstance().format(date); 
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/y"); //hh is to print 12 hours format
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, count);  // number of days to add
		dateToStr = sdf.format(c.getTime());
		return dateToStr;
	}
}
