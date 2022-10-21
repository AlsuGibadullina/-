package com.example.UntitledTestSuite;

import com.example.UntitledTestSuite.dataClasses.AccountData;
import com.example.UntitledTestSuite.dataClasses.RepositoryData;
import org.openqa.selenium.*;

public class TestBase {
    public WebDriver driver;
    public String baseUrl;
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;

    public void SingIn(AccountData user) {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("login_field")).clear();
        driver.findElement(By.id("login_field")).sendKeys(user.getName());
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        driver.findElement(By.id("login_field")).click();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.name("commit")).click();
    }

    public void CreateNewRepository(RepositoryData repository) {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New repository'])[1]/preceding::summary[1]")).click();
        driver.findElement(By.linkText("New repository")).click();
        driver.findElement(By.id("repository_name")).click();
        driver.findElement(By.id("repository_name")).clear();
        driver.findElement(By.id("repository_name")).sendKeys(repository.getName());
        driver.findElement(By.id("repository_description")).click();
        driver.findElement(By.id("repository_description")).clear();
        driver.findElement(By.id("repository_description")).sendKeys(repository.getDescription());
        driver.findElement(By.xpath("//form[@id='new_repository']/div[7]/button")).click();
    }

    public void OpenHomePage() {
        driver.get("https://github.com/");
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
