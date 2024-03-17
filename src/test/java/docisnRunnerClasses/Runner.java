package docisnRunnerClasses;

import io.cucumber.core.cli.Main;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( plugin = {"pretty" ,
        "html:target/cucumber-html-report",
        "json:target/cucumber.json",
        "junit:target/hc-cucumber.xml",
        "rerun:target/hc-rerun.txt"},
        features = {"src/test/resources/features/Login.feature"},
        monochrome = true,
        glue = {"docisnStepDefinationsClasses"},
        tags = "@run")

public class  Runner {
    public static void main(String[] args) {
        Main.run(args, Thread.currentThread().getContextClassLoader());
    }
}
