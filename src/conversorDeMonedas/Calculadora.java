package conversorDeMonedas;


public class Calculadora {
	
	private Moneda monedaInicial;
	private Moneda monedaFinal;

	
	public Moneda getMonedaInicial() {
		return monedaInicial;
	}
	public Moneda getMonedaFinal() {
		return monedaFinal;
	}
	public void setMonedaInicial(Moneda monedaInicial) {
		this.monedaInicial = monedaInicial;
	}
	public void setMonedaFinal(Moneda monedaFinal) {
		this.monedaFinal = monedaFinal;
	}
	
	
	public double convertir(double cantidad) {
		return cantidad * this.monedaInicial.getValor()/ this.monedaFinal.getValor();
	}

	

	
	
	
}
