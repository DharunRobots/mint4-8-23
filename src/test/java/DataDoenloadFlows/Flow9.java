package DataDoenloadFlows;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import search.DataDownload;
import search.SearchPage;

public class Flow9 {

	WebDriver driver;
	SearchPage elem;
	DataDownload ele;

	@BeforeTest
	public void beforeTest() {

		driver = new ChromeDriver();
		SearchPage elem1 = new SearchPage(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://qa.mint360.in/#/auth/signin");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void login1() {
		elem = new SearchPage(driver);
		elem.enterUserName("sameera@gmail.in");
		elem.enterPassword("123456");
		elem.verifyLogin();

	}

	@Test(priority = 2)
	public void dataDown() throws IOException {
		ele = new DataDownload(driver);
		ele.dataDownload();
		ele.selectProject();
		ele.selectStartdate();
		ele.selectEnddate();
		ele.leadStageNewREengaged();

		ele.Submit();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./scrrenshot9.png");
		FileHandler.copy(src, dest);

	}

}
