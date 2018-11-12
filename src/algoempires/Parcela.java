package algoempires;

import algoempires.entidad.Entidad;

public class Parcela {

    private Entidad entidadOcupante;

    public Parcela() {
        entidadOcupante = null;
    }

    public boolean estaOcupada() {
        return (entidadOcupante != null);
    }

    public void ocupar(Entidad entidadOcupanteRecibida) {
        this.entidadOcupante = entidadOcupanteRecibida;
    }

}
