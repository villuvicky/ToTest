package testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import pages.AdministratorOverviewPage;
import pages.MobileAppsPage;
import pages.SalesForceHomePage;


public class ArchitectCertificationsTest extends BaseClass{

	@Test
	public void acrchitectCertifications() throws IOException {

		SalesForceHomePage salesForceHomePage = new SalesForceHomePage(driver);
		salesForceHomePage.mobilePublisher();
		
		MobileAppsPage mobileAppsPage = new MobileAppsPage(driver);
		mobileAppsPage.resources().salesForceCertification();
		
		AdministratorOverviewPage administratorOverviewPage=new AdministratorOverviewPage(driver);
		administratorOverviewPage.salesForceArchitect().
		salesForceArchitectDescription().getSolutionArchitectLogo().
		geTtechnicalArchitectLogo().listOfCertification();
	}
}