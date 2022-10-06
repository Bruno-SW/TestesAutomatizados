package empresa.base;

import org.openqa.selenium.WebDriver;

import empresa.base.enums.DriverType;


public class WebDriverManager {
    private WebDriver webdriver;
    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");

    public WebDriver getDriver() {
                if (null == webdriver) {
                           System.out.println(" ");
                           System.out.println("Sistema Operacional Atual: " + operatingSystem);
                           System.out.println("Arquitetura Atual: " + systemArchitecture);
                           System.out.println("Browser selecionado: Firefox");
                           System.out.println(" ");
                           webdriver = DriverType.CHROME.getWebDriverObject(DriverType.CHROME.getDesiredCapabilities());
                }
                return webdriver;
    }

    public void quitDriver() {
                if (null != webdriver) {
                           webdriver.quit();
                           webdriver = null;
                }
    }
}