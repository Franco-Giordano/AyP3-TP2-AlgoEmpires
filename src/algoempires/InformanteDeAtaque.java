package algoempires;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.PlazaCentral;
import interfaz.CasilleroView;
import interfaz.VistaPartidaController;

public class InformanteDeAtaque {

    private VistaPartidaController vistaPartidaController;

    public void setVistaPartidaController(VistaPartidaController vista) {
        this.vistaPartidaController = vista;
    }

    public void seAtaco(Entidad entidad) {
        if (entidad != null) {
            CasilleroView casilleroView = vistaPartidaController.getCasilleroViewDeEntidad(entidad);
            if (casilleroView.getCasillero().estaOcupada()) {
                if (entidad.getClass() == PlazaCentral.class || entidad.getClass() == Cuartel.class) {
                    casilleroView.reproducirAnimacion("animacionDanioEdificio");
                } else {
                    casilleroView.reproducirAnimacion("animacionDanioUnidad");
                }
            }
        }
    }
}

