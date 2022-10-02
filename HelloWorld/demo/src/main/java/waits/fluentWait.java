package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class fluentWait {

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
        
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(5))
                                .pollingEvery(Duration.ofMillis(500))
                                .ignoring(NoSuchElementException.class);

        
        WebElement botaoAceitar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Accept all and visit site']")));

        botaoAceitar.click();       
               

        WebElement dropDownDownload = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='p-navigation__link-anchor' and text() = 'Download']")));

        dropDownDownload.click();    
        
               
        WebElement desktopUbuntu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Ubuntu Desktop')]/parent::h4")));
        
        desktopUbuntu.click(); 


        WebElement botaoDownload = wait.until(ExpectedConditions.elementToBeClickable(By.className("is-wide")));

        botaoDownload.click();
        

        wait(5000);
        driver.close();
    }

}