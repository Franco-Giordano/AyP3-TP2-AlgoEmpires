package interfaz;

import algoempires.AlgoEmpires;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.direccion.DireccionAbajo;
import algoempires.tablero.direccion.DireccionAbajoIzquierda;
import algoempires.tablero.direccion.DireccionArriba;
import algoempires.tablero.direccion.DireccionDerecha;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Interfaz extends Application {

    AlgoEmpires juego;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.juego = new AlgoEmpires(20, 14);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VistaInterfaz.fxml"));

        Parent root = fxmlLoader.load();

        Controlador controlador = fxmlLoader.getController();

        controlador.setJuego(juego);

        //crear casilleros actualiza el terreno.

        primaryStage.setTitle("AlgoEmpires");

        primaryStage.setScene(new Scene(root));

        primaryStage.setMinHeight(Screen.getPrimary().getVisualBounds().getHeight());

        primaryStage.setMinWidth(Screen.getPrimary().getVisualBounds().getWidth());

        primaryStage.setResizable(false);

        primaryStage.setFullScreen(true);

        primaryStage.show();

        controlador.crearCasilleros();

        Jugador[] jugadores = juego.getJugadores();

        /*jugadores[1].moverUnidad(new Posicion(7, 12), new DireccionAbajo());
        jugadores[0].moverUnidad(new Posicion(5, 7), new DireccionArriba());
        jugadores[0].moverUnidad(new Posicion(4,6),new DireccionDerecha());
        jugadores[1].moverUnidad(new Posicion(8,13),new DireccionAbajoIzquierda());
        jugadores[0].crearAldeano((PlazaCentral)juego.getTerreno().obtenerEntidadEnPosicion(new Posicion(3,8)),new Posicion(3,9));
*/
    }
}
