package interfaz;

import algoempires.AlgoEmpires;
import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.DireccionAbajo;
import algoempires.tablero.direccion.DireccionArriba;
import algoempires.tablero.direccion.DireccionDerecha;
import algoempires.tablero.direccion.DireccionIzquierda;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

import java.io.IOException;

public class VistaPartidaController {

    private static final int RENDERIZAR_VERTICAL = 14;
    private static final int RENDERIZAR_HORIZONTAL = 20;
    private int tamanioCasillero = 0;
    private int VGAP = 5;
    private int HGAP = 5;
    private Terreno terrenoDeJuego;

    @FXML
    GridPane pane;

    @FXML
    BorderPane panePadre;

    @FXML
    Button btnTerminarTurno;

    Posicion posInfIzq;

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
        pos.setFont(Font.font((float)tamanioCasillero / 5));
        pos.setMouseTransparent(true);
        stack.getChildren().addAll(rectangulo, pos);

        if (terrenoDeJuego.estaOcupada(new Posicion(i, j))) {
            rectangulo.setStroke(Color.DARKRED);
            rectangulo.setFill(Color.DARKRED);

        } else {
            rectangulo.setStroke(Color.GREEN);
            rectangulo.setFill(Color.GREEN);
        }

        //TODO Lean el comentario de abajo que mas o menos explico todo lo que está mal con esto.
        /* Bueno, resulta que esto es un mega switch para ver que tipo de entidad es cuando hacemos click
        Eso, mal o bien, supongo que de muchas otras formas no lo podemos hacer.

        El problema es el de las botoneras.

        Resulta que la idea era que hubiera una "plantilla" de botonera, y solamente cambiar la parte del medio, dejar
        el TextArea y el boton de fin de turno siempre fijo en esa plantilla, y que cambie el VBox del medio (con los botones).
        Bueno, no pude hacerlo, así que vamos a tener que buscar la manera de poder hacerlo, porque ahora mismo cada botonera
        es una copia de la plantilla + su VBox con los respectivos botones que debería tener dependiendo de la unidad.

        Entonces es como un terrible copy paste, está mega mal.

        Vos te preguntarás "Federico, ¿por qué mierda no pudiste hacer andar lo que tenías que hacer andar?", bueno, mira,
        te cuento...

        Resulta que vos para poder cambiar la vista, tenés que agarrar el border pane, que viene a ser
        nuestro pane padre, y a eso decirle "getRight" onda, dame la derecha, que es donde tiene que ir nuestra botonera.
        Bueno, vos le decis "eh loco, getRight" y el chabón te dice, "ah si, tome buen señor, que tenga un buen día", y
        vos decís, AH RE PIOLA LOCO, ya está, ahora agarro y me va a dejar tener los comandos del ANCHOR PANE (que es el
        que está a la derecha en nuestro border pane) PERO NO, porque viene javafx y te dice: "vos querías que fuera fácil, no?"
        y te mete TREMENDA CACHETADA (ALTO ZAPLAAAAA), y no, no es tan fácil, NO TENÉS UN SOLO PUTO COMANDO DEL ANCHOR PANE.
        Entonces no me quedó otra que decile al border pane "CHE LOCO, setRight" y cambio toda la botonera.

        UNA PORONGA.

        Si leeiste esto, gracias por tu atención.

        Si no lo leiste, te espero a la salida hijo de mil puta.
         */

        rectangulo.setOnMouseClicked(event -> {
            Entidad entidad = terrenoDeJuego.obtenerEntidadEnPosicion(new Posicion(i, j));
            if (entidad != null) {
                switch (entidad.getClass().toString()){
                    case "class algoempires.entidad.unidad.utilero.Aldeano":{
                        try {
                            panePadre.setRight(new FXMLLoader(getClass().getResource("Botoneras/BotoneraAldeano.fxml")).load());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }break;
                    case "class algoempires.entidad.edificio.PlazaCentral":{
                        try {
                            panePadre.setRight(new FXMLLoader(getClass().getResource("Botoneras/BotoneraPlaza.fxml")).load());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }break;
                    case "class algoempires.entidad.edificio.Cuartel":{
                        try {
                            panePadre.setRight(new FXMLLoader(getClass().getResource("Botoneras/BotoneraCuartel.fxml")).load());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }break;
                    case "class algoempires.unidad.guerrero.Arquero":{
                        try {
                            panePadre.setRight(new FXMLLoader(getClass().getResource("Botoneras/BotoneraGuerrero.fxml")).load());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }break;
                    case "class algoempires.unidad.guerrero.Espadachin":{
                        try {
                            panePadre.setRight(new FXMLLoader(getClass().getResource("Botoneras/BotoneraGuerrero.fxml")).load());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }break;
                    case "class algoempires.unidad.guerrero.armadeasedio.ArmaDeAsedio":{
                        try {
                            panePadre.setRight(new FXMLLoader(getClass().getResource("Botoneras/BotoneraGuerrero.fxml")).load());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }break;
                }
            }
            else {
                try {
                    panePadre.setRight(new FXMLLoader(getClass().getResource("Botoneras/BotoneraVacia.fxml")).load());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        return stack;
    }

    public void setTerreno(Terreno terreno) {
        this.terrenoDeJuego = terreno;

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
