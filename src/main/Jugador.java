package main;

import java.util.ArrayList;

public class Jugador {

	private ArrayList<Unidad> unidades;
	private ArrayList<Edificio> edificios;

	public Jugador() {
		this.unidades = new ArrayList<Unidad>();
		this.edificios = new ArrayList<Edificio>();
	}

	public void agregarEdificio(Edificio edificioAAgregar) {
		edificios.add(edificioAAgregar);
	}

	public void agregarUnidad(Unidad unidadAAgregar) {
		unidades.add(unidadAAgregar);
	}

}
