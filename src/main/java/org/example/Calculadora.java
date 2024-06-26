package org.example;

public class Calculadora {

    double suma(double a, double b) {
        return a + b;
    }

    double resta(double minuendo, double sustraendo) {
        return minuendo - sustraendo;
    }

    double multiplica(double a, double b) {
        return a * b;
    }

    double divide(double dividendo, double divisor) throws Exception {
        if (divisor == 0) {
            throw new Exception("El divisor es 0");
        }
        return dividendo / divisor;
    }

    double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    public double raizCuadrada(double radicando) throws OperacionInvalidaException {
        if (radicando < 0) {
            throw new OperacionInvalidaException("El radicando no puede ser negativo");
        }
        return Math.sqrt(radicando);
    }

}

class OperacionInvalidaException extends Exception {
    public OperacionInvalidaException(String msg) {
        super(msg);
    }
}