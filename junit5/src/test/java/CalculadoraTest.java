import org.example.Calculadora;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraTest {

    Calculadora calculadora = new Calculadora();

    @BeforeEach
    public void setup() {
        System.out.println("^^^^^^");
    }

    @AfterEach
    public void teardown() {
        System.out.println("vvvvvv");
    }

    @BeforeAll
    public static void setupApp() {
        System.out.println("------ Before All ------");

    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all");
    }

    @Test
    public void testSomar() {
        //O assertions testa se um resultado é igual ao valor esperado;
        Assertions.assertTrue(calculadora.soma(1, 2) == 3); //Ele espera que o retorno seja true;
        Assertions.assertEquals(3, calculadora.soma(1, 2)); //é pra verificar se é igual o esperado do resultado da função
    }

    @Test
    public void assertivas() {
        Assertions.assertEquals("Casa", "Casa" );
        Assertions.assertNotEquals("Casa", "casa");
        Assertions.assertTrue("casa".endsWith("sa"));

        List<String> lista01 = new ArrayList<>();
        List<String> lista02 = new ArrayList<>();
        List<String> lista03 = null;

        Assertions.assertEquals(lista01, lista02);
    }

    @Test
    public void deveRetornarInteiroNaDivisao() {
        float valorCalculado = calculadora.dividir(6, 2);

        Assertions.assertEquals(3, valorCalculado);
    }

    @Test
    public void deveRetornarNumeroNegativo() {
        float valorCalculado = calculadora.dividir(6, -2);
        Assertions.assertEquals(-3, valorCalculado);
    }

    @Test
    public void deveRetornarNumeroComVirgula() {
        float valor = calculadora.dividir(10, 3);
        Assertions.assertEquals(3.33, valor, 0.01);
    }

    @Test
    public void deveGerarExcecaoDividisoZero_Junit4() {
        try {
            float valor = 10/0;
            Assertions.fail("Deveria ter sido lançado exceção");
        } catch (ArithmeticException e) {
            //Com esse erro ele passa porque dá a entender que já era esperado.
            Assertions.assertEquals("/ by zero", e.getMessage()); //As vezes preciso validar se a mensagem é a mesma, quando tem mts erros da mesma classe;
        }

    }

    @Test
    public void deveGerarExcecaoDividisoZero_Junit5() {
        ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            float valor = 10/0;
        });
        Assertions.assertEquals("/ by zero", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Teste 1", "Teste 2"}) //Consigo passar todas as situações em que desejo realizar o teste;
    public void testStrings(String params) {
        System.out.println(params);
        Assertions.assertNotNull(params);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "6, 2, 3", //ele ta passando como csv, em que cada valor tá sendo incluido para a variavel;
            "6, -2, -3",
            "10, 5, 2"
    })
    public void testeDivisao(int num, int den, int res) {
        float resultado = calculadora.dividir(num, den);
        Assertions.assertEquals(res, resultado);

    }

}
