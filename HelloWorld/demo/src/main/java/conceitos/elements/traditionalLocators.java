package conceitos.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.edge.EdgeDriver;

public class traditionalLocators {

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
        
        
        
        // driver.findElement(By.className("p-heading--4 p-heading-icon__title")); // Não é permitido procurar por nome de classe compostos (separado por espaço), vai dar erro
        driver.findElement(By.className("p-button--positive"));

        driver.findElement(By.cssSelector("a[class='p-button--positive']"));

        driver.findElement(By.id("takeover-primary-url"));

        driver.findElement(By.name("q"));

        driver.findElement(By.linkText("Learn more"));

        driver.findElement(By.partialLinkText("Learn"));

        driver.findElement(By.tagName("a"));

        driver.findElement(By.xpath("//*[@id = 'takeover-primary-url']"));

        
        wait(5000);
        driver.close();
    }

}