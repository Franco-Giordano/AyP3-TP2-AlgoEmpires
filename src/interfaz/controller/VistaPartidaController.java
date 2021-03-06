package interfaz.controller;

import algoempires.AlgoEmpires;
import algoempires.entidad.Entidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.Direccion;
import interfaz.controller.botoneras.BotoneraController;
import interfaz.controller.handlers.EstadoEnEsperaDeClickHandler;
import interfaz.controller.tareas.Tarea;
import interfaz.view.CasilleroView;
import javafx.animation.FadeTransition;
import javafx.application.HostServices;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Optional;

public class VistaPartidaController {

    private static final int RENDERIZAR_VERTICAL = 14;
    private static final int RENDERIZAR_HORIZONTAL = 20;

    @FXML
    private StackPane stackPaneIcono;

    @FXML
    private CheckMenuItem opcionesMusica;

    @FXML
    private ImageView imgOro, imgPoblacion;

    @FXML
    private GridPane gridPane;

    @FXML
    private BorderPane panePadre;

    @FXML
    private Button btnTerminarTurno;

    @FXML
    private Label nombreJugadorLbl, oroLbl, poblacionLbl;
    @FXML
    private Label entidadSeleccionadaLbl, deJugadorLbl, vidaEntidadLbl;
    @FXML
    private AnchorPane anchorDerecho;
    @FXML
    private Circle circuloIcono;
    @FXML
    private TextArea areaMensajes;
    @FXML
    private ProgressBar barraDeVida;
    @FXML
    private MenuBar menuSuperior;

    public StackPane getStackPaneIcono() {
        return stackPaneIcono;
    }

    public CheckMenuItem getOpcionesMusica() {
        return opcionesMusica;
    }

    public ImageView getImgOro() {
        return imgOro;
    }

