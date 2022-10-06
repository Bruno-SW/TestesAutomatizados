package conceitos.drivers.remotewebdriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.edge.EdgeOptions;
// import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class capabilities {
    public static void main(String[] args) throws MalformedURLException {
        String chaveDriver = "webdriver.chrome.driver";  
        // String chaveDriver = "webdriver.edge.driver";    
        // String chaveDriver = "webdriver.gecko.driver";  

		String diretorioWebDriver = "C:\\chromedriver_win32\\chromedriver.exe";
		// String diretorioWebDriver = "/usr/bin/chromedriver";

        System.setProperty(chaveDriver, diretorioWebDriver);
        
        ChromeOptions driverOptions = new ChromeOptions();
        // EdgeOptions driverOptions = new EdgeOptions();
        // FirefoxOptions driverOptions = new FirefoxOptions();


        
        // Pode-se setar o nome do sistema operacional, que ira selecionar o SO quando usado em um remote-end como Docker por exemplo
        driverOptions.setCapability("browserVersion", "106");
        driverOptions.setCapability("platformName", "Windows 10");

        

        RemoteWebDriver driver = new RemoteWebDriver(new URL("ipServidor:porta"), driverOptions);

        try {
            // Navega para a URL
            driver.get("https://google.com");
            driver.manage().window().maximize();
        } finally {
            driver.quit();
        }     

      
    }
}