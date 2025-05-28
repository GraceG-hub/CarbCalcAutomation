package carb.calc.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import carb.calc.testcomponents.BaseTest;

public class CarbCalcTest extends BaseTest{
	
	@Test(groups= {"Smoke"})
	public void carbCalcDisplay_TC_CC_001() {
		Assert.assertTrue(calcPage.verifyCalcForm());
		Assert.assertEquals(calcPage.getPageHeader(), "Carbohydrate Calculator");
		Assert.assertEquals(calcPage.getBreadcrumbs(), "home / fitness & health / carbohydrate calculator");
	}
	
	@Test(groups= {"Smoke"})
	public void carbCalcWithMetrics_TC_CC_002() {
		calcPage.clearFields();
		calcPage.calculateWithMetricUnits("18", "155", "55");
		calcPage.selectActivity("Moderate: exercise 4-5 times/week");
		calcPage.setFormula1();
		calcPage.calculate();
		Assert.assertEquals(calcPage.getResultHeader(), "Result");
		Assert.assertTrue(calcPage.verifyResultInfoTable());
	}
	
	@Test(groups= {"Smoke"})
	public void carbCalcWithUsUnits_TC_CC_003() {
		calcPage.calculateWithUsUnits("50", "5", "10", "172");
		calcPage.selectActivity("Extra Active: very intense exercise daily, or physical job");
		calcPage.setFormula2();
		calcPage.calculate();
		Assert.assertEquals(calcPage.getResultHeader(), "Result");
		Assert.assertTrue(calcPage.verifyResultInfoTable());
	}
	


}
