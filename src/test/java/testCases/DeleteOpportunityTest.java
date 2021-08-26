package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SalesForceHomePage;
import pages.SalesHomePage;

public class DeleteOpportunityTest extends BaseClass{

	@BeforeClass(groups = { "Opportunity"})
	public void setSheetName() {

		sheetName="DeleteOpportunity";
	}

	@Test(dataProvider = "fecthData")
	public void deleteOpportunityTest(String opportunityName,String deleteMessage ) throws InterruptedException {
		SalesForceHomePage salesForceHomePage = new SalesForceHomePage(driver);
		salesForceHomePage.toggleButtonClick().
		viewAllButtonClick().
		salesButtonClick();
		
		SalesHomePage salesHomePage = new SalesHomePage(driver);
		salesHomePage.opportunityTab().searchOpportunity(opportunityName).opportunityDropDown(opportunityName).deleteOpportunity();
		
		Assert.assertEquals(salesHomePage.deleteOpportunityMessage(), deleteMessage);
	}
}