package model;

import java.util.function.Function;

public class Quadratura {

    public static double quadraturaGaussiana(double a, double b, int n, Function<Double, Double> f) {

        double[] abscissas = new double[n];
        double[] pesos = new double[n];
        
        switch (n) {
            case 2:
                abscissas = new double[] { -0.5773502692, 0.5773502692 };
                pesos = new double[] { 1.0000000000, 1.0000000000 };
                break;
            case 3:
                abscissas = new double[] { -0.7745966692, 0.0000000000, 0.7745966692 };
                pesos = new double[] { 0.5555555556, 0.8888888889, 0.5555555556 };
                break;
            case 4:
                abscissas = new double[] { -0.8611363116, -0.3399810436, 0.3399810436, 0.8611363116 };
                pesos = new double[] { 0.3478548451, 0.6521451549, 0.6521451549, 0.3478548451 };
                break;
            case 5:
                abscissas = new double[] { -0.9061798459, -0.5384693101, 0.0000000000, 0.5384693101, 0.9061798459 };
                pesos = new double[] { 0.2369268851, 0.4786286705, 0.5688888889, 0.4786286705, 0.2369268851 };
                break;
            default:
                throw new IllegalArgumentException("Número de pontos não suportado");

        }

        double integral = 0.0;
        for (int i = 0; i < n; i++) {
            double x = (b + a) / 2 + (b - a) / 2 * abscissas[i];
            double w = (b - a) / 2 * pesos[i];
            integral += w * f.apply(x);
        }

        return integral;

    }

}
