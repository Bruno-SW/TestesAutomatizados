package empresa.base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.remote.AbstractDriverOptions;

public interface DriverSetup {
          WebDriver getWebDriverObject(Capabilities desiredCapabilities);

          Capabilities getDesiredCapabilities();
}