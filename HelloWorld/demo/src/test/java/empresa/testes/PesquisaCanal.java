package empresa.testes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import empresa.base.TestBase;
import empresa.paginas.youtube.paginainicial.PaginaInicialPage;
import empresa.utils.ExplicitWait;

public class PesquisaCanal extends TestBase {
    PaginaInicialPage paginaInicialPage;

    @BeforeMethod
    @Override
    public void antesDeCadaTeste() {
        paginaInicialPage = new PaginaInicialPage();
    }

    @Test
    public void googleExemploQueijo() {
        paginaInicialPage
                .visitar()
                .setCampoPesquisa("Cortes do Casimito")
                .clickPesquisa();
        ExplicitWait.esperaPaginaCarregarCompletamente();

        List<String> canaisEncontrados = paginaInicialPage.getCanaisDoResultadoDePesquisa();
        
        Assert.assertFalse(canaisEncontrados.stream().filter(nomeCanal -> nomeCanal.contains("Cortes do Casimito")).collect(Collectors.toList()).isEmpty());
    }

}