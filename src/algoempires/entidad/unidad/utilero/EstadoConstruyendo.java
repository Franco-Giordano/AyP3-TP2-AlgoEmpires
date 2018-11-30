package algoempires.entidad.unidad.utilero;

import algoempires.entidad.edificio.Edificio;
import algoempires.excepciones.AldeanoOcupadoException;

public class EstadoConstruyendo extends EstadoAldeano {

    private Edificio edificioSiendoConstruido;

    public EstadoConstruyendo(Aldeano aldeano, Edificio edificioSiendoConstruido) {
        super(aldeano);
        this.edificioSiendoConstruido = edificioSiendoConstruido;
    }

    @Override
    protected EstadoAldeano actualizarEntreTurnos() {

        this.edificioSiendoConstruido.continuarConstruccion();

        if (this.edificioSiendoConstruido.terminoConstruccion()) {
            return new EstadoRecolectandoOro(aldeano);
        }

        return this;
    }

    @Override
    public boolean sePuedeMover() {
        return false;
    }

    @Override
    public void chequearQueAldeanoEsteDisponible(){
        throw new AldeanoOcupadoException("El aldeano se encuentra construyendo o reparando un edificio.");
    }
}
