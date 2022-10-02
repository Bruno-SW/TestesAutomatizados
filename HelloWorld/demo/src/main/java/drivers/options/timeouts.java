package drivers.options;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.edge.EdgeOptions;
// import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.edge.EdgeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class timeouts {
    public static void main(String[] args) {
        String chaveDriver = "webdriver.chrome.driver";  
        // String chaveDriver = "webdriver.edge.driver";    
        // String chaveDriver = "webdriver.gecko.driver";  

		String diretorioWebDriver = "C:\\chromedriver_win32\\chromedriver.exe";
		// String diretorioWebDriver = "/usr/bin/chromedriver";

        System.setProperty(chaveDriver, diretorioWebDriver);
        
        ChromeOptions driverOptions = new ChromeOptions();
        // EdgeOptions driverOptions = new EdgeOptions();
        // FirefoxOptions driverOptions = new FirefoxOptions();


        
        // Determina quando deve-se interromper a execução do script no contexto atual de navegação
        driverOptions.setScriptTimeout(Duration.ofSeconds(30));

        // Determina quanto tempo o driver irá esperar a página carregar antes de levantar uma TimeoutException
        driverOptions.setPageLoadTimeout(Duration.ofSeconds(300));

        // Determina quanto tempo o driver irá tentar encontrar um elemento antes de levantar uma TimeoutException
        driverOptions.setImplicitWaitTimeout(Duration.ofSeconds(0));
        


        WebDriver driver = new ChromeDriver(driverOptions);
        // WebDriver driver = new EdgeDriver(driverOptions);
        // WebDriver driver = new FirefoxDriver(driverOptions);

        try {
            // Navega para a URL
            driver.get("https://google.com");
            // driver.manage().addCookie(null);
            driver.manage().window().maximize();
        } finally {
            driver.quit();
        }     

      
    }
}