package interfaz.view;

import interfaz.controller.PantallaInicioController;
import interfaz.controller.handlers.BotonInicioHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.nio.file.Paths;

public class Interfaz extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.getIcons().add(new Image("/interfaz/recursos/iconoJuego.png"));

        Media media = new Media(Paths.get("src/interfaz/recursos/musicaEnMenu.mp3").toUri().toString());
        MediaPlayer musicaDeFondo = new MediaPlayer(media);
        musicaDeFondo.setVolume(0.3);
        musicaDeFondo.play();

        primaryStage.initStyle(StageStyle.UNDECORATED);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PantallaInicio.fxml"));

        Pane root = fxmlLoader.load();

        PantallaInicioController controlador = fxmlLoader.getController();

        primaryStage.setTitle("AlgoEmpires");

        Scene escenaDeInicio = new Scene(root);

        primaryStage.setScene(escenaDeInicio);

        primaryStage.setResizable(false);

        primaryStage.show();

        BotonInicioHandler handlerInicio = new BotonInicioHandler(primaryStage, controlador, musicaDeFondo, getHostServices());

        controlador.getBotonInicio().setOnMouseClicked(handlerInicio);


    }

}
