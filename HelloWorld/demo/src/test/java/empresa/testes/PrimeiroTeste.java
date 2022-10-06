package empresa.testes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import empresa.base.TestBase;
import empresa.paginas.youtube.paginainicial.PaginaInicialPage;

public class PrimeiroTeste extends TestBase {

    @BeforeMethod
    @Override
    public void antesDeCadaTeste() {
    }

    private void exemploGoogleQuePesquisaPor(final String stringPesquisa) {
        
        PaginaInicialPage paginaInicialPage = new PaginaInicialPage();
        paginaInicialPage.visitar();
        WebDriver driver = TestBase.getDriver();

        driver.get("http://www.google.com");

        WebElement campoPesquisado = driver.findElement(By.name("q"));

        campoPesquisado.clear();
        campoPesquisado.sendKeys(stringPesquisa);

        System.out.println("O título da página é: " + driver.getTitle());

        campoPesquisado.submit();

        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver objDriver) {
                                return objDriver.getTitle().toLowerCase().startsWith(stringPesquisa.toLowerCase());
                    }
        });
        System.out.println("O título da página é: " + driver.getTitle());
    }

    @Test
    public void googleExemploQueijo() {
        exemploGoogleQuePesquisaPor("Queijo!");
    }

    @Test
    public void googleExemploLeite() {
        exemploGoogleQuePesquisaPor("Leite!");
    }

}