package interfaz.controller.handlers;

import algoempires.entidad.Entidad;
import algoempires.entidad.unidad.guerrero.armadeasedio.ArmaDeAsedio;
import interfaz.controller.VistaPartidaController;
import interfaz.controller.botoneras.BotoneraController;
import interfaz.view.CasilleroView;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;

import java.io.IOException;

public class EstadoDefaultHandler implements EventHandler<MouseEvent> {

    private final Pane layoutBotones;
    private final CasilleroView casilleroAsignado;
    private final VistaPartidaController vistaPartidaController;

    public EstadoDefaultHandler(Pane layoutBotones, CasilleroView casilleroAsignado, VistaPartidaController vistaPartidaController) {
        this.layoutBotones = layoutBotones;
        this.casilleroAsignado = casilleroAsignado;
        this.vistaPartidaController = vistaPartidaController;
    }

    @Override
    public void handle(MouseEvent event) {

        vistaPartidaController.eliminarEfectosCasilleros();

        casilleroAsignado.setEffect(new Glow(0.8));

        casilleroAsignado.getTextoPosicion().setVisible(true);

        Entidad entidad = casilleroAsignado.getCasillero().getEntidadContenida();

        if (entidad != null) {
            String nombreEntidad = entidad.getClass().getSimpleName();

            vistaPartidaController.getEntidadSeleccionadaLbl().setText(nombreEntidad.toUpperCase());
            vistaPartidaController.getDeJugadorLbl().setText(" de " + entidad.getNombreJugadorPropietario());
            vistaPartidaController.getVidaEntidadLbl().setText("Vida: " + entidad.getVida() + "/" + entidad.getVidaMaxima());

            vistaPartidaController.getStackPaneIcono().setVisible(true);
            vistaPartidaController.getCirculoIcono().setFill(new ImagePattern((casilleroAsignado.getImagen(nombreEntidad))));

            vistaPartidaController.getBarraDeVida().setVisible(true);
            vistaPartidaController.getBarraDeVida().setProgress(entidad.getPorcentajeDeVida());

            layoutBotones.getChildren().remove(2);

            String rutaBotonera = "/interfaz/view/botoneras/Botonera" + nombreEntidad + ".fxml";
            FXMLLoader loader = null;
            Node botonera = null;

            if ("Arquero".equals(nombreEntidad) || "Espadachin".equals(nombreEntidad)) {
                rutaBotonera = "/interfaz/view/botoneras/BotoneraGuerreros.fxml";
            } else if ("ArmaDeAsedio".equals(nombreEntidad)) {
                if (((ArmaDeAsedio) entidad).estaMontada()) {
                    rutaBotonera = "/interfaz/view/botoneras/BotoneraArmaDeAsedioMontada.fxml";
                } else {
                    rutaBotonera = "/interfaz/view/botoneras/BotoneraArmaDeAsedioDesmontada.fxml";
                }
            }

            try {
                loader = new FXMLLoader(getClass().getResource(rutaBotonera));
                botonera = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            layoutBotones.getChildren().add(2, botonera);
            AnchorPane.setTopAnchor(botonera, 200.0);
            AnchorPane.setLeftAnchor(botonera, -5.0);

            BotoneraController controller = loader.getController();

            vistaPartidaController.setControladorBotonera(controller, entidad);

        } else {
            vistaPartidaController.reiniciarBotonera();

        }
    }
}
