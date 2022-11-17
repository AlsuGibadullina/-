package com.example.UntitledTestSuite;

import com.example.UntitledTestSuite.helpers.NavigationHelper;
import com.example.UntitledTestSuite.helpers.RepositoryHelper;
import com.example.UntitledTestSuite.helpers.SignInHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    protected WebDriver driver;
    protected String baseUrl;
    protected StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;
    private NavigationHelper navigation;
    private SignInHelper signIn;
    private RepositoryHelper repository;


    private ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
        navigation = new NavigationHelper(this, baseUrl);
        signIn = new SignInHelper(this);
        repository = new RepositoryHelper(this);
    }

    private static final ThreadLocal<ApplicationManager> app = new ThreadLocal<ApplicationManager>() {
        @Override
        protected void finalize() {
            app.get().getDriver().quit();
        }
    };

    public void finalizing() {
        app.get().getDriver().quit();
    }

    public static ApplicationManager GetInstance() {
        if (app.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            app.set(newInstance);
        }
        return app.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public NavigationHelper getNavigation() {
        return navigation;
    }

    public SignInHelper getSignIn() {
        return signIn;
    }

    public RepositoryHelper getRepository() {
        return repository;
    }
}
