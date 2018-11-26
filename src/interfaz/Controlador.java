package interfaz;

import algoempires.AlgoEmpires;
import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class Controlador {

    private int tamanioCasillero;
    private int VGAP;
    private int HGAP;
    @FXML
    GridPane pane;
    @FXML
    TextArea textArea;
    private AlgoEmpires juego;
    @FXML
    BorderPane panePadre;

    public void initialize() {

        pane.setStyle("-fx-background-color: rgba(0, 0, 0, 255);");
        pane.setHgap(HGAP);
        pane.setVgap(VGAP);

        pane.setAlignment(Pos.CENTER);

        textArea.centerShapeProperty();

        panePadre.setPrefSize(Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());

        textArea.setWrapText(true);

    }

    public void crearCasilleros() {

        HGAP = 5;
        VGAP = 5;

        pane.setHgap(HGAP);
        pane.setVgap(VGAP);

        tamanioCasillero = (int)(panePadre.getCenter().getLayoutBounds().getHeight()/ juego.getTerreno().getTamVertical() - VGAP);

        for (int j = 0; j < juego.getTerreno().getTamVertical(); j++) {
            for (int i = 0; i < juego.getTerreno().getTamHorizontal(); i++) {
                pane.add(crearCasillero(i, j), i, juego.getTerreno().getTamVertical() - j);
            }
        }
    }

    private StackPane crearCasillero(int i, int j) {

        Rectangle rectangulo = new Rectangle(tamanioCasillero, tamanioCasillero);
        StackPane stack = new StackPane();
        stack.getChildren().addAll(rectangulo);

        Jugador[] jugadores = juego.getJugadores();

        if (juego.getTerreno().estaOcupada(new Posicion(i + 1, j + 1))) {
            rectangulo.setStroke(Color.DARKRED);
            rectangulo.setFill(Color.DARKRED);

        } else {
            rectangulo.setStroke(Color.GREEN);
            rectangulo.setFill(Color.GREEN);
        }

        rectangulo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Entidad entidad = juego.getTerreno().obtenerEntidadEnPosicion(new Posicion(i + 1, j + 1));
                if (entidad != null) {
                    if (entidad.getClass() == Aldeano.class) {
                        textArea.setText("Entidad: Aldeano" + "\nVida:" + entidad.getVida());
                    } else if (entidad.getClass() == PlazaCentral.class) {
                        textArea.setText("Entidad: Plaza Central"+ "\nVida:" + entidad.getVida());
                    } else {
                        textArea.setText("Entidad: Castillo" + "\nVida:" + entidad.getVida());
                    }
                } else {
                    textArea.setText("Este casillero está vacío!");
                }

            }
        });

        return stack;
    }

    public void setJuego(AlgoEmpires juego) {
        this.juego = juego;
    }

}
