package TestScripts;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonData.CommonConstants;
import Library.ApplicationCommonFunction;
import Library.BaseClass;
import PageObjects.GoIbiboObjects;

public class MyScript {

	WebDriver driver;

	@BeforeTest
	public void executeBeforeTest() throws Exception {
		driver = BaseClass.getDriver(); //base driver property to local driver
		GoIbiboObjects goIbiboObjects = new GoIbiboObjects(driver);
		goIbiboObjects.setupMethod();
		goIbiboObjects.navigateToTheURL(CommonConstants.URLValue);
	}

	@Test(priority = 1)  // (priority=-1),
	public void executeTest() throws Exception {
		driver = BaseClass.getDriver();
		GoIbiboObjects goIbiboObjects = new GoIbiboObjects(driver);
		goIbiboObjects.clickElement(GoIbiboObjects.hotelsOption);
		goIbiboObjects.clickElement(GoIbiboObjects.indiaRadioButton);
		goIbiboObjects.enterData(GoIbiboObjects.whereTextBox, CommonConstants.puneDistrictIndiaData);
		goIbiboObjects.enterKeysOption();
		goIbiboObjects.clickElement(GoIbiboObjects.checkInCalendarOption);
		
		goIbiboObjects.clickElement(GoIbiboObjects.dateValue("November 2021", ApplicationCommonFunction.selectDateDay(), ApplicationCommonFunction.selectDateMonth(), ApplicationCommonFunction.selectDateYear()));
		goIbiboObjects.clickElement(GoIbiboObjects.dateValue("November 2021", ApplicationCommonFunction.selectDateDay()+4, ApplicationCommonFunction.selectDateMonth(), ApplicationCommonFunction.selectDateYear()));

		
		goIbiboObjects.compareTextValue(GoIbiboObjects.nightsText, CommonConstants.valueFour,
				CommonConstants.valueFour);
		goIbiboObjects.clickElement(GoIbiboObjects.guestAndRoomBox);
		// select 2 rooms - by default 1 is there hence need to click one additional
		// time
		goIbiboObjects.clickElement(GoIbiboObjects.guestsAndRooms(CommonConstants.rooms));
		// select 3 adults - by default 2 is there hence need to click one additional
		// time
		goIbiboObjects.clickElement(GoIbiboObjects.guestsAndRooms(CommonConstants.adults));
		// select 2 childs - by default 0 is there hence need to click two additional
		// time
		goIbiboObjects.clickElement(GoIbiboObjects.guestsAndRooms(CommonConstants.children));
		goIbiboObjects.clickElement(GoIbiboObjects.guestsAndRooms(CommonConstants.children));
		goIbiboObjects.clickElement(GoIbiboObjects.childDropDownOption(1));
		goIbiboObjects.checkIfEnabled(GoIbiboObjects.childDropDown);
		goIbiboObjects.clickElement(GoIbiboObjects.childDropDownAgeOption(6));
		goIbiboObjects.clickElement(GoIbiboObjects.childDropDownOption(2));
		goIbiboObjects.checkIfEnabled(GoIbiboObjects.childDropDown);
		goIbiboObjects.clickElement(GoIbiboObjects.childDropDownAgeOption(2));
		goIbiboObjects.clickElement(GoIbiboObjects.doneButton);
		goIbiboObjects.clickElement(GoIbiboObjects.searchHotelsButton);
		goIbiboObjects.checkIfDisplayed(GoIbiboObjects.sectionPage);

	}

	@AfterTest
	public void executeAfterTest() {
		driver = BaseClass.getDriver();
		GoIbiboObjects goIbiboObjects = new GoIbiboObjects(driver);
		goIbiboObjects.quitBrowser();
	}
}
