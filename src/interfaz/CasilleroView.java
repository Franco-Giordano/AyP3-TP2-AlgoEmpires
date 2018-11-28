package interfaz;

import algoempires.entidad.Entidad;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.tablero.Casillero;
import interfaz.Botoneras.BotoneraAldeanoController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;

public class CasilleroView extends StackPane {

    private final Casillero casillero;

    public CasilleroView(Casillero casillero, int tamCasillero, Pane layoutBotones, VistaPartidaController vistaPartidaController) {

        this.casillero = casillero;

        Rectangle rectangulo = new Rectangle(tamCasillero, tamCasillero);
        Text pos = new Text("(" + casillero.getPosicion().getHorizontal() + "," + casillero.getPosicion().getVertical() + ")");

        pos.setFont(Font.font((float) tamCasillero / 5));
        pos.setMouseTransparent(true);
        this.getChildren().addAll(rectangulo, pos);


        if (casillero.estaOcupada()) {
            rectangulo.setStroke(Color.DARKRED);
            rectangulo.setFill(Color.DARKRED);

        } else {
            rectangulo.setStroke(Color.GREEN);
            rectangulo.setFill(Color.GREEN);
        }

        this.setOnMouseClicked(event -> {
            Entidad entidad = casillero.getEntidadContenida();
            if (entidad != null) {
                String nombreEntidad = entidad.getClass().toString().substring(entidad.getClass().toString().lastIndexOf(".") + 1);

                ((TextArea) layoutBotones.getChildren().get(1)).setText(nombreEntidad);


                layoutBotones.getChildren().remove(2);

                switch (nombreEntidad) {
                    case "Aldeano":
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Botoneras/BotoneraAldeano.fxml"));
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
                            layoutBotones.getChildren().add(2, new FXMLLoader(getClass().getResource("Botoneras/BotoneraGuerreros.fxml")).load());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    default:
                        try {
                            layoutBotones.getChildren().add(2, new FXMLLoader(getClass().getResource("Botoneras/Botonera" + nombreEntidad + ".fxml")).load());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
            } else {
                ((TextArea) layoutBotones.getChildren().get(1)).setText("Este casillero está vacío");
                try {

                    layoutBotones.getChildren().remove(2);

                    layoutBotones.getChildren().add(2, new FXMLLoader(getClass().getResource("Botoneras/BotoneraVacia.fxml")).load());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }


}
