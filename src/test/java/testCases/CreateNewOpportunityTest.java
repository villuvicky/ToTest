package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.NewOpportunityPage;
import pages.SalesForceHomePage;
import pages.SalesHomePage;


public class CreateNewOpportunityTest extends BaseClass{
	
	@BeforeClass(groups = { "Opportunity"})
	public void setSheetName() {
		
		sheetName="CreateNewOpportunity";
	}
	
	@Test(dataProvider = "fecthData",groups = { "Opportunity"})
	public void createNewOpportunityTest(String opportunityName, String stageType, String successMessage) {
		
		SalesForceHomePage salesForceHomePage = new SalesForceHomePage(driver);
		salesForceHomePage.toggleButtonClick().viewAllButtonClick().salesButtonClick();
		
		SalesHomePage salesHomePage = new SalesHomePage(driver);
		salesHomePage.opportunityTab().newOpportunityButton();
		
		NewOpportunityPage newOpportunityPage = new NewOpportunityPage(driver);
		newOpportunityPage.opportunityName(opportunityName).selectTodayDate().stage(stageType).saveButton();
		
		Assert.assertEquals(salesHomePage.opportunityCreatedMessage(), successMessage);
		
	}

}
