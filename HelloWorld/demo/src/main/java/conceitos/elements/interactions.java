package conceitos.elements;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.edge.EdgeDriver;

public class interactions {

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
        
        
        WebElement botaoDeBusca = driver.findElement(By.className("p-icon--search"));        
        // Clica no elemento
        botaoDeBusca.click();

        WebElement campoDeBusca = driver.findElement(By.className("p-search-box__input"));
        WebElement campoComFoco = driver.switchTo().activeElement();

        // Valida que campo de busca é o campo com foco
        assertEquals(campoComFoco, campoDeBusca);

        // Simula texto sendo digitado no elemento
        campoDeBusca.sendKeys("download");

        // Limpa o conteudo do elemento (nem todos os elementos são "limpaveis")
        campoDeBusca.clear();

        // Simula outras teclas do teclado também
        campoDeBusca.sendKeys(Keys.RETURN);



        // 


        wait(5000);
        driver.close();
    }

}