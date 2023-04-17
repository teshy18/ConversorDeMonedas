package conversorDeMonedas;

import java.util.ArrayList;


//- Convertir de la moneda de tu país a Dólar
//- Convertir de la moneda de tu país  a Euros
//- Convertir de la moneda de tu país  a Libras Esterlinas
//- Convertir de la moneda de tu país  a Yen Japonés
//- Convertir de la moneda de tu país  a Won sul-coreano


public class Conversor {
	
	public static ArrayList<Moneda> monedas = new ArrayList<Moneda>();

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculadora calculadora = new Calculadora();
		
		IGU pantalla = new IGU();
		pantalla.setVisible(true);
		
		Moneda pesoArgentino = new Moneda("Peso Argentino", "ARS", 0.0048);
		Moneda dolar = new Moneda("Dólar", "USD" , 1);
		Moneda libra = new Moneda("Libra Esterlina", "GBP" , 1.24);
		Moneda euro = new Moneda("Euros", "EUR" , 1.10);
		Moneda yen = new Moneda("Yen Japonés", "JPY" , 0.0075);
		Moneda won = new Moneda("Won Surcoreano", "KRW" , 0.00076);
		
		
		monedas.add(pesoArgentino);
		monedas.add(yen);
		monedas.add(dolar);
		monedas.add(euro);
		monedas.add(libra);
		monedas.add(won);
		
		
		
		
	}

}
