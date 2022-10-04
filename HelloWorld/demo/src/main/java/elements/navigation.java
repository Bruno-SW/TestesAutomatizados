package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.edge.EdgeDriver;

public class navigation {

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

        // Navega até uma página
        driver.get(baseUrl); // = driver.navigate().to(baseUrl);
        driver.navigate().to(baseUrl);

        // Volta para página anterior
        driver.navigate().back();

        // Vai para a próxima página
        driver.navigate().forward();

        // Atualiza página
        driver.navigate().refresh();

        wait(5000);
        driver.close();
    }

}