package algoempires;

public class Monedero {
	
	private int dinero;
	
	public Monedero() {
		this.dinero=0;
	}
	
	public void sumarDinero(int dineroASumar) {
		this.dinero += dineroASumar;
	}
	
	public void restarDinero(int dineroARestar) {
		if(puedoDebitarElValor(dineroARestar)) {
			dinero -= dineroARestar;
		}
	}
	
	public boolean puedoDebitarElValor(int dineroARestar) {
		return dinero-dineroARestar>=0;
	}
}
