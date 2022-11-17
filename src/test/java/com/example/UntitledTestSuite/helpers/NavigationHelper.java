package com.example.UntitledTestSuite.helpers;
import com.example.UntitledTestSuite.ApplicationManager;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{
    private String baseURL;
    public NavigationHelper(ApplicationManager applicationManager, String baseURL) {
        super(applicationManager);
        this.baseURL = baseURL;
    }

    public void MyRepositoriesPage() {
        driver.get("https://github.com/Chesnochek?tab=repositories");
    }

    public void OpenHomePage() {
        driver.get("https://github.com/");
    }
}
