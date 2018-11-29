package interfaz;

import algoempires.entidad.Entidad;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.tablero.Casillero;
import interfaz.botoneras.BotoneraAldeanoController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class EstadoDefaultHandler implements EventHandler<MouseEvent> {

    private final Pane layoutBotones;
    private final Casillero casilleroAsignado;
    private final VistaPartidaController vistaPartidaController;

    public EstadoDefaultHandler(Pane layoutBotones, Casillero casilleroAsignado, VistaPartidaController vistaPartidaController) {
        this.layoutBotones = layoutBotones;
        this.casilleroAsignado = casilleroAsignado;
        this.vistaPartidaController = vistaPartidaController;
    }

    @Override
    public void handle(MouseEvent event) {

        Entidad entidad = casilleroAsignado.getEntidadContenida();
        if (entidad != null) {
            String nombreEntidad = entidad.getClass().toString().substring(entidad.getClass().toString().lastIndexOf(".") + 1);

            ((TextArea) layoutBotones.getChildren().get(1)).setText(nombreEntidad);


            layoutBotones.getChildren().remove(2);

            switch (nombreEntidad) {
                case "Aldeano":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("botoneras/BotoneraAldeano.fxml"));
                        layoutBotones.getChildren().add(2, loader.load());

                        BotoneraAldeanoController controller = loader.getController();
                        Aldeano aldeano = (Aldeano) entidad;

                        vistaPartidaController.setControladorBotoneraAldeano(controller, aldeano);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Arquero":
                case "Espadachin":
                case "ArmaDeAsedio":
                    try {
                        layoutBotones.getChildren().add(2, new FXMLLoader(getClass().getResource("botoneras/BotoneraGuerreros.fxml")).load());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                default:
                    try {
                        layoutBotones.getChildren().add(2, new FXMLLoader(getClass().getResource("botoneras/Botonera" + nombreEntidad + ".fxml")).load());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        } else {
            ((TextArea) layoutBotones.getChildren().get(1)).setText("Este casillero está vacío");
            try {

                layoutBotones.getChildren().remove(2);

                layoutBotones.getChildren().add(2, new FXMLLoader(getClass().getResource("botoneras/BotoneraVacia.fxml")).load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
