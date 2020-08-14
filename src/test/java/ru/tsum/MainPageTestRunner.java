package ru.tsum;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "pretty", "json:target/cucumber-report/report.json"},
        features = {"src/test/resources/features"},
        glue={"stepDefs"},
        tags = {"@MainPage"}
)
public class MainPageTestRunner extends AbstractTestNGCucumberTests {
}
