package conceitos.waits.customexpectedconditions;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ExpectedConditionsPersonalizada {

    public static ExpectedCondition<WebElement> elementoComTextoEEhClicavel(final By localizador, String texto) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                List<WebElement> elementos = driver.findElements(localizador);

                List<WebElement> elementosComTexto = elementos.stream()
                                            .filter(elemento -> elemento.getText().contains(texto))
                                            .collect(Collectors.toList());
                
                return !elementosComTexto.isEmpty() && elementosComTexto.get(0).isEnabled() ? elementosComTexto.get(0) : null ;

            }

            public String toString() {
                return String.format("Elemento com texto localizado por %s, com texto %s", localizador, texto);
            }
        };
    }
}