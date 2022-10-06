package empresa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import empresa.base.TestBase;

import java.time.Duration;

public class ExplicitWait {
    private static final int LONG_WAIT = 25;

    public static void esperaPaginaCarregarCompletamente() {
        final WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(LONG_WAIT));

        wait.until(ExpectedConditionsPersonalizada.waitForPageToFinishLoad());
    }

    public static WebElement elementoInteragivelEClicavel(By localizador) {
        final WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(LONG_WAIT));

        return wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(localizador)));
    }
}