package elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsAPI {

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
        
        
        // Sequencia de acoes mais "complexas"
        WebElement elementoClicavel = driver.findElement(By.id("clicavel"));

        new Actions(driver)
        .moveToElement(elementoClicavel)
        .pause(Duration.ofMillis(500))
        .clickAndHold()
        .pause(Duration.ofMillis(500))
        .sendKeys("texto")
        .perform();

        // Acoes teclado 
        new Actions(driver)
        .keyDown(Keys.CONTROL)
        .sendKeys("a")
        .keyUp(Keys.CONTROL)
        .perform();

        // Acoes do mouse
        new Actions(driver)
        .moveToElement(elementoClicavel)
        .clickAndHold()
        .moveByOffset(10, 0)
        .release()
        .contextClick()
        .click()
        .dragAndDrop(elementoClicavel, elementoClicavel) // a ideia é usar dois elementos diferentes
        .doubleClick()
        .scrollToElement(elementoClicavel)
        .scrollByAmount(0, 100);


        wait(5000);
        driver.close();
    }

}