package interfaz;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.tablero.Casillero;
import interfaz.botoneras.BotoneraEdificioController;
import interfaz.botoneras.BotoneraUnidadController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

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

        Entidad entidad = casilleroAsignado.getCasillero().getEntidadContenida();
        if (entidad != null) {
            String nombreEntidad = entidad.getClass().toString().substring(entidad.getClass().toString().lastIndexOf(".") + 1);

            ((TextArea) layoutBotones.getChildren().get(2)).setText(nombreEntidad +
                    "\nVida: " + entidad.getVida() +
                    "\nJugador propietario: " + entidad.getNombreJugadorPropietario());


            layoutBotones.getChildren().remove(3);


            //TODO refactorizar para que no se repita codigo
            switch (nombreEntidad) {
                case "Aldeano":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("botoneras/BotoneraAldeano.fxml"));
                        layoutBotones.getChildren().add(3, loader.load());

                        BotoneraUnidadController controller = loader.getController();
                        Unidad unidad = (Unidad) entidad;

                        vistaPartidaController.setControladorBotoneraUnidad(controller, unidad);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Arquero":
                case "Espadachin":
                case "ArmaDeAsedio":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("botoneras/BotoneraGuerrero.fxml"));
                        layoutBotones.getChildren().add(3, loader.load());

                        BotoneraUnidadController controller = loader.getController();
                        Unidad unidad = (Unidad) entidad;

                        vistaPartidaController.setControladorBotoneraUnidad(controller, unidad);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                default:
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("botoneras/Botonera" + nombreEntidad + ".fxml"));
                        layoutBotones.getChildren().add(3, loader.load());

                        BotoneraEdificioController controller = loader.getController();
                        Edificio edificio = (Edificio) entidad;

                        vistaPartidaController.setControladorBotoneraEdificio(controller, edificio);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        } else {
            ((TextArea) layoutBotones.getChildren().get(2)).setText("Este casillero está vacío");
            try {

                layoutBotones.getChildren().remove(3);

                layoutBotones.getChildren().add(3, new FXMLLoader(getClass().getResource("botoneras/BotoneraVacia.fxml")).load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
