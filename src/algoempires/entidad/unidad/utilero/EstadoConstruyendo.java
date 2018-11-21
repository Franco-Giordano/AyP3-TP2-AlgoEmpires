package algoempires.entidad.unidad.utilero;

import algoempires.entidad.edificio.Edificio;

public class EstadoConstruyendo extends Estado {

    private Edificio edificioSiendoConstruido;

   public EstadoConstruyendo(Aldeano aldeano, Edificio edificioSiendoConstruido){
       super(aldeano);
       this.edificioSiendoConstruido = edificioSiendoConstruido;
    }

    @Override
    protected Estado actualizarEntreTurnos(){

        this.edificioSiendoConstruido.continuarConstruccion();

        if (!this.edificioSiendoConstruido.tieneVidaLlena()) {
            return this;
        }
        else {
            return new EstadoRecolectandoOro(aldeano);
        }
    }
}
