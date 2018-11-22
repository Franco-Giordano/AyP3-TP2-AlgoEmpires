package Interfaz;

import algoempires.AlgoEmpires;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.DireccionAbajo;
import algoempires.tablero.direccion.DireccionArriba;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Interfaz extends Application {

    AlgoEmpires juego;

    @Override
    public void start(Stage primaryStage) throws Exception{

        //TODO si ponés (15, 15), (14,16). (16,14) u otros, rompe, no se como cajajo funciona esto. Milagrosamente el (13,16), anda... AUXILIO
        this.juego = new AlgoEmpires(13,16);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VistaInterfaz.fxml"));

        Parent root = fxmlLoader.load();

        Controlador controlador = (Controlador) fxmlLoader.getController();

        controlador.setJuego(juego);

        controlador.crearCasilleros();

        primaryStage.setTitle("AlgoEmpires");

        primaryStage.setMaximized(true);

        primaryStage.setResizable(false);

        primaryStage.setScene(new Scene(root));

        primaryStage.show();

        Jugador[] jugadores = juego.getJugadores();

        jugadores[0].moverUnidad(new Posicion(5,7),new DireccionArriba());
        jugadores[1].moverUnidad(new Posicion(7,12), new DireccionAbajo());

    }


    public static void main(String[] args) {
        launch(args);
    }
}
