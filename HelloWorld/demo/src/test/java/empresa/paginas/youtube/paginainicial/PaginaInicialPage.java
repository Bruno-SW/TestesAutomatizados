package empresa.paginas.youtube.paginainicial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import empresa.base.PageBase;

public class PaginaInicialPage extends PageBase<PaginaInicialPage> {
        private final String url = "";

        private final By botaoHome = By.id("logo");

        public PaginaInicialPage visitar() {
            navegarPara(url);
            return this;
        }

        public PaginaInicialPage clickBotaoHome() {
            WebElement botaoHome = findElement(this.botaoHome);
            botaoHome.click();

            return this;
        }

}
