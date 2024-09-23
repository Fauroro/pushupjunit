package com.junitpushup;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.util.Arrays;
import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExampleTest {
    private Example example;

    @BeforeEach
    public void init() {
        this.example = new Example();
    }

    @Test
    public void testSumar() {
        // Given - elementos que se tienen para realizar la prueba
        int numberA = 5;
        int numberB = 10;
        // When : Cuando
        int result = example.sumar(numberA, numberB);
        // Then - Entonces
        assertNotNull(result);
        assertEquals(15, result);
        assertInstanceOf(Integer.class, result);
    }

    // 2. Método que lanza una excepción si el argumento es negativo
    @Test
    public void testNumeroNegativo() {
        int number = 10;
        boolean result = example.checkPositivo(number);
        // Validar si es positivo
        assertEquals(true, result);
    }

    @Test
    public void testException() {
        int number = -10;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> example.checkPositivo(number));
        String actual = exception.getMessage();
        String esperado = "El número no puede ser negativo";

        // Validar exception
        assertEquals(esperado, actual);
    }

    // 3. Método para contar el número de letras 'a' en una cadena
    @Test
    public void testContarLetra() {
        assertAll(
                () -> assertEquals(0, example.contarLetrasA("Pedro")),
                () -> assertEquals(6, example.contarLetrasA("anita lava la tina")));

    }

    // 4. Método que retorna un valor booleano si la lista contiene el elemento
    @Test
    public void testContieneElemento() {
        List<String> lista = Arrays.asList("Maritza", "Duvan", "Fabian", "Sebastian", "Juan");
        assertAll(
                () -> assertEquals(true, example.contieneElemento(lista, "Sebastian")),
                () -> assertEquals(false, example.contieneElemento(lista, "Fauroro")));
    }

    // 5. Método para revertir una cadena
    @Test
    public void testRevertirCadena() {
        assertAll(
                () -> assertEquals("ororuaF", example.revertirCadena("Fauroro")));
    }

    // 6. Método que calcula el factorial de un número
    @Test
    public void testFactorial() {
        assertAll(
                () -> assertEquals(120, example.factorial(5)),
                () -> assertEquals(6, example.factorial(3)));
    }

    @Test
    public void testFactorialException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> example.factorial(-1));
        String actual = exception.getMessage();
        String esperado = "Factorial no definido para números negativos";
        assertEquals(esperado, actual);
    }

    // 7. Método para verificar si un número es primo
    @Test
    public void testNumeroPrimo() {
        assertAll(
                () -> assertEquals(true, example.esPrimo(7)),
                () -> assertEquals(false, example.esPrimo(8)),
                () -> assertEquals(false, example.esPrimo(1)));
    }

    // 8. Método que simula un retraso y retorna un mensaje
    @Test
    public void testMensajeRetrasado() throws InterruptedException {
        assertAll(
                () -> assertTimeout(Duration.ofMillis(5050), () -> example.mensajeConRetraso()),
                () -> assertEquals("Listo después de retraso", example.mensajeConRetraso()));
    }

    // 9. Método para convertir una lista de enteros a lista de strings
    @Test
    public void testConvertirEnString() {
        List<Integer> enteros = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> string = Arrays.asList("1", "2", "3", "4", "5", "6");
        assertArrayEquals(string.toArray(new String[string.size()]),
                example.convertirAString(enteros).toArray(new String[enteros.size()]));
    }

    // 10. Método que calcula la media de una lista de enteros
    @Test
    public void testCalcularMedia() {
        List<Integer> enteros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(5.5, example.calcularMedia(enteros));
    }

    // 11. Método para convertir una lista de enteros a lista de strings ***********
    // el enunciado esta mal
    @Test
    public void testConvertirListaAString(){
        List<String> string = Arrays.asList("1","2","3","4","5");
        assertEquals("1,2,3,4,5", example.convertirListaAString(string));
    }
}
