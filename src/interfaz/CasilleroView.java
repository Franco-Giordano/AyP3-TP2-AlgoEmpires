package interfaz;

import algoempires.tablero.Casillero;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.HashMap;

import static javafx.scene.paint.Color.TRANSPARENT;

public class CasilleroView extends StackPane {

    private static HashMap<String, Image> iconos = crearMapaDeIconos();
    private final Casillero casillero;
    Text textoPosicion;

    public CasilleroView(Casillero casillero, int tamCasillero, Pane layoutBotones, VistaPartidaController vistaPartidaController) {

        this.casillero = casillero;

        Rectangle rectanguloEntidad = new Rectangle(tamCasillero, tamCasillero);
        Rectangle rectanguloFondoPasto = new Rectangle(tamCasillero, tamCasillero);

        textoPosicion = new Text("(" + casillero.getPosicion().getHorizontal() + "," + casillero.getPosicion().getVertical() + ")");

        textoPosicion.setFont(Font.font("Liberation Serif", FontWeight.EXTRA_BOLD, (float) tamCasillero / 4));
        textoPosicion.setFill(Color.BLACK);
        textoPosicion.setVisible(false);

        rectanguloFondoPasto.setFill(new ImagePattern(iconos.get("Pasto")));

        rectanguloEntidad.setFill(TRANSPARENT);

        this.getChildren().addAll(rectanguloFondoPasto, rectanguloEntidad, textoPosicion);

        if (casillero.estaOcupada()) {
            String nombreEntidad = casillero.getEntidadContenida().getClass().toString();
            rectanguloEntidad.setFill(new ImagePattern(iconos.get(nombreEntidad)));
        }

        EstadoDefaultHandler handler = new EstadoDefaultHandler(layoutBotones, this, vistaPartidaController);

        this.setOnMouseClicked(handler);

        this.setOnMouseEntered(event -> textoPosicion.setVisible(true));

        this.setOnMouseExited(event -> textoPosicion.setVisible(false));

    }

    private static HashMap<String, Image> crearMapaDeIconos() {
        HashMap<String, Image> mapa = new HashMap<>();

        mapa.put("Pasto", new Image("/interfaz/recursos/imagenes/fondoPasto.png"));
        mapa.put("class algoempires.entidad.unidad.utilero.Aldeano", new Image("/interfaz/recursos/imagenes/iconoAldeano.png"));
        mapa.put("class algoempires.entidad.unidad.guerrero.Arquero", new Image("/interfaz/recursos/imagenes/iconoArquero.png"));
        mapa.put("class algoempires.entidad.unidad.guerrero.Espadachin", new Image("/interfaz/recursos/imagenes/iconoEspadachin.png"));
        mapa.put("class algoempires.entidad.unidad.guerrero.armadeasedio.ArmaDeAsedio", new Image("/interfaz/recursos/imagenes/iconoArmaDeAsedio.png"));
        mapa.put("class algoempires.entidad.edificio.Castillo", new Image("/interfaz/recursos/imagenes/iconoCastillo.png"));
        mapa.put("class algoempires.entidad.edificio.Cuartel", new Image("/interfaz/recursos/imagenes/iconoCuartel.png"));
        mapa.put("class algoempires.entidad.edificio.PlazaCentral", new Image("/interfaz/recursos/imagenes/iconoPlazaCentral.png"));

        return mapa;
    }

    public Casillero getCasillero() {
        return casillero;
    }

    public Image getImagen(String nombreEntidad) {
        return iconos.get(nombreEntidad);
    }
}
