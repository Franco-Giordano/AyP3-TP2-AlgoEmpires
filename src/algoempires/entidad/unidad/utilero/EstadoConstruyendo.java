package algoempires.entidad.unidad.utilero;

import algoempires.entidad.edificio.Edificio;

public class EstadoConstruyendo extends EstadoAldeano {

    private Edificio edificioSiendoConstruido;

    public EstadoConstruyendo(Aldeano aldeano, Edificio edificioSiendoConstruido) {
        super(aldeano);
        this.edificioSiendoConstruido = edificioSiendoConstruido;
    }

    @Override
    protected EstadoAldeano actualizarEntreTurnos() {

        this.edificioSiendoConstruido.continuarConstruccion();

        if (!this.edificioSiendoConstruido.tieneVidaLlena()) {
            return this;
        } else {
            return new EstadoRecolectandoOro(aldeano);
        }
    }
}
