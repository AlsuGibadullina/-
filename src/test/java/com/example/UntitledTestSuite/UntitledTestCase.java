package com.example.UntitledTestSuite;

import java.time.Duration;

import com.example.UntitledTestSuite.dataClasses.AccountData;
import com.example.UntitledTestSuite.dataClasses.RepositoryData;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class UntitledTestCase extends TestBase{

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    AccountData user = new AccountData("AlsuGibadullina", "sadafa54ga");
      OpenHomePage();
      SingIn(user);
    RepositoryData repository = new RepositoryData("TestName", "Description");
    OpenHomePage();
    CreateNewRepository(repository);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}

