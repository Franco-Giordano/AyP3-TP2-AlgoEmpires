package interfaz;

import algoempires.AlgoEmpires;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.entidad.unidad.guerrero.armadeasedio.ArmaDeAsedio;
import algoempires.tablero.Casillero;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.Direccion;
import interfaz.botoneras.BotoneraArmaDeAsedioController;
import interfaz.botoneras.BotoneraEdificioController;
import interfaz.botoneras.BotoneraUnidadController;
import interfaz.tareas.Tarea;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.util.Duration;

import java.io.IOException;

public class VistaPartidaController {

    private static final int RENDERIZAR_VERTICAL = 14;
    private static final int RENDERIZAR_HORIZONTAL = 20;

    @FXML
    ImageView imgOro, imgPoblacion;

    @FXML
    GridPane gridPane;

    @FXML
    BorderPane panePadre;

    @FXML
    Button btnTerminarTurno;

    @FXML
    Label nombreJugadorLbl, oroLbl, poblacionLbl;

    @FXML
    Label entidadSeleccionadaLbl, deJugadorLbl, vidaEntidadLbl;

    @FXML
    AnchorPane anchorDerecho;

    @FXML
    Circle circuloIcono;

    @FXML
    TextArea areaMensajes;

    @FXML
    ProgressBar barraDeVida;

    @FXML
    MenuBar menuSuperior;

    private Posicion posInfIzq;
    private int tamanioCasillero = 0;
    private int VGAP = 3;
    private int HGAP = 3;
    private AlgoEmpires juego;
    private Terreno terrenoDeJuego;

    public void initialize() {

        gridPane.setStyle("-fx-background-color: rgba(0, 0, 0, 255);");
        gridPane.setHgap(HGAP);
        gridPane.setVgap(VGAP);

        gridPane.setAlignment(Pos.CENTER);

        panePadre.setPrefSize(Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());

        panePadre.getCenter().setOnMouseClicked(event -> {
            panePadre.getCenter().requestFocus();
        });

        Tooltip.install(imgOro, new Tooltip("Oro"));
        Tooltip.install(imgPoblacion, new Tooltip("Poblacion"));

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

        gridPane.getChildren().clear();

        if (tamanioCasillero == 0) {
            tamanioCasillero = (int) (panePadre.getCenter().getLayoutBounds().getHeight() / RENDERIZAR_VERTICAL - VGAP);
        }

        for (int j = 0; j < RENDERIZAR_VERTICAL; j++) {
            for (int i = 0; i < RENDERIZAR_HORIZONTAL; i++) {
                gridPane.add(crearCasillero(i + posInfIzq.getHorizontal(), j + posInfIzq.getVertical()),
                        i, RENDERIZAR_VERTICAL - j);
            }
        }
    }

    public void reiniciarBotonera() {

        ObservableList<Node> hijosBotonera = anchorDerecho.getChildren();

        entidadSeleccionadaLbl.setText("");
        deJugadorLbl.setText("");
        vidaEntidadLbl.setText("");

        circuloIcono.setVisible(false);
        barraDeVida.setVisible(false);

        hijosBotonera.remove(2);

        try {
            hijosBotonera.add(2, new FXMLLoader(getClass().getResource("botoneras/BotoneraVacia.fxml")).load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CasilleroView crearCasillero(int i, int j) {


        CasilleroView casilleroView = new CasilleroView(terrenoDeJuego.getCasillero(i, j), tamanioCasillero, anchorDerecho, this);

        return casilleroView;
    }


    public void setJuego(AlgoEmpires juego) {
        this.juego = juego;
        this.terrenoDeJuego = juego.getTerreno();

        juego.getJugadores()[0].getInformanteDeExcepciones().setVistaPartidaController(this);
        juego.getJugadores()[1].getInformanteDeExcepciones().setVistaPartidaController(this);

        int coordVertical = (terrenoDeJuego.getTamVertical() - RENDERIZAR_VERTICAL) / 2 + 1;
        int coordHorizontal = (terrenoDeJuego.getTamHorizontal() - RENDERIZAR_HORIZONTAL) / 2 + 1;

        posInfIzq = new Posicion(coordHorizontal, coordVertical);
    }

    public void renderizarHacia(Direccion direccion) {

        Posicion nuevaPosicionInfIzq = posInfIzq.generarMovimientoHacia(direccion);
        Posicion nuevaPosicionSupDer = new Posicion(RENDERIZAR_HORIZONTAL - 1, RENDERIZAR_VERTICAL - 1
                , nuevaPosicionInfIzq);

        boolean esValido = terrenoDeJuego.esPosicionValida(nuevaPosicionInfIzq)
                && terrenoDeJuego.esPosicionValida(nuevaPosicionSupDer);

        if (esValido) {
            posInfIzq = nuevaPosicionInfIzq;
            crearCasilleros();
        }
    }

    public void eliminarEfectosCasilleros() {

        for (Node casillero : gridPane.getChildren()) {
            casillero.setEffect(null);
        }

    }

    public void setHandlersEnEsperaConTarea(Tarea tarea) {

        for (Node casillero : gridPane.getChildren()) {

            Casillero casilleroActual = ((CasilleroView) casillero).getCasillero();

            casillero.setOnMouseEntered(event -> casillero.setEffect(new SepiaTone()));

            casillero.setOnMouseExited(event -> casillero.setEffect(null));

            casillero.setOnMouseClicked(new EstadoEnEsperaDeClickHandler(tarea, casilleroActual.getPosicion(), this));

        }

    }

    public void setControladorBotoneraUnidad(BotoneraUnidadController controller, Unidad unidad) {
        controller.setCasillero(unidad.getCasillero());

        controller.setJugadorActual(juego.getJugadorActual());

        controller.setVistaController(this);
    }

    public void setControladorBotoneraEdificio(BotoneraEdificioController controller, Edificio edificio) {
        controller.setRegion(edificio.getCasilleroPertenecienteAlEdificio());

        controller.setJugadorActual(juego.getJugadorActual());

        controller.setVistaController(this);
    }

    public void setControladorBotoneraArmaDeAsedio(BotoneraArmaDeAsedioController controller, ArmaDeAsedio armaDeAsedio) {
        controller.setCasillero(armaDeAsedio.getCasillero());

        controller.setJugadorActual(juego.getJugadorActual());

        controller.setVistaController(this);
    }

    public void terminarTurno() {

        juego.terminarTurno();
        crearCasilleros();
    }

    public void mostrarMensaje(String mensaje) {

        areaMensajes.setText(mensaje);

        FadeTransition ft = new FadeTransition(Duration.millis(6500), areaMensajes);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.play();

    }

    public void cerrarJuego() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "¿Está seguro que desea cerrar el juego?",
                ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            System.exit(0);
        }

    }

    public void acercaDelJuego() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "AlgoEmpires V4.0\n\n" +
                        "Esperamos que los disfrutes!\n\n" +
                        "Con amor,\n\n" +
                        "El equipo de desarrollo de AlgoEmpires <3");
        alert.showAndWait();
    }
}
