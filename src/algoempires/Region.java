package algoempires;

import algoempires.entidad.edificio.Edificio;

import java.util.ArrayList;
import java.util.List;

public class Region {

    private Casillero infIzquierdo;
    private Casillero supDerecho;
    private int tamanioHorizontal;
    private int tamanioVertical;

    public Region(Casillero infIzquierdo, int tamanioHorizontal, int tamanioVertical){

        this.infIzquierdo = infIzquierdo;
        this.supDerecho = this.calcularExtremo(tamanioHorizontal,tamanioVertical);
        this.tamanioVertical = tamanioVertical;
        this.tamanioHorizontal = tamanioHorizontal;

    }

    private Casillero calcularExtremo(int tamanioHorizontal, int tamanioVertical){

        Casillero extremo = new Casillero(this.infIzquierdo.getHorizontal() + tamanioHorizontal - 1,
                                            this.infIzquierdo.getVertical()+ tamanioVertical- 1);

        return extremo;
    }

    public void ocupar(Edificio edificio){


    }

    public ArrayList<Casillero> generarCasillerosContenidos(){

        ArrayList<Casillero> casillerosContenidos = new ArrayList<Casillero>();

        for (int i = 0; i < tamanioHorizontal; i++){
            for (int j = 0; j < tamanioVertical; j++){
                Casillero casilleroContenido = new Casillero(i + infIzquierdo.getHorizontal(),
                                                            j + infIzquierdo.getVertical());
                casillerosContenidos.add(casilleroContenido);
            }
        }

        return casillerosContenidos;
    }

}
