package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class relativeLocators {

    public static void wait(int millisegundos) {
        try {
            Thread.sleep(millisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        String chaveDriver = "webdriver.chrome.driver";  
        // String chaveDriver = "webdriver.gecko.driver";  
        // String chaveDriver = "webdriver.edge.driver";    

		String diretorioWebDriver = "C:\\chromedriver_win32\\chromedriver.exe";
		// String diretorioWebDriver = "/usr/bin/chromedriver";

        System.setProperty(chaveDriver, diretorioWebDriver);


		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();
		// WebDriver driver = new EdgeDriver();
    	
        String baseUrl = "https://ubuntu.com/";

        driver.get(baseUrl);
        
        

        By linkCanonical = RelativeLocator.with(By.tagName("a")).above(By.id("ubuntu-logo"));
        driver.findElement(linkCanonical);

        By linkPaginaPrincipal = RelativeLocator.with(By.tagName("a")).below(By.id("title"));
        driver.findElement(linkPaginaPrincipal);

        By lupaDoBotaoSearch = RelativeLocator.with(By.tagName("i")).toRightOf(By.className("u-show--large"));
        driver.findElement(lupaDoBotaoSearch).click();

        By registerForTheSummit = RelativeLocator.with(By.className("p-button--positive")).toLeftOf(By.id("takeover-image"));
        driver.findElement(registerForTheSummit);

        By logosDasEmpresasPertoDaGoogleCloud = RelativeLocator.with(By.tagName("img")).near(By.xpath("//img[@alt='Google Cloud logo']"));
        driver.findElements(logosDasEmpresasPertoDaGoogleCloud).forEach(logo -> System.out.println(logo.getAttribute("alt")));
        
        logosDasEmpresasPertoDaGoogleCloud = RelativeLocator.with(By.tagName("img")).near(By.xpath("//img[@alt='Google Cloud logo']"), 150);
        driver.findElements(logosDasEmpresasPertoDaGoogleCloud).forEach(logo -> System.out.println(logo.getAttribute("alt")));

        wait(5000);
        driver.close();
    }

}