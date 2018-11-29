package interfaz;

import algoempires.AlgoEmpires;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Interfaz extends Application {

    AlgoEmpires juego;

    private Scene escenaDeInicio;
    private Scene escenaPartida;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.initStyle(StageStyle.UNDECORATED);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PantallaInicio.fxml"));

        Pane root = fxmlLoader.load();

        PantallaInicioController controlador = fxmlLoader.getController();

        primaryStage.setTitle("AlgoEmpires");

        escenaDeInicio = new Scene(root);

        primaryStage.setScene(escenaDeInicio);

        primaryStage.setResizable(false);

        primaryStage.setMaximized(true);

        primaryStage.show();



        controlador.getBotonInicio().setOnMouseClicked(event -> {

            this.juego = controlador.crearJuego();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaPartida.fxml"));

            try {

                Pane pane = loader.load();

                VistaPartidaController controladorJuego = loader.getController();

                controladorJuego.setJuego(juego);

                escenaPartida = new Scene(pane);

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
        });
    }

}
