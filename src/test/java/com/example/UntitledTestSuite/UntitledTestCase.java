package com.example.UntitledTestSuite;

import com.example.UntitledTestSuite.dataClasses.AccountData;
import com.example.UntitledTestSuite.dataClasses.RepositoryData;
import com.example.UntitledTestSuite.output.RepositoryTestDataParser;
import org.junit.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UntitledTestCase extends TestBase{

  public static Stream<Arguments> parseRepo() throws ParserConfigurationException, IOException, SAXException {
    RepositoryTestDataParser repositoryTestDataParserTestDataParser = new RepositoryTestDataParser();
    List<RepositoryData> repoData = repositoryTestDataParserTestDataParser.parseData();
    ArrayList<Arguments> arguments = new ArrayList<>();
    for (RepositoryData repo: repoData) {
      arguments.add(Arguments.of(repo));
    }
    return arguments.stream();
  }

  @ParameterizedTest
  @MethodSource("parseRepo")
  public void testUntitledTestCase(RepositoryData input) throws Exception {
    applicationManager = ApplicationManager.GetInstance();
    AccountData user = new AccountData("Chesnochek", "testshomework2022");
    applicationManager.getNavigation().OpenHomePage();
    applicationManager.getSignIn().SingIn(user);
    applicationManager.getNavigation().OpenHomePage();
    applicationManager.getRepository().CreateNewRepository(input);
    RepositoryData createdRepository = applicationManager.getRepository().GetCreatedRepositoryData(input);
    Assert.assertEquals(input.getName(), createdRepository.getName());
  }
}

