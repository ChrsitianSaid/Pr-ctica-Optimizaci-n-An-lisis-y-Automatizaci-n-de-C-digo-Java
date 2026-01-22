package entornoDeDesarollo;

import java.util.ArrayList;


/**
 * Código inicial para la práctica de refactorización.
 * Criterios: Nombres genéricos, números mágicos y métodos con demasiadas responsabilidades.
 */
public class ProcesadorPedidos {
 
 
    private static final double comision = 0.10;
	private static final double iva = 0.21;
	private static final int umbralDescuento = 100;
	private static final double tarifa_fija = 15.95;

	public double procesar(ArrayList<String> listaNombres, ArrayList<Double> precios) {
        double totalSinImpuestos = 0;
        
        // Sumar precios de la lista
        for (int i = 0; i < precios.size(); i++) {
            System.out.println("Añadiendo producto: " + listaNombres.get(i));
            totalSinImpuestos = totalSinImpuestos + precios.get(i);
        }
        
        // Lógica de descuento (Magic Number 100 y 0.10)
        if (totalSinImpuestos > umbralDescuento) {
            System.out.println("Descuento aplicado.");
            totalSinImpuestos = totalSinImpuestos - (totalSinImpuestos * comision); 
        }
        
        double IVA = metodoIVA(totalSinImpuestos);
        
        IVA = gastoEnvio(IVA);
        
        return IVA;
    }

	private double gastoEnvio(double res) {
		// Gastos de envío (Magic Number 500 y 15.95)
        if (res < 500) {
            res = res + tarifa_fija;
        }
		return res;
	}

	private double metodoIVA(double totalSinImpuestos) {
		
		// Cálculo de impuestos (Magic Number 0.21)
        double IVA = totalSinImpuestos + (totalSinImpuestos * iva);
		return IVA;
	}
}
