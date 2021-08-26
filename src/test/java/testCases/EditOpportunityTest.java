package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.NewOpportunityPage;
import pages.SalesForceHomePage;
import pages.SalesHomePage;

public class EditOpportunityTest extends BaseClass{

	@BeforeClass(alwaysRun = true)
	public void setSheetName() {

		sheetName="EditOpportunity";
	}

	@Test(dataProvider = "fecthData")
	public  void editOpportunityTest(String opportunityName,String stageType, String deliveryStatus, String descriptionValue) throws InterruptedException  {
		
		
		SalesForceHomePage salesForceHomePage = new SalesForceHomePage(driver);
		salesForceHomePage.toggleButtonClick().
		viewAllButtonClick().
		salesButtonClick();
		
		SalesHomePage salesHomePage = new SalesHomePage(driver);
		salesHomePage.opportunityTab().searchOpportunity(opportunityName).opportunityDropDown(opportunityName).OpenExistingOpportunity();
	
		NewOpportunityPage newOpportunityPage = new NewOpportunityPage(driver);
		newOpportunityPage.selectTomorrowDate().stage(stageType).deliveryStatus(deliveryStatus).description(descriptionValue).saveButton();
		
		Assert.assertEquals(salesHomePage.editOpportunityMessage(opportunityName, stageType), stageType);
		
		
	}
}