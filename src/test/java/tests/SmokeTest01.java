package tests;

import org.testng.annotations.Test;

import pages.PageInitializer;

public class SmokeTest01 extends PageInitializer {

	@Test(enabled = false)
	public void verifyHeaderAndFooterSections() throws Exception {

		landingPage().verifyHeaderMenuSection();
		landingPage().verifySearchIconPresent();
		landingPage().verifySignInIconPresent();
		landingPage().verifyBagIconPresent();
//		landingPage().verifyFooter();
	}

	@Test 
	public void verifyMenSubCategoryLinks() {
		landingPage().hoverToMenMenu();
		landingPage().verifySubCategoryForMen();
		
//		List<String> lists = landingPage.getSubCategoryLinks();
	}

	@Test(enabled = false, dependsOnMethods = "verifyHeaderElements")
	public void verifyMenListingPage() {
		landingPage().navigateToMenMenu();
		menCategoryPage().verifySubCategories();
//		List<String> lists = landingPage.getSubCategoryLinks();
	}
}
