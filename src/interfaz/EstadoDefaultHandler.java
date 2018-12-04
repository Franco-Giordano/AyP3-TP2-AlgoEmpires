package interfaz;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.entidad.unidad.guerrero.armadeasedio.ArmaDeAsedio;
import interfaz.botoneras.BotoneraArmaDeAsedioController;
import interfaz.botoneras.BotoneraEdificioController;
import interfaz.botoneras.BotoneraUnidadController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;

import java.io.IOException;

public class EstadoDefaultHandler implements EventHandler<MouseEvent> {

    private final Pane layoutBotones;
    private final CasilleroView casilleroAsignado;
    private final VistaPartidaController vistaPartidaController;

    public EstadoDefaultHandler(Pane layoutBotones, CasilleroView casilleroAsignado, VistaPartidaController vistaPartidaController) {
        this.layoutBotones = layoutBotones;
        this.casilleroAsignado = casilleroAsignado;
        this.vistaPartidaController = vistaPartidaController;
    }

    @Override
    public void handle(MouseEvent event) {

        vistaPartidaController.eliminarEfectosCasilleros();

        casilleroAsignado.setEffect(new Glow(0.8));



        Entidad entidad = casilleroAsignado.getCasillero().getEntidadContenida();
        if (entidad != null) {
            String claseEntidad = entidad.getClass().toString();
            String nombreEntidad = claseEntidad.substring(entidad.getClass().toString().lastIndexOf(".") + 1);

            vistaPartidaController.entidadSeleccionadaLbl.setText(nombreEntidad.toUpperCase());
            vistaPartidaController.deJugadorLbl.setText(" de " + entidad.getNombreJugadorPropietario());
            vistaPartidaController.vidaEntidadLbl.setText("Vida: " + entidad.getVida());

            vistaPartidaController.circuloIcono.setVisible(true);
            vistaPartidaController.circuloIcono.setFill(new ImagePattern((casilleroAsignado.getImagen(claseEntidad))));

            vistaPartidaController.barraDeVida.setVisible(true);
            vistaPartidaController.barraDeVida.setProgress(entidad.getPorcentajeDeVida());

            layoutBotones.getChildren().remove(2);

            //TODO refactorizar para que no se repita codigo
            switch (nombreEntidad) {
                case "Aldeano":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("botoneras/BotoneraAldeano.fxml"));
                        Node botonera = loader.load();
                        layoutBotones.getChildren().add(2, botonera);
                        AnchorPane.setTopAnchor(botonera, 150.0);
                        AnchorPane.setLeftAnchor(botonera, -5.0);

                        BotoneraUnidadController controller = loader.getController();
                        Unidad unidad = (Unidad) entidad;

                        vistaPartidaController.setControladorBotoneraUnidad(controller, unidad);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Arquero":
                case "Espadachin":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("botoneras/BotoneraGuerreros.fxml"));
                        Node botonera = loader.load();
                        layoutBotones.getChildren().add(2, botonera);
                        AnchorPane.setTopAnchor(botonera, 150.0);
                        AnchorPane.setLeftAnchor(botonera, -5.0);

                        BotoneraUnidadController controller = loader.getController();
                        Unidad unidad = (Unidad) entidad;

                        vistaPartidaController.setControladorBotoneraUnidad(controller, unidad);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "ArmaDeAsedio":
                    try {

                        Unidad unidad = (Unidad) entidad;
                        FXMLLoader loader;

                        if (((ArmaDeAsedio)unidad).estaMontada()) {
                            loader = new FXMLLoader(getClass().getResource("botoneras/BotoneraArmaDeAsedioMontada.fxml"));

                        }
                        else {
                            loader = new FXMLLoader(getClass().getResource("botoneras/BotoneraArmaDeAsedioDesmontada.fxml"));
                        }

                        Node botonera = loader.load();
                        layoutBotones.getChildren().add(2, botonera);
                        AnchorPane.setTopAnchor(botonera, 150.0);
                        AnchorPane.setLeftAnchor(botonera, -5.0);


                        BotoneraArmaDeAsedioController controller = loader.getController();
                        vistaPartidaController.setControladorBotoneraArmaDeAsedio(controller, (ArmaDeAsedio) unidad);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("botoneras/Botonera" + nombreEntidad + ".fxml"));
                        Node botonera = loader.load();
                        layoutBotones.getChildren().add(2, botonera);
                        AnchorPane.setTopAnchor(botonera, 270.0);
                        AnchorPane.setLeftAnchor(botonera, -5.0);

                        BotoneraEdificioController controller = loader.getController();
                        Edificio edificio = (Edificio) entidad;

                        vistaPartidaController.setControladorBotoneraEdificio(controller, edificio);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } else {
            vistaPartidaController.reiniciarBotonera();

        }
    }
}
