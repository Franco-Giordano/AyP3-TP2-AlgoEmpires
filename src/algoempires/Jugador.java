package algoempires;

import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;

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

    //----------------------------------------------------------------------------------------------------------------//
    //######################################### METODOS DE TESTEO ####################################################//
    //----------------------------------------------------------------------------------------------------------------//

    public ArrayList<Unidad> getUnidades() {
        return this.unidades;
    }

}
