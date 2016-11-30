/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxBinary
import org.openqa.selenium.firefox.FirefoxDriver
//import org.webjars.
import org.openqa.selenium.firefox.MarionetteDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.DriverCommand

import static org.openqa.selenium.remote.DesiredCapabilities.firefox

waiting {
	timeout = 20
}
//System.setProperty("webdriver.gecko.driver","D:\\geckodriver-0.11.1\\webdriver.gecko.driver");
environments {
	
	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = { new ChromeDriver() }
	}
	
	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		//System.setProperty('webdriver.firefox.driver', 'D:\\geckodriver-0.11.1\\webdriver.gecko.driver')
		//System.setProperty("webdriver.firefox.marionette","D:\\geckodriver-0.11.1\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver","D:\\geckodriver-0.11.1\\geckodriver.exe");
		//FirefoxDriver.metaClass.quit << {->  Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");}
		//FirefoxDriver firefoxDriver = new FirefoxDriver();

		WebDriver.metaClass.quit = {->
			Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
		}

		driver = { new FirefoxDriver() }
		//driver = { new MarionetteDriver()}
	}

    phantomJs {
        driver = { new PhantomJSDriver() }
    }

}

//gradlew -DfirefoxTest.single=TutBySearch* firefoxTest

// To run the tests with all browsers just run “./gradlew test”

baseUrl = "http://www.tut.by"
reportsDir = new File("target/runtime_reports_dir")

/*def cleanup() {
	//Thread.sleep(2000);
	Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
}*/
