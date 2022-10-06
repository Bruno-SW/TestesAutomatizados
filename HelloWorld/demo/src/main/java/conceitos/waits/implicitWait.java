package conceitos.waits;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.edge.EdgeDriver;

public class implicitWait {

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
    	


        // Define o tempo de espera implicito, se elemento nao for encontrado no tempo especificado um erro é levantado
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



        String baseUrl = "https://ubuntu.com/";

        driver.get(baseUrl);
        
        WebElement botaoAceitar = driver.findElements(By.tagName("button"))
                                        .stream()
                                        .filter(botao -> botao.getText().equals("Accept all and visit site"))
                                        .collect(Collectors.toList())
                                        .get(0);
                                        
        // WebElement botaoAceitar = driver.findElement(By.xpath("//button[text() = 'Accept all and visit site']"));

        botaoAceitar.click();       
               
        WebElement dropDownDownload = driver.findElements(By.className("p-navigation__link-anchor"))
                                        .stream()
                                        .filter(botao -> botao.getText().equals("Download"))
                                        .collect(Collectors.toList())
                                        .get(0);

        // WebElement dropDownDownload = driver.findElement(By.xpath("//a[@class='p-navigation__link-anchor' and text() = 'Download']"));

        dropDownDownload.click();    

        List<WebElement> desktopUbuntu = driver.findElements(By.tagName("a"))
                                        .stream()
                                        .filter(link -> link.getText().startsWith("Ubuntu Desktop"))
                                        .collect(Collectors.toList());

        int nroTentativas = 1;
        while (desktopUbuntu.isEmpty() || (!desktopUbuntu.isEmpty() && !desktopUbuntu.get(0).isDisplayed() && !desktopUbuntu.get(0).isEnabled())){
            desktopUbuntu = driver.findElements(By.tagName("a"))
                                .stream()
                                .filter(link -> link.getText().startsWith("Ubuntu Desktop"))
                                .collect(Collectors.toList());
            nroTentativas +=1;
        }

        System.out.println(String.format("Foi preciso processar %d vezes para poder clicar no link", nroTentativas));


        // WebElement desktopUbuntu = driver.findElement(By.xpath("//a[contains(text(), 'Ubuntu Desktop')]/parent::h4"));
        
        desktopUbuntu.get(0).click(); 

        WebElement botaoDownload = driver.findElement(By.className("is-wide"));

        // WebElement botaoDownload = driver.findElement(By.xpath("//a[@class= 'p-button--positive is-wide']"));

        botaoDownload.click();
        

        wait(5000);
        driver.close();
    }

}