package interfaz;


import algoempires.AlgoEmpires;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

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
                        controladorJuego.renderizarArriba();
                        break;
                    case DOWN:
                        controladorJuego.renderizarAbajo();
                        break;
                    case LEFT:
                        controladorJuego.renderizarIzquierda();
                        break;
                    case RIGHT:
                        controladorJuego.renderizarDerecha();
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
