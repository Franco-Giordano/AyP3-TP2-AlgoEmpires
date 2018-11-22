package Interfaz;

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

public class Controlador {

    private final int TAMANIO_CASILLERO = 50;
    private final int VGAP = TAMANIO_CASILLERO / 10;
    private final int HGAP = TAMANIO_CASILLERO / 10;
    @FXML
    GridPane pane;
    @FXML
    TextArea textArea;
    private AlgoEmpires juego;
    @FXML
    Text textoJugador1;
    @FXML
    Text textoJugador2;
    @FXML
    VBox vBox;

    public void initialize() {

        pane.setStyle("-fx-background-color: rgba(0, 0, 0, 255);");
        pane.setHgap(HGAP);
        pane.setVgap(VGAP);

        pane.setAlignment(Pos.CENTER);

        textArea.centerShapeProperty();

        vBox.setBackground(Background.EMPTY);

    }

    public void crearCasilleros() {

        for (int j = 0; j < juego.getTerreno().getTamVertical(); j++) {
            for (int i = 0; i < juego.getTerreno().getTamHorizontal(); i++) {
                pane.add(crearCasillero(i, j), i, juego.getTerreno().getTamVertical() - j);
            }
        }
    }

    private StackPane crearCasillero(int i, int j) {

        Rectangle rectangulo = new Rectangle(TAMANIO_CASILLERO, TAMANIO_CASILLERO);
        //Text text = new Text();
        Text posicion = new Text(String.format("%d,%d", i + 1, j + 1));
        StackPane stack = new StackPane();
        stack.getChildren().addAll(rectangulo, posicion);

        Jugador[] jugadores = juego.getJugadores();

        textoJugador1.setText("Jugador 1 Oro: " + jugadores[0].getOro());
        textoJugador2.setText("Jugador 2 Oro: " + jugadores[1].getOro());

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
                        textArea.setText("Entidad: Aldeano (" + entidad + ")\nVida:" + entidad.getVida());
                    } else if (entidad.getClass() == PlazaCentral.class) {
                        textArea.setText("Entidad: Plaza Central(" + entidad + ")\nVida:" + entidad.getVida());
                    } else {
                        textArea.setText("Entidad: Castillo(" + entidad + ")\nVida:" + entidad.getVida());
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
        Jugador[] jugadores = juego.getJugadores();

        textoJugador1.setText("Jugador 1 Oro: " + jugadores[0].getOro());
        textoJugador2.setText("Jugador 2 Oro: " + jugadores[1].getOro());
    }

}
