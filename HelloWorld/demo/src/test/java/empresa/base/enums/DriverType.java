package empresa.base.enums;

import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import empresa.base.DriverSetup;

public enum DriverType implements DriverSetup{
	FIREFOX {
		public FirefoxOptions getDesiredCapabilities() {
			FirefoxOptions capabilities = new FirefoxOptions();
			capabilities.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			return capabilities;
		}

		public WebDriver getWebDriverObject(Capabilities capabilities) {
				   return new FirefoxDriver((FirefoxOptions) capabilities);
		}
	},
	CHROME {
			public ChromeOptions getDesiredCapabilities() {
				ChromeOptions capabilities = new ChromeOptions();
					capabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
					HashMap<String, String> chromePreferences = new HashMap<String, String>();
					chromePreferences.put("profile.password_manager_enabled", "false");
					capabilities.setCapability("chrome.prefs", chromePreferences);
					capabilities.setPageLoadStrategy(PageLoadStrategy.NORMAL);
					return capabilities;
			}

			public WebDriver getWebDriverObject(Capabilities capabilities) {
					return new ChromeDriver((ChromeOptions) capabilities);
			}
	},
	EDGE {
			public EdgeOptions getDesiredCapabilities() {
				EdgeOptions capabilities = new EdgeOptions();
					capabilities.setCapability("requireWindowFocus", true);
					capabilities.setPageLoadStrategy(PageLoadStrategy.NORMAL);
					return capabilities;
			}

			public WebDriver getWebDriverObject(Capabilities capabilities) {
					return new EdgeDriver((EdgeOptions) capabilities);
			}
	};
}