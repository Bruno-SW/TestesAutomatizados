package empresa.base;

import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
        private static List<WebDriverManager> webDriverThreadPool = Collections.synchronizedList(new ArrayList<WebDriverManager>());
        private static ThreadLocal<WebDriverManager> driverThread;

        @AfterMethod
        public static void clearCookies() {
            System.out.println("Estou limpando os Cookies");
            getDriver().manage().deleteAllCookies();
        }

        @BeforeSuite
        public static void antesDoLoteDeClassesASeremTestadasInicializar(){
            System.out.println("Estou iniciando o navegador");
            instantiateDriverObject();
        }

        @AfterSuite
        public static void depoisDoLoteDeClassesASeremTestadasFinalizar(){
            closeDriverObjects();
        }



        public static WebDriver getDriver() {
            return driverThread.get().getDriver();
        }    
        
        public static void wait(int millisegundos) {
            try {
                Thread.sleep(millisegundos);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void antesDeCadaTeste(){

        }

        

        public static void instantiateDriverObject() {        
            String chaveDriver = "webdriver.chrome.driver";  
            // String chaveDriver = "webdriver.edge.driver";    
            // String chaveDriver = "webdriver.gecko.driver";  

            String diretorioWebDriver = "C:\\chromedriver_win32\\chromedriver.exe";
            // String diretorioWebDriver = "/usr/bin/chromedriver";

            System.setProperty(chaveDriver, diretorioWebDriver);
            driverThread = new ThreadLocal<WebDriverManager>() {
                        @Override
                        protected WebDriverManager initialValue() {
                                    WebDriverManager webDriverThread = new WebDriverManager();
                                    webDriverThreadPool.add(webDriverThread);
                                    return webDriverThread;
                        }
            };
        }
        
        public static void closeDriverObjects() {
            for (WebDriverManager webDriverThread : webDriverThreadPool) {
                        webDriverThread.quitDriver();
            }
        }
}
