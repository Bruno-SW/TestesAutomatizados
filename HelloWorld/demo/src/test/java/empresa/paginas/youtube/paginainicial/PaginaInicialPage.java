package empresa.paginas.youtube.paginainicial;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import empresa.base.PageBase;
import empresa.utils.ExplicitWait;

public class PaginaInicialPage extends PageBase<PaginaInicialPage> {
        private final String url = "";

        private final By botaoHome = By.id("logo");
        private final By campoPesquisa = By.xpath("//input[@id='search']");
        private final By botaoPesquisa = By.id("search-icon-legacy");
        private final By secaoDeCanais = By.tagName("ytd-channel-renderer");
        private final By canaisNaSecaoDeCanais = By.tagName("ytd-channel-name");
        private final By nomeDoCanalNaSecaoDeCanais = By.tagName("yt-formatted-string");

        public PaginaInicialPage visitar() {
            navegarPara(url);
            return this;
        }

        public PaginaInicialPage clickBotaoHome() {
            WebElement botaoHome = ExplicitWait.elementoInteragivelEClicavel(this.botaoHome);
            botaoHome.click();

            return this;
        }

        public PaginaInicialPage setCampoPesquisa(String pesquisa) {
            WebElement campoPesquisa = ExplicitWait.elementoInteragivelEClicavel(this.campoPesquisa);
            campoPesquisa.sendKeys(pesquisa);

            return this;
        }

        public PaginaInicialPage clickPesquisa() {
            WebElement botaoPesquisa = ExplicitWait.elementoInteragivelEClicavel(this.botaoPesquisa);
            botaoPesquisa.click();

            return this;
        }

        public List<String> getCanaisDoResultadoDePesquisa() {
            return ExplicitWait.elementoInteragivelEClicavel(this.secaoDeCanais).findElements(this.canaisNaSecaoDeCanais).stream().map(canal -> canal.findElement(this.nomeDoCanalNaSecaoDeCanais).getText()).collect(Collectors.toList());
        }

}
