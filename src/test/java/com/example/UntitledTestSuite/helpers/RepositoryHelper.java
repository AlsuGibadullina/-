package com.example.UntitledTestSuite.helpers;

import com.example.UntitledTestSuite.ApplicationManager;
import com.example.UntitledTestSuite.dataClasses.RepositoryData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RepositoryHelper extends HelperBase{

    public RepositoryHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void CreateNewRepository(RepositoryData repository) {
        driver.get("https://github.com/new");
        driver.findElement(By.id("repository_name")).click();
        driver.findElement(By.id("repository_name")).clear();
        driver.findElement(By.id("repository_name")).sendKeys(repository.getName());
        driver.findElement(By.id("repository_description")).click();
        driver.findElement(By.id("repository_description")).clear();
        driver.findElement(By.id("repository_description")).sendKeys(repository.getDescription());
        driver.findElement(By.xpath("//form[@id='new_repository']/div[5]/button")).click();
        driver.get("https://github.com/Chesnochek/"+repository.getName());
    }

    public RepositoryData GetCreatedRepositoryData(RepositoryData repository){
        driver.get("https://github.com/Chesnochek/"+repository.getName());
        String name = driver.findElement(By.xpath("//*[@id=\"repository-container-header\"]/div[1]/div/div/strong/a")).getText();
        return new RepositoryData(name);
    }
}
