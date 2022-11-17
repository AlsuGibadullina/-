package com.example.UntitledTestSuite;

import org.junit.After;
import org.junit.Before;

public class TestBase {

    protected ApplicationManager applicationManager;

    @Before
    public void setUp() throws Exception {
        applicationManager = ApplicationManager.GetInstance();
    }

    @After
    public void finaling() throws Exception {
        applicationManager.finalizing();
    }

}
