package conceitos.waits;

import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.edge.EdgeDriver;

public class threadSleep {

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
        
        wait(5000);

        WebElement botaoAceitar = driver.findElements(By.tagName("button"))
                                        .stream()
                                        .filter(botao -> botao.getText().equals("Accept all and visit site"))
                                        .collect(Collectors.toList())
                                        .get(0);
                                        
        // WebElement botaoAceitar = driver.findElement(By.xpath("//button[text() = 'Accept all and visit site']"));

        botaoAceitar.click();       
        
        wait(5000);
        

        WebElement dropDownDownload = driver.findElements(By.className("p-navigation__link-anchor"))
                                        .stream()
                                        .filter(botao -> botao.getText().equals("Download"))
                                        .collect(Collectors.toList())
                                        .get(0);

        // WebElement dropDownDownload = driver.findElement(By.xpath("//a[@class='p-navigation__link-anchor' and text() = 'Download']"));

        dropDownDownload.click();    

        wait(5000);

        WebElement desktopUbuntu = driver.findElements(By.tagName("a"))
                                        .stream()
                                        .filter(link -> link.getText().startsWith("Ubuntu Desktop"))
                                        .collect(Collectors.toList())
                                        .get(0);

        // WebElement desktopUbuntu = driver.findElement(By.xpath("//a[contains(text(), 'Ubuntu Desktop')]/parent::h4"));
        
        desktopUbuntu.click(); 

        wait(5000);

        WebElement botaoDownload = driver.findElement(By.className("is-wide"));

        // WebElement botaoDownload = driver.findElement(By.xpath("//a[@class= 'p-button--positive is-wide']"));

        botaoDownload.click();
        
        wait(5000);

        driver.close();
    }

}