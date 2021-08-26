package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CampaignsHomePage;
import pages.CampaignsPage;
import pages.NewContactPage;
import pages.SalesForceHomePage;

public class CreateContactForCampaignTest extends BaseClass{
	
	private SalesForceHomePage salesForceHomePage;
	private CampaignsHomePage campaignsHomePage;
	private CampaignsPage campaignsPage;
	private NewContactPage newContactPage;
	
	@BeforeClass
	public void setSheetName() {
		
		sheetName="CreateContactForCampaign";
	}

	@Test(dataProvider = "fecthData")
	public void createContactForCampaignTest(String campaign,String salutationValue, String contactFirstName, String contactLastName,String fullName) throws InterruptedException {

		salesForceHomePage = new SalesForceHomePage(driver);
		salesForceHomePage.toggleButtonClick().viewAllButtonClick().compaignButtonClick();
		
		campaignsHomePage= new CampaignsHomePage(driver);
		campaignsHomePage.searchCampaign(campaign).openCampaign(campaign);
		
		campaignsPage = new CampaignsPage(driver);
		campaignsPage.newContact();
		
		newContactPage = new NewContactPage(driver);
		newContactPage.salutation(salutationValue).firstName(contactFirstName).lastName(contactLastName).saveNewContact();
		
		campaignsPage.campaignMembers().addContactForCampaignOption().addContactForCampaign(fullName);
		Assert.assertTrue(campaignsPage.isAddedContactPresent(fullName));
	}
}