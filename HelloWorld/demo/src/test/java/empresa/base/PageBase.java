package empresa.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import empresa.utils.ExplicitWait;

public abstract class PageBase<PageBaseChild extends PageBase> {

    public static final String urlBase = "https://www.youtube.com/";
          
    protected PageBaseChild navegarPara(String url) {
        TestBase.getDriver().get(urlBase + url);
        ExplicitWait.esperaPaginaCarregarCompletamente();

        return (PageBaseChild) this;
    }

    public WebElement findElement(By localizador) {
        return TestBase.getDriver().findElement(localizador);
    }

    public List<WebElement> findElements(By localizador) {
        return TestBase.getDriver().findElements(localizador);
    }
}