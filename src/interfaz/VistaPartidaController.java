package interfaz;

import algoempires.AlgoEmpires;
import algoempires.entidad.Entidad;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.DireccionAbajo;
import algoempires.tablero.direccion.DireccionArriba;
import algoempires.tablero.direccion.DireccionDerecha;
import algoempires.tablero.direccion.DireccionIzquierda;
import interfaz.Botoneras.BotoneraAldeanoController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

import java.io.IOException;

public class VistaPartidaController {

    private static final int RENDERIZAR_VERTICAL = 14;
    private static final int RENDERIZAR_HORIZONTAL = 20;
    Posicion posInfIzq;
    @FXML
    GridPane pane;
    @FXML
    BorderPane panePadre;
    @FXML
    Button btnTerminarTurno;
    @FXML
    TextArea textArea;
    private int tamanioCasillero = 0;
    private int VGAP = 5;
    private int HGAP = 5;
    private AlgoEmpires juego;
    private Terreno terrenoDeJuego;

    public void initialize() {


        pane.setStyle("-fx-background-color: rgba(0, 0, 0, 255);");
        pane.setHgap(HGAP);
        pane.setVgap(VGAP);

        pane.setAlignment(Pos.CENTER);

        panePadre.setPrefSize(Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());

        panePadre.getCenter().setOnMouseClicked(event -> {
            panePadre.getCenter().requestFocus();
        });


    }

    public void crearCasilleros() {

        panePadre.getCenter().requestFocus();

        pane.getChildren().clear();

        if (tamanioCasillero == 0) {
            tamanioCasillero = (int) (panePadre.getCenter().getLayoutBounds().getHeight() / RENDERIZAR_VERTICAL - VGAP);
        }

        for (int j = 0; j < RENDERIZAR_VERTICAL; j++) {
            for (int i = 0; i < RENDERIZAR_HORIZONTAL; i++) {
                pane.add(crearCasillero(i + posInfIzq.getHorizontal(), j + posInfIzq.getVertical()),
                        i, RENDERIZAR_VERTICAL - j);
            }
        }
    }

