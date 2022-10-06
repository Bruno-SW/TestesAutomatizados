package conceitos.testes;

import static org.junit.Assert.*;

import java.util.Arrays;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.edge.EdgeDriver;
import java.util.List;

import org.hamcrest.Matchers;
import org.hamcrest.MatcherAssert;

public class asserters {

    public static void wait(int millisegundos) {
        try {
            Thread.sleep(millisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Iniciando Validação");
        // Valida que uma expressão é verdadeira
        assertTrue("um" == "um");

        // Valida que uma expressão é falsa
        assertFalse("um" == "dois");

        // Valida que um objeto não é null
        assertNotNull("existo");

        // Valida que um objeto é null
        List<String> listaNull = null;
        assertNull(listaNull);

        // Valida que dois objetos são iguais
        assertEquals(1, 1);
        assertEquals("um", "um");
        List<String> umACinco = Arrays.asList("um", "dois", "tres", "quatro", "cinco");
        List<String> cincoAUm = Arrays.asList("cinco", "quatro", "tres", "dois", "um");
        assertEquals(umACinco, umACinco);
        
        // Valida que dois objetos não são iguais
        assertNotEquals(1, 2);
        assertNotEquals("um", "dois");
        assertNotEquals(cincoAUm, umACinco);

        // Valida que dois arrays/list/set... Collection, são iguais independente da ordem        
        assertTrue(umACinco.size() == cincoAUm.size() && umACinco.containsAll(cincoAUm) && cincoAUm.containsAll(umACinco));
        // Outra forma, utilizando hemcrest
        MatcherAssert.assertThat(umACinco, Matchers.containsInAnyOrder(cincoAUm.toArray()));


        // Valida que dois objetos são o mesmo (Apontam pro mesmo endereço de memória)
        List<String> outroUmACincoMasNaVerdadeEhOMesmo = umACinco;
        assertSame(umACinco, outroUmACincoMasNaVerdadeEhOMesmo);


        System.out.println("Se você esta me lendo todos os testes passaram");

        
        // Falha um teste propositalmente
        fail();
    }

}