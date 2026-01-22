package entornoDeDesarollo;

import java.util.ArrayList;


/**
 * Código inicial para la práctica de refactorización.
 * Criterios: Nombres genéricos, números mágicos y métodos con demasiadas responsabilidades.
 */
public class ProcesadorPedidos {
 
 
    public double procesar(ArrayList<String> listaNombres, ArrayList<Double> precios) {
        double totalSinImpuestos = 0;
        
        // Sumar precios de la lista
        for (int i = 0; i < precios.size(); i++) {
            System.out.println("Añadiendo producto: " + listaNombres.get(i));
            totalSinImpuestos = totalSinImpuestos + precios.get(i);
        }
        
        // Lógica de descuento (Magic Number 100 y 0.10)
        if (totalSinImpuestos > 100) {
            System.out.println("Descuento aplicado.");
            totalSinImpuestos = totalSinImpuestos - (totalSinImpuestos * 0.10); 
        }
        
        // Cálculo de impuestos (Magic Number 0.21)
        double res = totalSinImpuestos + (totalSinImpuestos * 0.21);
        
        // Gastos de envío (Magic Number 500 y 15.95)
        if (res < 500) {
            res = res + 15.95;
        }
        
        return res;
    }
}
