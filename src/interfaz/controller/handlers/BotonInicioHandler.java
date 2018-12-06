package interfaz.controller.handlers;


import algoempires.AlgoEmpires;
import algoempires.tablero.direccion.DireccionAbajo;
import algoempires.tablero.direccion.DireccionArriba;
import algoempires.tablero.direccion.DireccionDerecha;
import algoempires.tablero.direccion.DireccionIzquierda;
import interfaz.controller.PantallaInicioController;
import interfaz.controller.VistaPartidaController;
import javafx.application.HostServices;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;

public class BotonInicioHandler implements EventHandler<MouseEvent> {

    private final PantallaInicioController controladorActual;
    private final Stage primaryStage;
    private final HostServices navegadorWeb;
    private MediaPlayer musicaDeFondo;


    public BotonInicioHandler(Stage stage, PantallaInicioController controladorActual, MediaPlayer musicaDeFondo, HostServices navegadorWeb) {
        this.primaryStage = stage;
        this.controladorActual = controladorActual;
        this.musicaDeFondo = musicaDeFondo;
        this.navegadorWeb = navegadorWeb;
    }


    @Override
    public void handle(MouseEvent event) {

        AlgoEmpires modelo = controladorActual.crearModelo();

        primaryStage.setMaximized(true);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaz/view/VistaPartida.fxml"));

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
                    case SPACE:
                        controladorJuego.terminarTurno();
                }
            });

            primaryStage.setScene(escenaPartida);

            controladorJuego.crearCasilleros();

            musicaDeFondo.stop();
            Media media = new Media(Paths.get("src/interfaz/recursos/musicaEnPartida.mp3").toUri().toString());
            musicaDeFondo = new MediaPlayer(media);

            musicaDeFondo.setVolume(0.3);
            musicaDeFondo.play();

            controladorJuego.setMusicaDeFondo(musicaDeFondo);
            controladorJuego.setNavegador(navegadorWeb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
