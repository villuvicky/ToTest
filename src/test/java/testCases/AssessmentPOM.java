package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddInviteePage;
import pages.AppManagerPage;
import pages.AttachFilePage;
import pages.ClassicPage;
import pages.CreateEventPage;
import pages.SalesForceHomePage;
import pages.UserMenuPage;


public class AssessmentPOM extends BaseClass{

	private SalesForceHomePage salesForceHomePage;
	private AppManagerPage appManagerPage;
	private UserMenuPage userMenuPage;
	private ClassicPage classicPage;
	private CreateEventPage createEventPage;
	private AddInviteePage addInviteePage;
	private AttachFilePage attachFilePage;

	@BeforeClass(groups = { "Opportunity"})
	public void setSheetName() {

		sheetName="AssessmentPOM";
	}


	@Test(dataProvider = "fecthData")
	public void test(String subject, String name) throws InterruptedException{

		salesForceHomePage = new SalesForceHomePage(driver);
		salesForceHomePage.clickCommunity();

		appManagerPage = new AppManagerPage(driver);
		appManagerPage.loadElementsNew().getApplicationNames().getDeveloperNames();

		userMenuPage= new UserMenuPage(driver);
		userMenuPage.clickUserMenu().clickClassicView();

		classicPage = new ClassicPage(driver);
		classicPage.clickCreateNew().clickCreateNewEvent();

		createEventPage = new CreateEventPage(driver);
		createEventPage.enterSubject(subject).enterStartDate().enterEndDate().
		clickAddToInvitees();

		addInviteePage= new AddInviteePage(driver);
		addInviteePage.searchInvitee(name).addInvitee();

		createEventPage.clickAttachFile();

		attachFilePage= new AttachFilePage(driver); 
		attachFilePage.chooseFile("C:\\Users\\villu\\TestLeaf\\PageObjectTestNg\\src\\test\\resources\\testData\\Sample.pdf").attachFile().uploadFileDone();

		Assert.assertTrue(createEventPage.isFileUploaded("Sample.pdf"));

		createEventPage.clickSaveButton();

	}
}
