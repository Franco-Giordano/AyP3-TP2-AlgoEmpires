package interfaz;

import algoempires.AlgoEmpires;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.DireccionAbajo;
import algoempires.tablero.direccion.DireccionArriba;
import algoempires.tablero.direccion.DireccionDerecha;
import algoempires.tablero.direccion.DireccionIzquierda;
import interfaz.botoneras.BotoneraAldeanoController;
import interfaz.tareas.Tarea;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

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

    private CasilleroView crearCasillero(int i, int j) {

        CasilleroView casilleroView = new CasilleroView(terrenoDeJuego.getCasillero(i, j), tamanioCasillero, (Pane) panePadre.getRight(), this);

        return casilleroView;
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

    public void setControladorBotoneraAldeano(BotoneraAldeanoController controller, Aldeano aldeano) {
        controller.setCasillero(aldeano.getCasillero());
        controller.setJugadorActual(juego.getJugadorActual());
        controller.setVistaController(this);
    }

    public void setHandlersEnEspera(Tarea tarea) {
        for (Node casillero : pane.getChildren()) {
            tarea.setCasillero(((CasilleroView)casillero).getCasillero());
            casillero.setOnMouseClicked(new EstadoEnEsperaDeClickHandler(tarea));
        }
    }
}
