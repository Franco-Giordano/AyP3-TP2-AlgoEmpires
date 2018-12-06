package algoempires;

import interfaz.controller.VistaPartidaController;

public class InformanteDeExcepciones {

    private VistaPartidaController vistaPartidaController;

    public void setVistaPartidaController(VistaPartidaController vista) {
        this.vistaPartidaController = vista;
    }

    public void informar(RuntimeException e) {
        if (vistaPartidaController != null) {
            vistaPartidaController.mostrarMensaje(e.getMessage());
        }
    }
}
