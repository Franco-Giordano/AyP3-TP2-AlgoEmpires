package interfaz;

import algoempires.AlgoEmpires;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.tablero.Casillero;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.DireccionAbajo;
import algoempires.tablero.direccion.DireccionArriba;
import algoempires.tablero.direccion.DireccionDerecha;
import algoempires.tablero.direccion.DireccionIzquierda;
import interfaz.botoneras.BotoneraEdificioController;
import interfaz.botoneras.BotoneraUnidadController;
import interfaz.tareas.Tarea;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.SepiaTone;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

import java.io.IOException;

public class VistaPartidaController {

    private static final int RENDERIZAR_VERTICAL = 14;
    private static final int RENDERIZAR_HORIZONTAL = 20;
    private Posicion posInfIzq;

    @FXML
    GridPane pane;

    @FXML
    BorderPane panePadre;

    @FXML
    Button btnTerminarTurno;

    @FXML
    TextArea textArea;

    @FXML
    Label nombreJugadorLbl;

    @FXML
    Label oroLbl;

    @FXML
    Label poblacionLbl;

    private int tamanioCasillero = 0;
    private int VGAP = 3;
    private int HGAP = 3;
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

    private void actualizarMarcador() {
        nombreJugadorLbl.setText(juego.getJugadorActual().getNombre());
        oroLbl.setText(Integer.toString(juego.getJugadorActual().getOro()));
        poblacionLbl.setText(Integer.toString(juego.getJugadorActual().getCantidadDeHabitantes()));
    }


    public void crearCasilleros() {

        reiniciarBotonera();

        actualizarMarcador();

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

    private void reiniciarBotonera() {

        ObservableList<Node> hijosBotonera = ((Pane) panePadre.getRight()).getChildren();

        ((TextArea) hijosBotonera.get(2)).setText("");

        hijosBotonera.remove(3);
        
        try {
            hijosBotonera.add(3, new FXMLLoader(getClass().getResource("botoneras/BotoneraVacia.fxml")).load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CasilleroView crearCasillero(int i, int j) {


        CasilleroView casilleroView = new CasilleroView(terrenoDeJuego.getCasillero(i, j), tamanioCasillero, (Pane) panePadre.getRight(), this);

        return casilleroView;
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

    public void setControladorBotoneraUnidad(BotoneraUnidadController controller, Unidad unidad) {
        controller.setCasillero(unidad.getCasillero());
        controller.setJugadorActual(juego.getJugadorActual());
        controller.setVistaController(this);
    }

    public void eliminarEfectosCasilleros(){

        for (Node casillero : pane.getChildren()) {
            casillero.setEffect(null);
        }

    }

    public void setHandlersEnEsperaConTarea(Tarea tarea) {

        for (Node casillero : pane.getChildren()) {

            Casillero casilleroActual = ((CasilleroView) casillero).getCasillero();

            casillero.setOnMouseEntered(event -> casillero.setEffect(new SepiaTone()));

            casillero.setOnMouseExited(event -> casillero.setEffect(null));

            casillero.setOnMouseClicked(new EstadoEnEsperaDeClickHandler(tarea, casilleroActual.getPosicion(), this));


        }

    }

    public void setControladorBotoneraEdificio(BotoneraEdificioController controller, Edificio edificio) {
        controller.setRegion(edificio.getCasilleroPertenecienteAlEdificio());
        controller.setJugadorActual(juego.getJugadorActual());
        controller.setVistaController(this);
    }
}
