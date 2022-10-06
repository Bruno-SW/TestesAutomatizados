package conceitos.drivers.options;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.edge.EdgeOptions;
// import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.edge.EdgeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;

public class pageLoadStrategy {
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



        // O WebDriver espera a página carregar completamente
        driverOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        // O WebDriver espera até receber o sinal do evento DOMContentLoaded,
        // que ocorre quando HTML inicial é carregado e interpretado completamente
        // driverOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

        // O WebDriver espera somente até o HTML inicial carregar
        // driverOptions.setPageLoadStrategy(PageLoadStrategy.NONE);


       
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