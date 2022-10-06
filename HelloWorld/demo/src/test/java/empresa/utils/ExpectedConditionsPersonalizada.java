package empresa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.JavascriptExecutor;

public class ExpectedConditionsPersonalizada {

    public static ExpectedCondition<Boolean> waitForPageToFinishLoad() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }

            public String toString() {
                return String.format("Espera a pagina carregar");
            }
        };
    }
}