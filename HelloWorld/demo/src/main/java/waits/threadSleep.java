package waits;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.edge.EdgeDriver;

public class threadSleep {


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
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // List<WebElement> botoes = driver.findElements(By.tagName("button"));

        WebElement botaoAceitar = driver.findElement(By.xpath("//button[text() = 'Accept all and visit site']"));

        // Stream<WebElement> botaoAceitar = botoes.stream()
        //                                 .filter(botao -> botao.getText() == "Accept all and visit site");


        botaoAceitar.click();
       



        driver.wait(5000);
        
        driver.close();
       
    }

}