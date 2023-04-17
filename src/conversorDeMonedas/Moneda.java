package conversorDeMonedas;

public class Moneda {

	private String nombre;
	private String sigla;
	
	//valor de la moneda en relacion al dolar
	private double valor;
	
	//getters
	public String getNombre() {
		return nombre;
	}
	public String getSigla() {
		return sigla;
	}
	public double getValor() {
		return valor;
	}
	
	//setters 
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	public Moneda(String nombre, String sigla, double valor) {
		super();
		this.nombre = nombre;
		this.sigla = sigla;
		this.valor = valor;
	}	
	
	
}
	