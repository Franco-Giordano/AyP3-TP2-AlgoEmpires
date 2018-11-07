package cosasVarias;

public class Monedero {
	
	private int dinero;
	
	public Monedero() {
		this.dinero=0;
	}
	
	public void sumarDinero(int dineroASumar) {
		this.dinero += dineroASumar;
	}

	public void restarDinero(int dineroARestar) {
		if(!quedaDineroNegativo(dineroARestar)) {
			dinero -= dineroARestar;
		}
	}
	
	public boolean quedaDineroNegativo(int dineroARestar) {
		return dinero-dineroARestar<0;
	}
}
