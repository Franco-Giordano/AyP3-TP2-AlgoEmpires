package interfaz;

import algoempires.tablero.Casillero;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.HashMap;

public class CasilleroView extends StackPane {

    private final Casillero casillero;
    private static HashMap<String, Image> iconos = crearMapaDeIconos();

    public CasilleroView(Casillero casillero, int tamCasillero, Pane layoutBotones, VistaPartidaController vistaPartidaController) {

        this.casillero = casillero;

        Rectangle rectangulo = new Rectangle(tamCasillero, tamCasillero);
        Text pos = new Text("(" + casillero.getPosicion().getHorizontal() + "," + casillero.getPosicion().getVertical() + ")");

        pos.setFont(Font.font((float) tamCasillero / 5));
        pos.setFill(Color.WHITE);
        pos.setMouseTransparent(true);
        this.getChildren().addAll(rectangulo, pos);

        if (casillero.estaOcupada()) {
            String nombreEntidad = casillero.getEntidadContenida().getClass().toString();
            rectangulo.setFill(new ImagePattern(iconos.get(nombreEntidad)));

        } else {
            rectangulo.setFill(new ImagePattern(iconos.get("Pasto")));
        }

        EstadoDefaultHandler handler = new EstadoDefaultHandler(layoutBotones, casillero, vistaPartidaController);

        this.setOnMouseClicked(handler);

    }


    public Casillero getCasillero() {
        return casillero;
    }

    private static HashMap<String, Image> crearMapaDeIconos() {
        HashMap<String, Image> mapa = new HashMap<>();

        mapa.put("Pasto", new Image("/interfaz/recursos/imagenes/fondoPasto.png"));
        mapa.put("class algoempires.entidad.unidad.utilero.Aldeano", new Image("/interfaz/recursos/imagenes/iconoAldeano.jpg"));
        mapa.put("class algoempires.entidad.unidad.guerrero.Arquero", new Image("/interfaz/recursos/imagenes/iconoArquero.jpg"));
        mapa.put("class algoempires.entidad.unidad.guerrero.Espadachin", new Image("/interfaz/recursos/imagenes/iconoEspadachin.jpg"));
        mapa.put("class algoempires.entidad.unidad.guerrero.armadeasedio.ArmaDeAsedio", new Image("/interfaz/recursos/imagenes/iconoArmaDeAsedio.jpg"));
        mapa.put("class algoempires.entidad.edificio.Castillo", new Image("/interfaz/recursos/imagenes/iconoCastillo.bmp"));
        mapa.put("class algoempires.entidad.edificio.Cuartel", new Image("/interfaz/recursos/imagenes/iconoCuartel.bmp"));
        mapa.put("class algoempires.entidad.edificio.PlazaCentral", new Image("/interfaz/recursos/imagenes/iconoPlazaCentral.bmp"));

        return mapa;
    }
}
