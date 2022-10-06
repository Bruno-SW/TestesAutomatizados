package conceitos.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.edge.EdgeDriver;

public class finders {

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
        
        

        By imagens = By.tagName("img");

        // Encontra a primeira ocorrencia do localizador (By)
        WebElement primeiroMatch = driver.findElement(imagens);
        System.out.println(primeiroMatch.getAttribute("alt"));

        // Encontra todas as ocorrencias do localizador
        List<WebElement> todosMatchs = driver.findElements(imagens);
        todosMatchs.forEach(match -> System.out.println(match.getAttribute("alt")));


        // Encontra todos os link dentro do menu
        WebElement menu = driver.findElement(By.id("navigation"));

        List<WebElement> links = menu.findElements(By.className("p-navigation__link-anchor"));
        links.forEach(link -> System.out.println(link.getText()));


        // Encontra o elemento ativo (com foco/selecionado)
        WebElement elementoAtivo = driver.switchTo().activeElement();
        System.out.println(elementoAtivo.getText());



        wait(5000);
        driver.close();
    }

}