package conversorDeMonedas;


public  class Calculadora {
	
	private Moneda monedaInicial;
	private Moneda monedaFinal;
	
	public Moneda getMonedaInicial() {
		return monedaInicial;
	}
	public Moneda getMonedaFinal() {
		return monedaFinal;
	}
	public void setMonedaInicial(String monedaInicial) {
		Moneda moneda = Conversor.obtenerMonedaPorNombre(monedaInicial);
		this.monedaInicial = moneda;
	}
	public void setMonedaFinal(String monedaFinal) {
		Moneda moneda = Conversor.obtenerMonedaPorNombre(monedaFinal);
		this.monedaFinal = moneda;
	}
	
	
	public double convertir(double cantidad) {
		return cantidad * this.monedaInicial.getValor()/ this.monedaFinal.getValor();
	}

	

	
	
	
}
