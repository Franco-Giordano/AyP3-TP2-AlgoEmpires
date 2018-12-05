package interfaz;


import algoempires.AlgoEmpires;
import algoempires.tablero.direccion.DireccionAbajo;
import algoempires.tablero.direccion.DireccionArriba;
import algoempires.tablero.direccion.DireccionDerecha;
import algoempires.tablero.direccion.DireccionIzquierda;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.input.KeyCode.ESCAPE;

public class BotonInicioHandler implements EventHandler<MouseEvent> {

    private final PantallaInicioController controladorActual;
    private final Stage primaryStage;


    public BotonInicioHandler(Stage stage, PantallaInicioController controladorActual) {
        this.primaryStage = stage;
        this.controladorActual = controladorActual;
    }


    @Override
    public void handle(MouseEvent event) {

        AlgoEmpires modelo = controladorActual.crearModelo();

        primaryStage.setMaximized(true);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaPartida.fxml"));

        try {

            Pane pane = loader.load();

            VistaPartidaController controladorJuego = loader.getController();


            controladorJuego.setJuego(modelo);

            Scene escenaPartida = new Scene(pane);


            escenaPartida.setOnKeyPressed(event1 -> {
                switch (event1.getCode()) {
                    case UP:
                        controladorJuego.renderizarHacia(new DireccionArriba());
                        break;
                    case DOWN:
                        controladorJuego.renderizarHacia(new DireccionAbajo());
                        break;
                    case LEFT:
                        controladorJuego.renderizarHacia(new DireccionIzquierda());
                        break;
                    case RIGHT:
                        controladorJuego.renderizarHacia(new DireccionDerecha());
                        break;
                    case ESCAPE:
                        controladorJuego.reiniciarBotonera();
                        controladorJuego.crearCasilleros();
                        break;
                }
            });

            primaryStage.setScene(escenaPartida);

            controladorJuego.crearCasilleros();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