    private StackPane crearCasillero(int i, int j) {

        Rectangle rectangulo = new Rectangle(tamanioCasillero, tamanioCasillero);
        StackPane stack = new StackPane();
        Text pos = new Text("(" + i + "," + j + ")");
        pos.setFont(Font.font((float) tamanioCasillero / 5));
        pos.setMouseTransparent(true);
        stack.getChildren().addAll(rectangulo, pos);

        if (terrenoDeJuego.estaOcupada(new Posicion(i, j))) {
            rectangulo.setStroke(Color.DARKRED);
            rectangulo.setFill(Color.DARKRED);

        } else {
            rectangulo.setStroke(Color.GREEN);
            rectangulo.setFill(Color.GREEN);
        }

        rectangulo.setOnMouseClicked(event -> {
            Entidad entidad = terrenoDeJuego.obtenerEntidadEnPosicion(new Posicion(i, j));
            if (entidad != null) {
                String nombreEntidad = entidad.getClass().toString().substring(entidad.getClass().toString().lastIndexOf(".") + 1);

                textArea.setText(nombreEntidad);

                VBox vbox = (VBox) panePadre.getRight();
                this.eliminarBotonera();

                switch (nombreEntidad) {
                    case "Aldeano":
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Botoneras/BotoneraAldeano.fxml"));
                            vbox.getChildren().add(2, loader.load());

                            BotoneraAldeanoController controller = loader.getController();
                            Aldeano aldeano = (Aldeano) entidad;
                            controller.setCasillero(aldeano.getCasillero());
                            controller.setJugadorActual(juego.getJugadorActual());
                            controller.setVistaController(this);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "Arquero":
                    case "Espadachin":
                    case "ArmaDeAsedio":
                        try {
                            vbox.getChildren().add(2, new FXMLLoader(getClass().getResource("Botoneras/BotoneraGuerreros.fxml")).load());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    default:
                        try {
                            vbox.getChildren().add(2, new FXMLLoader(getClass().getResource("Botoneras/Botonera" + nombreEntidad + ".fxml")).load());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
            } else {
                textArea.setText("Este casillero está vacío");
                try {
                    VBox vbox = (VBox) panePadre.getRight();
                    this.eliminarBotonera();
                    vbox.getChildren().add(2, new FXMLLoader(getClass().getResource("Botoneras/BotoneraVacia.fxml")).load());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        return stack;
    }

    private void eliminarBotonera() {
        VBox vbox = (VBox) panePadre.getRight();
        try {
            vbox.getChildren().remove(2);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    public void setJuego(AlgoEmpires juego) {
        this.juego = juego;
        this.terrenoDeJuego = juego.getTerreno();

        int coordVertical = (terrenoDeJuego.getTamVertical() - RENDERIZAR_VERTICAL) / 2 + 1;
        int coordHorizontal = (terrenoDeJuego.getTamHorizontal() - RENDERIZAR_HORIZONTAL) / 2 + 1;

        posInfIzq = new Posicion(coordHorizontal, coordVertical);
    }

    public void renderizarArriba() {

        Posicion nuevaPosicionInfIzq = posInfIzq.generarMovimientoHacia(new DireccionArriba());
        Posicion nuevaPosicionSupDer = new Posicion(RENDERIZAR_HORIZONTAL - 1, RENDERIZAR_VERTICAL - 1
                , nuevaPosicionInfIzq);

        boolean esValido = terrenoDeJuego.esPosicionValida(nuevaPosicionInfIzq)
                && terrenoDeJuego.esPosicionValida(nuevaPosicionSupDer);

        if (esValido) {
            posInfIzq = nuevaPosicionInfIzq;
            crearCasilleros();
        }


    }

    public void renderizarAbajo() {

        Posicion nuevaPosicionInfIzq = posInfIzq.generarMovimientoHacia(new DireccionAbajo());
        Posicion nuevaPosicionSupDer = new Posicion(RENDERIZAR_HORIZONTAL - 1, RENDERIZAR_VERTICAL - 1
                , nuevaPosicionInfIzq);

        boolean esValido = terrenoDeJuego.esPosicionValida(nuevaPosicionInfIzq)
                && terrenoDeJuego.esPosicionValida(nuevaPosicionSupDer);
        if (esValido) {
            posInfIzq = nuevaPosicionInfIzq;
            crearCasilleros();
        }


    }

    public void renderizarIzquierda() {

        Posicion nuevaPosicionInfIzq = posInfIzq.generarMovimientoHacia(new DireccionIzquierda());
        Posicion nuevaPosicionSupDer = new Posicion(RENDERIZAR_HORIZONTAL - 1, RENDERIZAR_VERTICAL - 1
                , nuevaPosicionInfIzq);

        boolean esValido = terrenoDeJuego.esPosicionValida(nuevaPosicionInfIzq)
                && terrenoDeJuego.esPosicionValida(nuevaPosicionSupDer);

        if (esValido) {
            posInfIzq = nuevaPosicionInfIzq;
            crearCasilleros();
        }

    }

    public void renderizarDerecha() {

        Posicion nuevaPosicionInfIzq = posInfIzq.generarMovimientoHacia(new DireccionDerecha());
        Posicion nuevaPosicionSupDer = new Posicion(RENDERIZAR_HORIZONTAL - 1, RENDERIZAR_VERTICAL - 1
                , nuevaPosicionInfIzq);

        boolean esValido = terrenoDeJuego.esPosicionValida(nuevaPosicionInfIzq)
                && terrenoDeJuego.esPosicionValida(nuevaPosicionSupDer);
        if (esValido) {
            posInfIzq = nuevaPosicionInfIzq;
            crearCasilleros();
        }
    }

}
