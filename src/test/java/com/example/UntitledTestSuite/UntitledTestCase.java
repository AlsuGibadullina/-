package com.example.UntitledTestSuite;

import com.example.UntitledTestSuite.dataClasses.AccountData;
import com.example.UntitledTestSuite.dataClasses.RepositoryData;
import org.junit.*;

public class UntitledTestCase extends TestBase{

  @Test
  public void testUntitledTestCase() throws Exception {
    AccountData user = new AccountData("Chesnochek", "testhomework2022");
    applicationManager.getNavigation().OpenHomePage();
    applicationManager.getSignIn().SingIn(user);
    RepositoryData repository = new RepositoryData("TestName11", "Description");
    applicationManager.getNavigation().OpenHomePage();
    applicationManager.getRepository().CreateNewRepository(repository);
    RepositoryData createdRepository = applicationManager.getRepository().GetCreatedRepositoryData(repository);
    Assert.assertEquals(repository.getName(), createdRepository.getName());
  }
}

