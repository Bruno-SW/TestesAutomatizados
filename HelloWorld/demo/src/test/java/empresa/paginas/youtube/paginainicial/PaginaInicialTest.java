package empresa.paginas.youtube.paginainicial;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import empresa.base.PageBase;
import empresa.base.TestBase;
import empresa.utils.ExplicityWait;

public class PaginaInicialTest extends TestBase {
        private PaginaInicialPage paginaInicialPage;

        @BeforeMethod
        @Override
        public void antesDeCadaTeste() {
            paginaInicialPage = new PaginaInicialPage();
        }

        // @AfterMethod
        // public void depoisDeCadaTeste(){
        //     System.out.println("Estou finalizando um teste");
        // }

        // @BeforeClass
        // public void antesDeTodosOsTestesAoInstanciarAClasse(){
        // }

        // @AfterClass
        // public void depoisDeTodosOsTestesDestruirAClasse(){
            
        // }

        @Test
        public void aoClicarNoLogoDeveRedirecionarParaAPaginaInicial(){
            paginaInicialPage.visitar().clickBotaoHome();
            
            ExplicityWait.esperaPaginaCarregarCompletamente();

            String urlNavegada = getDriver().getCurrentUrl();

            Assert.assertEquals(urlNavegada, PageBase.urlBase);

            wait(3000);
        }


}
