package main;

public class Monedero {
	
	private int dinero;
	
	public Monedero() {
		this.dinero=0;
	}
	
	public void sumarDinero(int dineroASumar) {
		this.dinero += dineroASumar;
	}

	public void restarDinero(int dineroARestar) {
		if(quedaDinero(dineroARestar)) {
			dinero -= dineroARestar;
		}
	}
	
	public boolean quedaDinero(int dineroARestar) {
		return dinero-dineroARestar>=0;
	}
}
