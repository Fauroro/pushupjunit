package com.junitpushup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    private Main main;
    @BeforeEach
    public void init() {
        this.main = new Main();
    }
    @Test
    public void testMain(){
        // Configurar la captura de la salida de System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutar el método main
        Main.main(new String[]{});

        // Verificar que la salida es la esperada
        assertEquals("Campus", outContent.toString());
    }
}
