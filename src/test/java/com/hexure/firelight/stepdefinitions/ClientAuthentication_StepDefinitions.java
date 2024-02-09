package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.*;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ClientAuthentication_StepDefinitions extends FLUtilities {
    private WebDriver driver;
    private TestContext testContext;

    private static final Logger Log = LogManager.getLogger(ClientAuthentication_StepDefinitions.class);

    public ClientAuthentication_StepDefinitions(TestContext context) {
        testContext = context;
        driver = context.getDriver();
    }


}