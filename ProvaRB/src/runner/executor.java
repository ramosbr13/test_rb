package runner;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
//esta classe lê o passo a passo como se fosse um tradutor do CUCUMBER para o Java
@RunWith(Cucumber.class)
@CucumberOptions(features = "features", glue={"stepDefinition"})
public class executor {

}
