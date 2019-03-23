package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LandingPage extends PageInitializer {

	 

	@FindBy(css = ".logo")
	WebElement linkEBLogo;

	@FindBy(xpath = "//div[contains(@class,'styles__CategoryRootItem') and contains(.,'Men')]")
	WebElement menuMen;

	@FindBy(xpath = "//div[contains(@class,'styles__CategoryRootItem') and contains(.,'Women')]")
	WebElement menuWomen;

	@FindBy(xpath = "//div[contains(@class,'styles__CategoryRootItem') and contains(.,'Outerwear')]")
	WebElement menuOuterwear;

	@FindBy(xpath = "//div[contains(@class,'styles__CategoryRootItem') and contains(.,'Gear')]")
	WebElement menuGear;

	@FindBy(xpath = "//div[contains(@class,'styles__CategoryRootItem') and contains(.,'Home')]")
	WebElement menuHome;

	@FindBy(xpath = "//div[contains(@class,'styles__CategoryRootItem') and contains(.,'Guide')]")
	WebElement menuGuideToEB;

	@FindBy(xpath = "//div[contains(@class,'FocusedCategoryDropdown')]")
	WebElement focusedFlyOut;

	@FindBy(css = ".search_title")
	WebElement linkSearchIcon;

	@FindBy(css = ".sign_in")
	WebElement linkSignInIcon;

	@FindBy(css = ".bag")
	WebElement linkBagIcon;

	@FindBy(xpath = "//div[contains(@class,'FocusedCategoryDropdown')]/div/div/div/a")
	List<WebElement> linkProducts;

	public void hoverToMenMenu() {
		mousehover(menuMen);
		explicitWaitVisibilityOfElement(focusedFlyOut, 10);
		Assert.assertEquals(focusedFlyOut.isDisplayed(), true, "Flyout menu not displayed on hovering main Menu");
	}

	public void verifySubCategoryForMen() {
		 
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap = getSubCategoryLinks();
		for (Map.Entry m : hMap.entrySet()) {
			System.out.println(m.getKey() + "--" + m.getValue());
			driver.get(m.getValue().toString());
			checkPageContainsError(m.getKey().toString());
		}
		System.out.println("sss");
	}

	private HashMap<String, String> getSubCategoryLinks() {
		HashMap<String, String> hMap = new HashMap<String, String>();
		int counter = 1;
		for (WebElement elem : linkProducts) {
			hMap.put(counter + "_" + elem.getText(), elem.getAttribute("href"));
			counter++;
		}
		System.out.println(hMap);
		return hMap;
	}

	public void navigateToMenMenu() {
		menuMen.click();
	}

	public void navigateToWomenMenu() {
		menuWomen.click();
	}

	public void navigateToOuterwearMenu() {
		menuOuterwear.click();
	}

	public void navigateToGearMenu() {
		menuGear.click();
	}

	public void navigateToHomeMenu() {
		menuHome.click();
	}

	public void navigateToGuideToEBMenu() {
		menuGuideToEB.click();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void verifyHeaderMenuSection() {
		Assert.assertTrue(linkEBLogo.isDisplayed() && menuMen.isDisplayed() && menuWomen.isDisplayed()
				&& menuOuterwear.isDisplayed() && menuGear.isDisplayed() && menuHome.isDisplayed()
				&& menuGuideToEB.isDisplayed());
	}

	public void verifySearchIconPresent() {
		Assert.assertTrue(linkSearchIcon.isDisplayed());
	}

	public void verifySignInIconPresent() {
		Assert.assertTrue(linkSignInIcon.isDisplayed());
	}

	public void verifyBagIconPresent() {
		Assert.assertTrue(linkBagIcon.isDisplayed());
	}

//	public List<String> getSubCategoryLinks() {
//		List<String> links=null;
//		for (WebElement e : lists) {
////			 System.out.print(driver.get(e.getAttribute("href")));
//		}
//		return null;
//	}
}
