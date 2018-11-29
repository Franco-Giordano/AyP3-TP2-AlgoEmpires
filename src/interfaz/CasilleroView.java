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

public class CasilleroView extends StackPane {

    private final Casillero casillero;
    private static  Image imagen = new Image("/interfaz/recursos/imagenes/fondoPasto.png");

    public CasilleroView(Casillero casillero, int tamCasillero, Pane layoutBotones, VistaPartidaController vistaPartidaController) {

        this.casillero = casillero;

        Rectangle rectangulo = new Rectangle(tamCasillero, tamCasillero);
        Text pos = new Text("(" + casillero.getPosicion().getHorizontal() + "," + casillero.getPosicion().getVertical() + ")");

        pos.setFont(Font.font((float) tamCasillero / 5));
        pos.setFill(Color.WHITE);
        pos.setMouseTransparent(true);
        this.getChildren().addAll(rectangulo, pos);

        if (casillero.estaOcupada()) {
            rectangulo.setStroke(Color.DARKRED);
            rectangulo.setFill(Color.DARKRED);

        } else {
            rectangulo.setFill(new ImagePattern(imagen));
        }

        EstadoDefaultHandler handler = new EstadoDefaultHandler(layoutBotones, casillero, vistaPartidaController);

        this.setOnMouseClicked(handler);

    }


    public Casillero getCasillero() {
        return casillero;
    }
}
