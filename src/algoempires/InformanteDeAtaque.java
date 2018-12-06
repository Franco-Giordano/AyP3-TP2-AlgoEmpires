package algoempires;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.PlazaCentral;
import interfaz.controller.VistaPartidaController;
import interfaz.view.CasilleroView;

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

