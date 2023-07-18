package org.code;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources" , glue = "org.code", monochrome = true, dryRun = false )
public class TestRunnerq {

	
}
