package com.ttc.objects;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class PageMethodObject extends PageObject{

protected WebDriver driver = new ChromeDriver();
	
	public void LaunchBrowserAndLogin() throws Exception {
		String projectPath=System.getProperty("user.dir");
	    FileReader reader= new FileReader("Properties\\config.properties");
		Properties pro=new Properties();
		pro.load(reader);
		System.out.println("project path:" +projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		String URL=pro.getProperty("LoginURL");
		System.out.println(URL);
		driver.manage().window().maximize();
		driver.get(pro.getProperty("LoginURL"));
	
		try {
			driver.findElement(By.id(CookieAccept)).click();
			}
			catch(Exception e){
				throw new Error("Bypass cookie");
				
			}
		    driver.findElement(By.name(Emailid)).sendKeys(pro.getProperty("UserMailid"));
		    driver.findElement(By.name(Passwordid)).sendKeys(pro.getProperty("UserPassword"));
		    
		    driver.findElement(By.id(LoginCTA)).click();	
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
			wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath(ConnectionTestGetStarted)));		
			//ReportManager.log(Shutterbug.shootPage(driver, Capture.FULL, true).save("C:/Users/lalitha.v/eclipse-workspace/Testing/target/Dashboard.png"));
			TakeScreenShot();
	}
	
	public void TakeScreenShot() {
		Shutterbug.shootPage(driver, Capture.FULL, true).save("C:/Users/lalitha.v/eclipse-workspace/git/MC/My-Connection/target/Dashboard.png");
	}

	protected void journeySelection()
	
	{
		
		driver.findElement(By.xpath(DeveloperTools)).click();
		WebElement dropdownElement=driver.findElement(By.xpath(Journey));
		dropdownElement.click();
			
	}
	
	public void journeyProcess(){
		driver. navigate(). refresh();
		try {
			ConnectionProcess();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void ConnectionProcess() throws InterruptedException  {
        driver.findElement(By.xpath(ConnectionTestGetStarted)).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait1.until(ExpectedConditions.presenceOfElementLocated (By.xpath(TestYourLineText)));
		String ActualURL=driver.getCurrentUrl();
		System.out.println(ActualURL);
		driver.findElement(By.xpath(GetStartedButton)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.presenceOfElementLocated (By.linkText(MyConnectionBreadcrumb)));
		Thread.sleep(1000);
		TakeScreenShot();
		driver.findElement(By.linkText(MyConnectionBreadcrumb)).click();
	}

	public void SpeedProcess() throws InterruptedException {
		driver. navigate(). refresh();
		driver.findElement(By.xpath(LearnMoreAboutYourSpeed)).click();
		driver.wait(30000);
		TakeScreenShot();
		
	}
	
	public void BackToMc() {
		driver.findElement(By.linkText(MyConnectionBreadcrumb)).click();
	}
	

}
