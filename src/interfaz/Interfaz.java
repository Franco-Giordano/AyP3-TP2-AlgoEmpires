package interfaz;

import algoempires.AlgoEmpires;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;
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

                escenaPartida.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        switch (event.getCode()) {
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
                    }
                });

                primaryStage.setScene(escenaPartida);

                controladorJuego.crearCasilleros();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
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
