package interfaz;

import algoempires.AlgoEmpires;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.io.IOException;

public class Interfaz extends Application {

    AlgoEmpires juego;

    Scene escenaDeInicio;
    Scene escenaPartida;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //primaryStage.initStyle(StageStyle.UNDECORATED);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PantallaInicio.fxml"));

        Pane root = (Pane) fxmlLoader.load();

        PantallaInicioController controlador = fxmlLoader.getController();

        /* --------------------------------------------- NO BORRAR -----------------------------------------------------
        this.juego = new AlgoEmpires(100, 100);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VistaPartida.fxml"));

        Parent root = fxmlLoader.load();

        VistaPartidaController controlador = fxmlLoader.getController();

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

        //primaryStage.setMinHeight(Screen.getPrimary().getVisualBounds().getHeight());

        //primaryStage.setMinWidth(Screen.getPrimary().getVisualBounds().getWidth());


        escenaDeInicio = new Scene(root);

        primaryStage.setScene(escenaDeInicio);

        primaryStage.setResizable(false);

        primaryStage.setMaximized(true);

        primaryStage.show();
        letterbox(escenaDeInicio, root);

        controlador.getBotonInicio().setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaPartida.fxml"));

            try {
                Pane pane = (Pane) loader.load();

                VistaPartidaController juegoControllerJuego = loader.getController();


            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //controlador.crearCasilleros();


        /*jugadores[1].moverUnidad(new Posicion(7, 12), new DireccionAbajo());
        jugadores[0].moverUnidad(new Posicion(5, 7), new DireccionArriba());
        jugadores[0].moverUnidad(new Posicion(4,6),new DireccionDerecha());
        jugadores[1].moverUnidad(new Posicion(8,13),new DireccionAbajoIzquierda());
        jugadores[0].crearAldeano((PlazaCentral)juego.getTerreno().obtenerEntidadEnPosicion(new Posicion(3,8)),new Posicion(3,9));
*/
    }

    private void letterbox(final Scene scene, final Pane contentPane) {
        final double initWidth = scene.getWidth();
        final double initHeight = scene.getHeight();
        final double ratio = initWidth / initHeight;

        SceneSizeChangeListener sizeListener = new SceneSizeChangeListener(scene, ratio, initHeight, initWidth, contentPane);
        scene.widthProperty().addListener(sizeListener);
        scene.heightProperty().addListener(sizeListener);
    }

    private static class SceneSizeChangeListener implements ChangeListener<Number> {
        private final Scene scene;
        private final double ratio;
        private final double initHeight;
        private final double initWidth;
        private final Pane contentPane;

        public SceneSizeChangeListener(Scene scene, double ratio, double initHeight, double initWidth, Pane contentPane) {
            this.scene = scene;
            this.ratio = ratio;
            this.initHeight = initHeight;
            this.initWidth = initWidth;
            this.contentPane = contentPane;
        }

        @Override
        public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
            final double newWidth = scene.getWidth();
            final double newHeight = scene.getHeight();

            double scaleFactor;
            if (newWidth / newHeight > ratio) scaleFactor = newHeight / initHeight;
            else scaleFactor = newWidth / initWidth;

            if (scaleFactor >= 1) {
                Scale scale = new Scale(scaleFactor, scaleFactor);
                scale.setPivotX(0);
                scale.setPivotY(0);
                scene.getRoot().getTransforms().setAll(scale);

                contentPane.setPrefWidth(newWidth / scaleFactor);
                contentPane.setPrefHeight(newHeight / scaleFactor);
            } else {
                contentPane.setPrefWidth(Math.max(initWidth, newWidth));
                contentPane.setPrefHeight(Math.max(initHeight, newHeight));
            }
        }
    }
}
