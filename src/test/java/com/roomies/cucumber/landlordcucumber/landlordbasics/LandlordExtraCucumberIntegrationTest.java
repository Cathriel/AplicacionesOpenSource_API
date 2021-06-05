package com.roomies.cucumber.landlordcucumber.landlordbasics;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/landlordbasics",
            plugin ={"pretty","html:target/cucumber/landlordbasics"},
            extraGlue = "com.roomies.cucumber.landlordcucumber.landlordcommon")
public class LandlordExtraCucumberIntegrationTest {
}
