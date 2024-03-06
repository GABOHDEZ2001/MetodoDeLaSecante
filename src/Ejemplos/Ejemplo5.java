package Ejemplos;

import java.util.function.Function;

public class Ejemplo5 {

    public static void main(String[] args) {
        // Definir la función f(x) = x^2 + 3x^3 + 2
        Function<Double, Double> funcion = x -> Math.pow(x, 2) + 3 * Math.pow(x, 3) + 2;

        // Llamar al método de la secante
        double resultado = secante(funcion, -2.0, -1.0, 0.0001, 100);

        // Imprimir el resultado
        System.out.println("La raíz aproximada es: " + resultado);
    }

    public static double secante(Function<Double, Double> funcion, double x0, double x1, double tolerancia, int maxIteraciones) {
        double resultado = 0;

        for (int i = 0; i < maxIteraciones; i++) {
            // Calcular el siguiente punto de la secante
            double x2 = x1 - funcion.apply(x1) * (x1 - x0) / (funcion.apply(x1) - funcion.apply(x0));

            // Verificar la tolerancia
            if (Math.abs(x2 - x1) < tolerancia) {
                resultado = x2;
                break;
            }

            // Actualizar los puntos para la siguiente iteración
            x0 = x1;
            x1 = x2;
        }

        return resultado;
    }
}
