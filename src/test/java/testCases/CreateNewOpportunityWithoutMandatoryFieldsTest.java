package testCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.NewOpportunityPage;
import pages.SalesForceHomePage;
import pages.SalesHomePage;

public class CreateNewOpportunityWithoutMandatoryFieldsTest extends BaseClass{

	@BeforeClass(groups = { "Opportunity"})
	public void setSheetName() {

		sheetName="CreateNewOpportunityWithoutMand";
	}

	@Test(dataProvider = "fecthData")
	public  void createNewOpportunityWithoutMandatoryFieldsTest(String message1,String message2,String message3 ) {


		List<String> expectedMessages= new ArrayList<String>();
		expectedMessages.add(message1);
		expectedMessages.add(message2);
		expectedMessages.add(message3);
		
		SalesForceHomePage salesForceHomePage = new SalesForceHomePage(driver);
		salesForceHomePage.toggleButtonClick().viewAllButtonClick().salesButtonClick();
		
		SalesHomePage salesHomePage = new SalesHomePage(driver);
		salesHomePage.opportunityTab().newOpportunityButton();
		
		NewOpportunityPage newOpportunityPage = new NewOpportunityPage(driver);
		newOpportunityPage.selectTodayDate().saveButton();
		
		Assert.assertEquals(newOpportunityPage.mandatoryFieldError(), expectedMessages);
		

	}
}