    public ImageView getImgPoblacion() {
        return imgPoblacion;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public BorderPane getPanePadre() {
        return panePadre;
    }

    public Button getBtnTerminarTurno() {
        return btnTerminarTurno;
    }

    public Label getNombreJugadorLbl() {
        return nombreJugadorLbl;
    }

    public Label getOroLbl() {
        return oroLbl;
    }

    public Label getPoblacionLbl() {
        return poblacionLbl;
    }

    public Label getEntidadSeleccionadaLbl() {
        return entidadSeleccionadaLbl;
    }

    public Label getDeJugadorLbl() {
        return deJugadorLbl;
    }

    public Label getVidaEntidadLbl() {
        return vidaEntidadLbl;
    }

    public AnchorPane getAnchorDerecho() {
        return anchorDerecho;
    }

    public Circle getCirculoIcono() {
        return circuloIcono;
    }

    public TextArea getAreaMensajes() {
        return areaMensajes;
    }

    public ProgressBar getBarraDeVida() {
        return barraDeVida;
    }

    public MenuBar getMenuSuperior() {
        return menuSuperior;
    }

    private Posicion posInfIzq;
    private int tamanioCasillero = 0;
    private double VGAP = 1.5;
    private double HGAP = 1.5;
    private AlgoEmpires juego;
    private Terreno terrenoDeJuego;
    private MediaPlayer musicaDeFondo;
    private HostServices navegadorWEB; //para abrir URLs

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

        cambiarCursorPor("/interfaz/recursos/cursores/cursorPrincipal.png");

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

    private void cambiarCursorPor(String rutaCursor) {
        try {
            panePadre.setCursor(new ImageCursor(new Image(rutaCursor)));
        } catch (IllegalArgumentException e) {
            panePadre.setCursor(new ImageCursor(new Image("/interfaz/recursos/cursores/cursorPrincipal.png")));
        }
    }

    public void reiniciarBotonera() {

        ObservableList<Node> hijosBotonera = anchorDerecho.getChildren();

        entidadSeleccionadaLbl.setText("");
        deJugadorLbl.setText("");
        vidaEntidadLbl.setText("");

        stackPaneIcono.setVisible(false);
        barraDeVida.setVisible(false);

        hijosBotonera.remove(2);

        try {
            hijosBotonera.add(2, new FXMLLoader(getClass().getResource("../view/botoneras/BotoneraVacia.fxml")).load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CasilleroView crearCasillero(int i, int j) {

        CasilleroView casilleroView = new CasilleroView(terrenoDeJuego.getCasillero(i, j),
                tamanioCasillero, anchorDerecho, this);

        return casilleroView;
    }


    public void setJuego(AlgoEmpires juego) {
        this.juego = juego;
        this.terrenoDeJuego = juego.getTerreno();

        juego.getJugadores()[0].setVistaAInformantes(this);
        juego.getJugadores()[1].setVistaAInformantes(this);

        int coordVertical = (terrenoDeJuego.getTamVertical() - RENDERIZAR_VERTICAL) / 2 + 1;
        int coordHorizontal = (terrenoDeJuego.getTamHorizontal() - RENDERIZAR_HORIZONTAL) / 2 + 1;

        posInfIzq = new Posicion(coordHorizontal, coordVertical);
    }


    public void setMusicaDeFondo(MediaPlayer musicaDeFondo) {
        this.musicaDeFondo = musicaDeFondo;
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

        String rutaCursor = "/interfaz/recursos/cursores/cursor" + tarea.getClass().getSimpleName() + ".png";
        this.cambiarCursorPor(rutaCursor);

        for (Node casillero : gridPane.getChildren()) {

            casillero.setOnMouseEntered(event -> casillero.setEffect(new SepiaTone()));

            casillero.setOnMouseExited(event -> casillero.setEffect(null));

            casillero.setOnMouseClicked(new EstadoEnEsperaDeClickHandler(tarea, (CasilleroView) casillero, this));

        }

    }

    public void terminarTurno() {

        boolean ganoElJugadorActual = juego.terminarTurnoYChequearSiHayAlgunGanador();

        crearCasilleros();

        juego.getJugadorAnterior().getCastillo().informarDeAtaque();

        if (ganoElJugadorActual) {
            this.mostrarAlertaDeVictoriaConGanador(juego.getJugadorActual());
        }


    }

    private void mostrarAlertaDeVictoriaConGanador(Jugador jugadorActual) {

        ButtonType botonVerGit = new ButtonType("Ver en GitHub", ButtonBar.ButtonData.OTHER);
        ButtonType botonSalir = new ButtonType("Salir", ButtonBar.ButtonData.FINISH);

        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "\n\nOro final: " + jugadorActual.getOro() +
                        "\nPoblacion final: " + jugadorActual.getCantidadDeHabitantes(), botonVerGit, botonSalir);

        alert.setTitle("- VICTORIA -");
        alert.setHeaderText("Victoria de " + jugadorActual.getNombre());
        alert.setGraphic(new ImageView(new Image("/interfaz/recursos/iconoJuego.png")));

        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        alert.showAndWait();

        if (alert.getResult() == botonVerGit) {
            this.abrirURL("https://github.com/Franco-Giordano/AyP3-TP2-AlgoEmpires");
        }

        System.exit(0);
    }

    private void abrirURL(String url) {
        final Hyperlink hyperlink = new Hyperlink(url);
        navegadorWEB.showDocument(hyperlink.getText());
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

    public void controles() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "Click: Interactuar.\n\n" +
                        "Escape: Cancelar acción.\n\n" +
                        "Espacio: Terminar el turno.\n\n" +
                        "Flechas: Desplazarse por el terreno.\n");
        alert.setTitle("Controles");
        alert.setHeaderText("Controles");
        alert.showAndWait();
    }

    public void acercaDelJuego() {

        ButtonType abrirRepositorio = new ButtonType("Ver en GitHub", ButtonBar.ButtonData.OTHER);

        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "AlgoEmpires v4.0\n\n" +
                        "Trabajo práctico realizado en el marco de la materia Algoritmos y Programación III.\n\n" +
                        "Realizado por: \n\n" +
                        "#Giordano, Franco.\n\n" +
                        "#Iribarren, Alvaro.\n\n" +
                        "#Isola, Federico.\n\n" +
                        "Que lo disfrutes!\n\n" +
                        "El equipo de desarrollo de AlgoEmpires <3", abrirRepositorio, ButtonType.OK);

        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        alert.setTitle("Acerca del juego");
        alert.setHeaderText("Acerca del juego");
        alert.setGraphic(new ImageView(new Image("/interfaz/recursos/iconoJuego.png")));

        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.isPresent()) {
            if (resultado.get() == abrirRepositorio) {
                this.abrirURL("https://github.com/Franco-Giordano/AyP3-TP2-AlgoEmpires");
            }
        }


    }

    public void togglearMusica() {
        if (opcionesMusica.isSelected()) {
            musicaDeFondo.setMute(false);
        } else {
            musicaDeFondo.setMute(true);
        }
    }

    public CasilleroView getCasilleroViewEnPosicion(Posicion posicion) {
        for (Node casillero : gridPane.getChildren()) {
            if (((CasilleroView) casillero).getCasillero().getPosicion() == posicion) {
                return (CasilleroView) casillero;
            }
        }
        return null;
    }

    public void setNavegador(HostServices navegadorWeb) {
        this.navegadorWEB = navegadorWeb;
    }


    public void setControladorBotonera(BotoneraController controller, Entidad entidad) {

        controller.setCasillero(entidad.getUnCasilleroOcupado());

        controller.setJugadorActual(juego.getJugadorActual());

        controller.setVistaController(this);

    }

    public CasilleroView getCasilleroViewDeEntidad(Entidad entidad) {

        for (Node casillero : gridPane.getChildren()) {
            if (((CasilleroView) casillero).getCasillero().getEntidadContenida() == entidad) {
                return (CasilleroView) casillero;
            }
        }

        return null;

    }
}
