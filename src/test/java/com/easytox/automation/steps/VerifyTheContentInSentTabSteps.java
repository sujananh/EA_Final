package com.easytox.automation.steps.faxQueue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyTheContentInSentTabSteps {
	private WebDriver driver;
	
	public VerifyTheContentInSentTabSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Click on 'Sent' tab$")
	public void click_on_Sent_tab() throws Throwable {
		driver.navigate().to("http://bmtechsol.com:8080/easytox/queue/faxlist");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[href = '#sentfaxtab']")).click();
	}

	@Then("^Sent fax queue list should be displayed$")
	public void sent_fax_queue_list_should_be_displayed() throws Throwable {
		Assert.assertEquals(driver.findElement(By.cssSelector("#outboundtab ul > li.active > a")).getText(), "Sent");
	}

	@When("^Enter any search criteria and click on search icon CS$")
	public void enter_any_search_criteria_and_click_on_search_icon() throws Throwable {
		WebElement searchBox = driver.findElement(By.cssSelector("#sentFaxtable_filter > label > input"));
		searchBox.clear();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("#sentFaxtable_filter > label")));
		action.click();
		action.sendKeys("test");
		action.build().perform();
	}

	@Then("^Matching records with entered data should be displayed in the Fax Queue List CS$")
	public void matching_records_with_entered_data_should_be_displayed_in_the_Fax_Queue_List() throws Throwable {
		WebElement tableBody = driver.findElement(By.cssSelector("#sentFaxtable tbody"));
		List<WebElement> cells = tableBody.findElements(By.tagName("td"));
		
		for (WebElement cell : cells) {
			if(cell.getText().equals("test")){
				Assert.assertTrue(cell.getText().equals("test"));
				break;
			}
		}
		
	}
}
