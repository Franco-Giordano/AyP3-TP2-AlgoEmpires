package interfaz;

import algoempires.entidad.Entidad;
import algoempires.entidad.unidad.guerrero.armadeasedio.ArmaDeAsedio;
import interfaz.botoneras.BotoneraController;
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

        casilleroAsignado.textoPosicion.setVisible(true);

        Entidad entidad = casilleroAsignado.getCasillero().getEntidadContenida();

        if (entidad != null) {
            String nombreEntidad = entidad.getClass().getSimpleName();

            vistaPartidaController.entidadSeleccionadaLbl.setText(nombreEntidad.toUpperCase());
            vistaPartidaController.deJugadorLbl.setText(" de " + entidad.getNombreJugadorPropietario());
            vistaPartidaController.vidaEntidadLbl.setText("Vida: " + entidad.getVida() + "/" + entidad.getVidaMaxima());

            vistaPartidaController.stackPaneIcono.setVisible(true);
            vistaPartidaController.circuloIcono.setFill(new ImagePattern((casilleroAsignado.getImagen(nombreEntidad))));

            vistaPartidaController.barraDeVida.setVisible(true);
            vistaPartidaController.barraDeVida.setProgress(entidad.getPorcentajeDeVida());

            layoutBotones.getChildren().remove(2);

            String rutaBotonera = "botoneras/Botonera" + nombreEntidad + ".fxml";
            FXMLLoader loader = null;
            Node botonera = null;

            if ("Arquero".equals(nombreEntidad) || "Espadachin".equals(nombreEntidad)) {
                rutaBotonera = "botoneras/BotoneraGuerreros.fxml";
            } else if ("ArmaDeAsedio".equals(nombreEntidad)) {
                if (((ArmaDeAsedio) entidad).estaMontada()) {
                    rutaBotonera = "botoneras/BotoneraArmaDeAsedioMontada.fxml";
                } else {
                    rutaBotonera = "botoneras/BotoneraArmaDeAsedioDesmontada.fxml";
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
