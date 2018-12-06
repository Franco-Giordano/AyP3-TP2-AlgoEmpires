package interfaz;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.tablero.Casillero;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.HashMap;

import static javafx.scene.paint.Color.TRANSPARENT;

public class CasilleroView extends StackPane {

    private static HashMap<String, Image> iconos = crearMapaDeIconos();

    private final Casillero casillero;
    private final Rectangle rectanguloAnimaciones;
    Text textoPosicion;

    public CasilleroView(Casillero casillero, int tamCasillero, Pane layoutBotones, VistaPartidaController vistaPartidaController) {

        this.casillero = casillero;

        rectanguloAnimaciones = new Rectangle(tamCasillero, tamCasillero);
        Rectangle rectanguloEntidad = new Rectangle(tamCasillero, tamCasillero);
        Rectangle rectanguloFondoPasto = new Rectangle(tamCasillero, tamCasillero);

        textoPosicion = new Text("(" + casillero.getPosicion().getHorizontal() + "," + casillero.getPosicion().getVertical() + ")");

        textoPosicion.setFont(Font.font("Liberation Serif", FontWeight.EXTRA_BOLD, (float) tamCasillero / 3.5));
        textoPosicion.setFill(Color.BLACK);
        textoPosicion.setVisible(false);

        rectanguloFondoPasto.setFill(new ImagePattern(iconos.get("Pasto")));

        rectanguloEntidad.setFill(TRANSPARENT);

        rectanguloAnimaciones.setFill(TRANSPARENT);

        this.getChildren().addAll(rectanguloFondoPasto, rectanguloEntidad, rectanguloAnimaciones, textoPosicion);

        if (casillero.estaOcupada()) {

            Entidad entidadContenida = casillero.getEntidadContenida();

            String nombreEntidad = entidadContenida.getClass().getSimpleName();

            if (entidadContenida.getClass() == PlazaCentral.class || entidadContenida.getClass() == Cuartel.class) {

                if (((Edificio) entidadContenida).estaEnconstruccion()) {
                    rectanguloEntidad.setFill(new ImagePattern(iconos.get("enConstruccion")));
                } else {
                    rectanguloEntidad.setFill(new ImagePattern(iconos.get(nombreEntidad)));
                }
            } else {
                rectanguloEntidad.setFill(new ImagePattern(iconos.get(nombreEntidad)));
            }
        }

        EstadoDefaultHandler handler = new EstadoDefaultHandler(layoutBotones, this, vistaPartidaController);

        this.setOnMouseClicked(handler);

        this.setOnMouseEntered(event -> textoPosicion.setVisible(true));

        this.setOnMouseExited(event -> textoPosicion.setVisible(false));

    }

    private static HashMap<String, Image> crearMapaDeIconos() {
        HashMap<String, Image> mapa = new HashMap<>();

        mapa.put("Pasto", new Image("/interfaz/recursos/imagenes/fondoPasto.png"));
        mapa.put("enConstruccion", new Image("/interfaz/recursos/imagenes/enConstruccion.jpg"));
        mapa.put("animacionDanioUnidad", new Image("/interfaz/recursos/animaciones/animacionDanioUnidad.gif"));
        mapa.put("animacionDanioEdificio", new Image("/interfaz/recursos/animaciones/animacionDanioEdificio.gif"));
        mapa.put("Aldeano", new Image("/interfaz/recursos/imagenes/iconoAldeano.png"));
        mapa.put("Arquero", new Image("/interfaz/recursos/imagenes/iconoArquero.png"));
        mapa.put("Espadachin", new Image("/interfaz/recursos/imagenes/iconoEspadachin.png"));
        mapa.put("ArmaDeAsedio", new Image("/interfaz/recursos/imagenes/iconoArmaDeAsedio.png"));
        mapa.put("Castillo", new Image("/interfaz/recursos/imagenes/iconoCastillo.png"));
        mapa.put("Cuartel", new Image("/interfaz/recursos/imagenes/iconoCuartel.png"));
        mapa.put("PlazaCentral", new Image("/interfaz/recursos/imagenes/iconoPlazaCentral.png"));

        return mapa;
    }

    public Casillero getCasillero() {
        return casillero;
    }

    public Image getImagen(String nombreEntidad) {
        return iconos.get(nombreEntidad);
    }

    public void reproducirAnimacion(String claveDeAnimacion) {
        rectanguloAnimaciones.setFill(new ImagePattern(iconos.get(claveDeAnimacion)));

        FadeTransition ft = new FadeTransition(Duration.millis(2000), rectanguloAnimaciones);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.play();
    }
}
