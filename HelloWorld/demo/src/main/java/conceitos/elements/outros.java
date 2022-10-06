package conceitos.elements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.edge.EdgeDriver;

public class outros {

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
        
        
        // Encontra mensagem de alerta e interage com ela
        Alert alerta = driver.switchTo().alert();
        alerta.accept();

        alerta.dismiss();

        alerta.sendKeys("Selenium");

        

        // Adiciona um cookie
        driver.manage().addCookie(new Cookie("chave", "valor"));

        // Obtem valor de um cookie
        driver.manage().getCookieNamed("chave");

        // Obtem todos os cookies
        driver.manage().getCookies();

        // Deleta um cookie
        driver.manage().deleteCookieNamed("chave");

        // Deleta todos os cookies
        driver.manage().deleteAllCookies();



        // Trocando de frame (iframe)
        // Pelo elemento
        WebElement iframe = driver.findElement(By.cssSelector("#modal>iframe"));
        driver.switchTo().frame(iframe);

        // Pelo nome ou id
        driver.switchTo().frame("nomeOuId");

        // Por index
        driver.switchTo().frame(1);

        // Saindo do contexto (voltando para o contexto original)
        driver.switchTo().defaultContent();



        // Obtem manipulador da janela/aba
        String abaOriginal = driver.getWindowHandle();
        
        // Numero de abas abertas
        driver.getWindowHandles().size();

        // Seleciona aba
        driver.switchTo().window(abaOriginal);
        
        // Abre nova aba e seleniona
        driver.switchTo().newWindow(WindowType.TAB);

        // Abre nova janela e seleniona
        driver.switchTo().newWindow(WindowType.WINDOW);

        // Fecha aba/janela selecionada
        driver.close();


        // Interacoes com a janela
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();



        wait(5000);
        driver.close();
    }

}