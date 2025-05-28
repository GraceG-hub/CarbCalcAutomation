package carb.calc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CalcPage {
	
	WebDriver driver;
	
	public CalcPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='panel2']")
	WebElement calcForm;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement pageHeader;
	
	@FindBy(css="div[id='breadcrumbs']")
	WebElement breadcrumbs;
	
	@FindBy(css="input[value='Clear']")
	WebElement clear;
	
	@FindBy(id="cage")
	WebElement age;
	
	@FindBy(xpath="//label[@for='csex2']/span")
	WebElement genderF;
	
	@FindBy(id="cheightmeter")
	WebElement heightInCm;
	
	@FindBy(id="ckg")
	WebElement weightInKg;
	
	@FindBy(id="cactivity")
	WebElement staticDropdown;
	
	@FindBy(xpath="//input[@value='Calculate']")
	WebElement calculate;
	
	@FindBy(linkText="US Units")
	WebElement usUnits;
	
	@FindBy(id="cheightfeet")
	WebElement heightInFt;
	
	@FindBy(id="cheightinch")
	WebElement heightInInch;
	
	@FindBy(id="cpound")
	WebElement weightInPound;
	
	@FindBy(partialLinkText="Settings")
	WebElement settings;
	
	@FindBy(css="label[for='cformula1'] span")
	WebElement formula1;
	
	@FindBy(css="label[for='cformula2'] span")
	WebElement formula2; 
	
	@FindBy(css="div[id='content'] h2")
	WebElement resultHeader;
	
	@FindBy(className="cinfoT")
	WebElement resultInfoTable;
	
	
	public void goToWebpage() {
		driver.get("https://www.calculator.net/carbohydrate-calculator.html");
	}
	
	public boolean verifyCalcForm() {
		return calcForm.isDisplayed();
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public String getBreadcrumbs() {
		return breadcrumbs.getText();
	}
	
	public void clearFields() {
		clear.click();
	}
	
	public void calculateWithMetricUnits(String ageVal, String height, String weight) {
		age.sendKeys(ageVal);
		genderF.click();
		heightInCm.sendKeys(height);
		weightInKg.sendKeys(weight);
	}
	
	public void calculateWithUsUnits(String ageVal, String heightFt, String heightIn, String weight) {
		usUnits.click();
		age.clear();
		age.sendKeys(ageVal);
		heightInFt.clear();
		heightInFt.sendKeys(heightFt);
		heightInInch.clear();
		heightInInch.sendKeys(heightIn);
		weightInPound.clear();
		weightInPound.sendKeys(weight);
	}
	
	public void selectActivity(String dropdownVal) {
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByContainsVisibleText(dropdownVal);
	}
	
	public void setFormula1() {
		settings.click();
		formula1.click();
	}
	
	public void setFormula2() {
		settings.click();
		formula2.click();
	}
	
	public void calculate() {
		calculate.click();
	}
	
	public String getResultHeader() {
		return resultHeader.getText();
	}
	
	public boolean verifyResultInfoTable() {
		return resultInfoTable.isDisplayed();
	}
	

}
