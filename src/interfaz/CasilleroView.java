package interfaz;

import algoempires.tablero.Casillero;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CasilleroView extends StackPane {

    private final Casillero casillero;

    public CasilleroView(Casillero casillero, int tamCasillero, Pane layoutBotones, VistaPartidaController vistaPartidaController) {

        this.casillero = casillero;

        Rectangle rectangulo = new Rectangle(tamCasillero, tamCasillero);
        Text pos = new Text("(" + casillero.getPosicion().getHorizontal() + "," + casillero.getPosicion().getVertical() + ")");

        pos.setFont(Font.font((float) tamCasillero / 5));
        pos.setMouseTransparent(true);
        this.getChildren().addAll(rectangulo, pos);


        if (casillero.estaOcupada()) {
            rectangulo.setStroke(Color.DARKRED);
            rectangulo.setFill(Color.DARKRED);

        } else {
            rectangulo.setStroke(Color.GREEN);
            rectangulo.setFill(Color.GREEN);
        }

        EstadoDefaultHandler handler = new EstadoDefaultHandler(layoutBotones, casillero, vistaPartidaController);

        this.setOnMouseClicked(handler);

    }


    public Casillero getCasillero() {
        return casillero;
    }
}
