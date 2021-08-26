package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.NewServiceTerritoryPage;
import pages.SalesForceHomePage;
import pages.ServiceTerritoryHomePage;

public class CreateserviceTerritoriesTest extends BaseClass{
	
	private SalesForceHomePage salesForceHomePage;
	private ServiceTerritoryHomePage serviceTerritoryHomePage;
	private NewServiceTerritoryPage newServiceTerritoryPage;

	@BeforeClass
	public void setSheetName() {

		sheetName="CreateserviceTerritories";
	}

	@Test(dataProvider = "fecthData")
	public void createserviceTerritoriesTest(String newTerritoryName,String city,String address, String country, String postalCode, String expectedMessage) throws InterruptedException {
		
		salesForceHomePage= new SalesForceHomePage(driver);
		salesForceHomePage.toggleButtonClick().viewAllButtonClick().serviceTerritoriesButtonClick();
		
		serviceTerritoryHomePage= new ServiceTerritoryHomePage(driver);
		serviceTerritoryHomePage.newTerritoryOption();
		
		newServiceTerritoryPage= new NewServiceTerritoryPage(driver);
		newServiceTerritoryPage.enterTerritoryName(newTerritoryName).enterOperatingHours().activeField().
		enterCityName(city).enterAddress(address).enterCountry(country).enterPostal(postalCode).saveTerritory();
		
		Assert.assertEquals(serviceTerritoryHomePage.newTerritoryCreatedMessage(), expectedMessage);
	}
}