package apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop; 
	
	@Before(order=0)
	public void getProperty(){
		configReader=new ConfigReader();
		prop=configReader.init_prop();
		
	}
	
	@Before(order=1)
	public void launchBrowser() {
		
		String browser=prop.getProperty("browser");
		driverFactory=new DriverFactory();
		driver=driverFactory.init_driver(browser);
				
	}
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		
		String screenShotName=scenario.getName().replaceAll(" ", "_");
		if(scenario.isFailed()) {
			byte[] sourceBytes=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourceBytes, "image/png", screenShotName);
		}
	}
	
}
