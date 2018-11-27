package interfaz;

import algoempires.AlgoEmpires;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Interfaz extends Application {

    AlgoEmpires juego;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.initStyle(StageStyle.UNDECORATED);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PantallaInicio.fxml"));

        Parent root = fxmlLoader.load();

        PantallaInicioController controlador = fxmlLoader.getController();

        /* --------------------------------------------- NO BORRAR -----------------------------------------------------
        this.juego = new AlgoEmpires(100, 100);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VistaInterfaz.fxml"));

        Parent root = fxmlLoader.load();

        Controlador controlador = fxmlLoader.getController();

        controlador.setTerreno(juego.getTerreno());

        //crear casilleros actualiza el terreno.

        primaryStage.setTitle("AlgoEmpires");

        Scene escena = new Scene(root);

        escena.getRoot().requestFocus();

        escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        controlador.renderizarArriba();
                        break;
                    case DOWN:
                        controlador.renderizarAbajo();
                        break;
                    case LEFT:
                        controlador.renderizarIzquierda();
                        break;
                    case RIGHT:
                        controlador.renderizarDerecha();
                        break;
                }
            }
        });

        */

        primaryStage.setTitle("AlgoEmpires");

        primaryStage.setMinHeight(Screen.getPrimary().getVisualBounds().getHeight());

        primaryStage.setMinWidth(Screen.getPrimary().getVisualBounds().getWidth());

        Scene escena = new Scene(root, Screen.getPrimary().getVisualBounds().getHeight(), Screen.getPrimary().getVisualBounds().getWidth());

        primaryStage.setMaximized(true);

        primaryStage.setResizable(false);

        primaryStage.setScene(escena);

        primaryStage.show();

        //controlador.crearCasilleros();


        /*jugadores[1].moverUnidad(new Posicion(7, 12), new DireccionAbajo());
        jugadores[0].moverUnidad(new Posicion(5, 7), new DireccionArriba());
        jugadores[0].moverUnidad(new Posicion(4,6),new DireccionDerecha());
        jugadores[1].moverUnidad(new Posicion(8,13),new DireccionAbajoIzquierda());
        jugadores[0].crearAldeano((PlazaCentral)juego.getTerreno().obtenerEntidadEnPosicion(new Posicion(3,8)),new Posicion(3,9));
*/
    }
}
