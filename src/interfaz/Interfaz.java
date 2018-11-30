package interfaz;

import algoempires.AlgoEmpires;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Interfaz extends Application {

    AlgoEmpires juego;

    private Scene escenaDeInicio;

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

        primaryStage.show();

        BotonInicioHandler handlerInicio = new BotonInicioHandler(primaryStage, controlador);

        controlador.getBotonInicio().setOnMouseClicked(handlerInicio);
    }

}
