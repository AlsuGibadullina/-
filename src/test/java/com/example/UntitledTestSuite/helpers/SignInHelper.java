package com.example.UntitledTestSuite.helpers;

import com.example.UntitledTestSuite.ApplicationManager;
import com.example.UntitledTestSuite.dataClasses.AccountData;
import org.openqa.selenium.By;

public class SignInHelper extends HelperBase{

    public SignInHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

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
}
