package algoempires.jugador;

import algoempires.entidad.unidad.Unidad;

import java.util.ArrayList;

public class Poblacion {

    private ArrayList<Unidad> unidades;
    private final int MAXIMO_POBLACION=50;

    public Poblacion(){

        unidades= new ArrayList<>();
    }


    public void agregar(Unidad unidadAAgregar){
        unidades.add(unidadAAgregar) ;
    }

    public boolean seLlegoAlMaximo(){
        return unidades.size()==50;
    }
}
