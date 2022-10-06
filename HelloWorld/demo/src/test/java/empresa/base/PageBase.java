package empresa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import empresa.utils.ExplicityWait;

public abstract class PageBase<PageBaseChild extends PageBase> {

    public static final String urlBase = "https://www.youtube.com/";
          
    protected PageBaseChild navegarPara(String url) {
        TestBase.getDriver().get(urlBase + url);
        ExplicityWait.esperaPaginaCarregarCompletamente();

        return (PageBaseChild) this;
    }

    public WebElement findElement(By localizador) {
        return TestBase.getDriver().findElement(localizador);
    }
}