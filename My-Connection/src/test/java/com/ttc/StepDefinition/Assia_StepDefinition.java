package com.ttc.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.ttc.objects.PageMethodObject;
import com.ttc.reports.ReportManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Assia_StepDefinition extends PageMethodObject {
	
	@Before
    public void setUp() {
        // Start the report before each scenario
        ReportManager.startReport();
    }
	
	@Given("Login select journey and refresh")
	public void login_and_select_journey_and_refresh() {
		try {
			LaunchBrowserAndLogin();
			ReportManager.createTest("Regression Check");
			ReportManager.success("User loggedin successfully");
			if(driver.getPageSource().contains("eero")){
				ReportManager.success("He is an eero customer");
			}
			else {
				ReportManager.success("He/she is an ookla customer");
			}
		} catch (Exception e) {
			ReportManager.failure("Failure occured at login scenario");
		}
		
				
	}
	
	@When("Click the Network Service Status")
	public void click_the_network_service_status() {
		try {
	    WebElement NSSStatus =driver.findElement(By.xpath(NSS));
	    String NSSText=NSSStatus.getText();
	    ReportManager.success(NSSText);
		}
        catch (Exception e) {
		ReportManager.failure("Failure in NSS component");
	}
	    driver.close();
	}

	@When("Click the My current speeds")
	public void click_the_my_current_speeds() {
		System.out.println("Helo");
	}

	@When("Click the Get Started Banner")
	public void click_the_get_started_banner() {
		System.out.println("Helo");
	}

	@When("Click the My router tile")
	public void click_the_my_router_tile() {
		System.out.println("Helo");
	}

	@When("Click the Usage tile")
	public void click_the_usage_tile() {
		System.out.println("Helo");
	}

	@When("Click the Connected Device tile")
	public void click_the_connected_device_tile() {
		System.out.println("Helo");
	}

	@When("Click the My telephone tile")
	public void click_the_my_telephone_tile() {
		System.out.println("Helo");
	}

	@When("click the My tv tile")
	public void click_the_my_tv_tile() {
		System.out.println("Helo");
	}

	@Then("click the Email service status tile")
	public void click_the_email_service_status_tile() {
		System.out.println("Helo");
	}
	
	 @After
	    public void tearDown() {
	        // End the report after each scenario
	        ReportManager.endReport();
	        driver.quit();
	    }



}
