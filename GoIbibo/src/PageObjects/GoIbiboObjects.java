package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Library.ApplicationCommonFunction;
import Library.BaseClass;

public class GoIbiboObjects extends ApplicationCommonFunction {//multilevel 

	static WebDriver driver = getDriver();

	public GoIbiboObjects(WebDriver driver) {
		super(driver);
	}


	public static By hotelsOption = By.xpath("//a[text()='Hotels']");
	public static By indiaRadioButton = By.xpath("//h4[text()='India']//preceding-sibling::input");
	public static By whereTextBox = By
			.xpath("//span[text()='Where']//following-sibling::div//input[contains(@id,'downshift')]");
	public static By checkInCalendarOption = By.xpath("//div[@data-testid='openCheckinCalendar']//h4");
	public static By searchIconWhere = By.xpath("//span[text()='Where']//following-sibling::div//*[name()='svg']");
	
	public static By dateValue(String MonthValue,int choiceDay,int choiceMonth,int choiceYear) {
		return By.xpath("//span[text()='"+MonthValue+"']//ancestor::div//li[@class='date_is_selectable_true']/span[@data-testid='date_"+choiceDay+"_"+choiceMonth+"_"+choiceYear+"']");
	}
	
	
	public static By nightsText = By.xpath("//div[contains(text(),'Nights')]");
	public static By guestAndRoomBox = By.xpath("//input[contains(@class,'CitySearchInput')]");

	public static By guestsAndRooms(String choice) { //we can select any choices instead of creating duplicate
		return By.xpath("//span[text()='" + choice + "']//following-sibling::div//span[text()='+']");
	}

	public static By childDropDown = By.xpath("//ul[contains(@class,'ChildDropdownWrap')]");

	public static By childDropDownOption(int choice) {
		return By.xpath("(//span[contains(text(),'Age')])[" + choice
				+ "]//ancestor::span[contains(text(),'Child')]//following-sibling::div//span//*[name()='svg']");
	}

	public static By childDropDownAgeOption(int choice) {
		return By.xpath("//ul[contains(@class,'ChildDropdownWrap')]//li[text()='" + choice + "']");
	}

	public static By doneButton = By.xpath("//button[text()='Done']");
	public static By searchHotelsButton = By.xpath("//button[@data-testid='searchHotelBtn']");
	public static By sectionPage = By.xpath("//section[contains(@class,'RightSection')]");
}
