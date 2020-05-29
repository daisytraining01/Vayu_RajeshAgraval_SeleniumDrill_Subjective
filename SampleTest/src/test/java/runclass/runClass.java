package runclass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"classpath:Features"},										//Location of the feature file folder
		glue = {"StepDefinitions"}, 												//Where my definition is written
		tags= {"@smoke"},													//Which tag needs to be executed
		plugin= {"pretty","html:target/Results/Cucumber"}, 									//Reports generations
		dryRun = true,																//creates body of the undefined functions
		monochrome= true															//to know the pass and fail statics
		)

public class runClass {

}
