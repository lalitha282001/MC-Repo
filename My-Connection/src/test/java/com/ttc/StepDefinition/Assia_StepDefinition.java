package com.ttc.StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
		ReportManager.startReport();
	}

	@Given("Login select journey and refresh")
	public void login_and_select_journey_and_refresh() {
		try {
			LaunchBrowserAndLogin();
			ReportManager.createTest("Regression Check");
			ReportManager.success("User logged in successfully");
		} catch (Exception e) {
			ReportManager.failure("Exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@When("Click the Network Service Status")
	public void click_the_network_service_status() {
		try {
			WebElement NSSStatus = driver.findElement(By.xpath(NSS));
			String NSSText = NSSStatus.getText();
			ReportManager.success(NSSText);
		} catch (Exception e) {
			ReportManager.failure("Exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@When("Click the My current speeds")
	public void click_the_my_current_speeds() {
		try {
			WebElement Mycurrentspeeds = driver.findElement(By.xpath("//div[@class='currentSpeedSection']"));
			String MycurrentspeedsText = Mycurrentspeeds.getText();
			ReportManager.success(MycurrentspeedsText);
		} catch (Exception e) {
			ReportManager.failure("Exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
		TakeScreenShot();
	}

	@When("Click the Get Started Banner")
	public void click_the_get_started_banner() {
		System.out.println("Helo");
	}

	@When("Click the My router tile")
	public void click_the_my_router_tile() {
		try {
			List<WebElement> elements = driver.findElements(By.xpath(MyRouterTile));

			if (!elements.isEmpty()) {
				System.out.println("Router tile is present!");
				driver.findElement(By.xpath(MyRouterTile)).click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AboutRouterText)));
				driver.findElement(By.xpath(RouterClose)).click();
				ReportManager.success("Router tile is present!");
			} else {
				ReportManager.success("Router tile is NOT present!");
			}

		} catch (Exception e) {
			ReportManager.failure("Exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

		TakeScreenShot();
	}

	@When("Click the Usage tile")
	public void click_the_usage_tile() {
		try {
			List<WebElement> elements = driver.findElements(By.xpath(MyUsageTile));
			if (!elements.isEmpty()) {
				ReportManager.success("Usage tile is present!");

				driver.findElement(By.xpath(MyUsageTile)).click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UsageBar)));
				ReportManager.success("Usage bar is present!");
	
			} else {
				ReportManager.success("Usage tile is NOT present!");
			}
		} catch (Exception e) {
			ReportManager.failure("Exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		TakeScreenShot();
		BackToMc();

	}


	
	@When("Click the My eero tile")
	public void click_the_my_eero_tile() {
		
		try {
			List<WebElement> elements = driver.findElements(By.xpath(MyEeroTile));
			if (!elements.isEmpty()) {
				ReportManager.success("Eero tile is present!");
				driver.findElement(By.xpath(MyEeroTile)).click();
				ReportManager.success("Clicked on Eero tile.");

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EeroImage)));
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SetupTile)));
				ReportManager.success("Eero page is displayed.");
				TakeScreenShot();

				driver.findElement(By.xpath(SetupTile)).click();
				ReportManager.success("Clicked on Setup tile.");
				WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
				wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath(NetworkTextEeropage)));
				driver.findElement(By.xpath(SetupPagelink)).click();
				WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(60));
				wait11.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SetupPagecontainer)));
				TakeScreenShot();

//		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
//		        driver.findElement(By.xpath(EeroPageLP)).click();
//		        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='fr_62642_26101']"));
//		        driver.switchTo().frame(iframe);
//		        ReportManager.success("Switched to Live Chat iframe.");
//		        WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(60));
//		        wait11.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LiveChat)));
//		        ReportManager.success("Live Chat is visible.");
//		        driver.findElement(By.xpath(Livechat3dot)).click();
//		        driver.findElement(By.xpath(LPEndCovo)).click();
//		        ReportManager.success("Ended the Live Chat conversation.");

				driver.findElement(By.xpath(Setupbreadcrumb)).click();
				driver.findElement(By.xpath(MyeeroBreadcrumb)).click();
				driver.findElement(By.xpath(ManageTile)).click();
				ReportManager.success("Clicked on Manage tile.");
				WebDriverWait wait3=new WebDriverWait(driver, Duration.ofSeconds(60));
				wait3.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ManageContainer)));
				TakeScreenShot();
				driver.findElement(By.xpath(MyeeroBreadcrumb)).click();
				BackToMc();
			} else {
				ReportManager.success("Eero tile is NOT present.");
			}
		} catch (Exception e) {
			ReportManager.failure("Exception occurred: " + e.getMessage());
			e.printStackTrace(); // Optional: keep for console output
		}
	}

	@When("Click the Connected Device tile")
	public void click_the_connected_device_tile() {
		try {
			List<WebElement> elements = driver.findElements(By.xpath(ConnectedDeviceTile));
			if (!elements.isEmpty()) {
				ReportManager.success("Device tile is present!");
				driver.findElement(By.xpath(ConnectedDeviceTile)).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				TakeScreenShot();
				BackToMc();
			} else {
				ReportManager.success("Device tile is NOT present.");
			}
		} catch (Exception e) {
			ReportManager.failure("Exception occurred: " + e.getMessage());
			e.printStackTrace(); // Optional: keep for console output
		}
	}

	@When("Click the My telephone tile")
	
	public void click_the_my_telephone_tile() {
		try {
			List<WebElement> elements = driver.findElements(By.xpath(MyTelephone));
			if (!elements.isEmpty()) {
				ReportManager.success("Telephone tile is present!");
				driver.findElement(By.xpath(MyTelephone)).click();
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
				wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(TelephoneTML)));
				TakeScreenShot();
				BackToMc();
			} else {
				ReportManager.success("Telephone tile is NOT present.");
			}
		} catch (Exception e) {
			ReportManager.failure("Exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	@When("click the My tv tile")
	public void click_the_my_tv_tile() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<WebElement> elements = driver.findElements(By.xpath(MyTV));
			if (!elements.isEmpty()) {
				ReportManager.success("My TV tile is present!");
				driver.findElement(By.xpath(MyTV)).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				List<WebElement> elements1 = driver.findElements(By.xpath(OldTvCustomer));
				if (!elements1.isEmpty()) {
					ReportManager.success("He is an older TV box customer");
				} else {
					driver.findElements(By.xpath(TVhub));
					ReportManager.success("He is an TV hub customer");
				}
			} else {
				ReportManager.success("He is an TV box 4k customer");
			}
			TakeScreenShot();
			BackToMc();
			System.out.println("Back to MC");
		}

		catch (Exception e) {
			ReportManager.failure("Exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
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
