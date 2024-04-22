package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass() {
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("Sumar dos números")
    void testSumar() {
        assertEquals(5, miCalculadora.suma(2, 3));
        assertEquals(1, miCalculadora.suma(-2, 3));
        assertEquals(0, miCalculadora.suma(0, 0));
        assertEquals(-2.7, miCalculadora.suma(2.6, -5.3), 0.000001);
    }

    @Test
    @DisplayName("Restar dos números")
    void testRestar() {
        assertEquals(2, miCalculadora.resta(5, 3));
        assertEquals(-3, miCalculadora.resta(2, 5));
        assertEquals(0, miCalculadora.resta(0, 0));
        assertEquals(5, miCalculadora.resta(2.5, -2.5));
    }

    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2, 3));
        assertEquals(-6, miCalculadora.multiplica(-2, 3));
        assertEquals(0, miCalculadora.multiplica(5, 0));
        assertEquals(-6.25, miCalculadora.multiplica(-2.5, 2.5));
    }

    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() throws Exception {
        assertEquals(2, miCalculadora.divide(6, 3));
        assertEquals(-2, miCalculadora.divide(-6, 3));
        assertEquals(0, miCalculadora.divide(0, 5));
        assertEquals(1.25, miCalculadora.divide(2.5, 2));
    }

    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() throws Exception {
        assertTrue(miCalculadora.divide(4, 2) > 0);
        assertTrue(miCalculadora.divide(4, -2) < 0);
        assertTrue(miCalculadora.divide(-4, 2) < 0);
        assertTrue(miCalculadora.divide(-4, -2) > 0);
    }

    @Test
    @DisplayName("Potencias")
    void testPotencias() {
        assertEquals(8, miCalculadora.potencia(2, 3));
        assertEquals(9, miCalculadora.potencia(3, 2));
        assertEquals(0, miCalculadora.potencia(0, 5));
        assertEquals(4, miCalculadora.potencia(-2, 2));
    }

    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.divide(7, 0);
        });
        assertEquals("El divisor es 0", thrown.getMessage());
    }

    @Test
    public void testRadicandoUno() throws OperacionInvalidaException {
        assertEquals(1.0, miCalculadora.raizCuadrada(1.0));
    }

    @Test
    public void testRadicandoCero() throws OperacionInvalidaException {
        assertEquals(0.0, miCalculadora.raizCuadrada(0.0));
    }

    @Test
    public void testRadicandoCuatro() throws OperacionInvalidaException {
        assertEquals(2.0, miCalculadora.raizCuadrada(4.0));
    }

    @Test
    public void testRadicandoNegativo() {
        OperacionInvalidaException thrown = assertThrows(OperacionInvalidaException.class, () -> {
            miCalculadora.raizCuadrada(-4.0);
        });
        assertEquals("El radicando no puede ser negativo", thrown.getMessage());
    }
}