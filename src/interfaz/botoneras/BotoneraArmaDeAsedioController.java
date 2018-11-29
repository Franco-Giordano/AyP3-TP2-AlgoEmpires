package interfaz.botoneras;

import algoempires.entidad.unidad.guerrero.armadeasedio.ArmaDeAsedio;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.direccion.*;
import interfaz.VistaPartidaController;
import javafx.scene.input.MouseEvent;

public class BotoneraArmaDeAsedioController {

    private Jugador jugadorActual;
    private Casillero casillero;
    private VistaPartidaController vistaController;

    public void setJugadorActual(Jugador jugadorActual){
        this.jugadorActual = jugadorActual;
    }

    public void setCasillero(Casillero casillero){
        this.casillero = casillero;
    }

    public void setVistaController(VistaPartidaController vistaController){
        this.vistaController = vistaController;
    }

    public void moverArriba(MouseEvent mouseEvent) {
        Direccion direccion = new DireccionArriba();
        jugadorActual.moverUnidad(casillero.getPosicion(), direccion);

        vistaController.crearCasilleros();
    }

    public void moverIzquierda(MouseEvent mouseEvent) {

        Direccion direccion = new DireccionIzquierda();
        jugadorActual.moverUnidad(casillero.getPosicion(), direccion);

        vistaController.crearCasilleros();

    }

    public void moverDerecha(MouseEvent mouseEvent) {

        Direccion direccion = new DireccionDerecha();
        jugadorActual.moverUnidad(casillero.getPosicion(), direccion);

        vistaController.crearCasilleros();
    }

    public void moverAbajo(MouseEvent mouseEvent) {


        Direccion direccion = new DireccionAbajo();
        jugadorActual.moverUnidad(casillero.getPosicion(), direccion);

        vistaController.crearCasilleros();

    }

    public void moverArribaIzquierda(MouseEvent mouseEvent) {

        Direccion direccion = new DireccionArribaIzquierda();
        jugadorActual.moverUnidad(casillero.getPosicion(), direccion);

        vistaController.crearCasilleros();

    }

    public void moverArribaDerecha(MouseEvent mouseEvent) {

        Direccion direccion = new DireccionArribaDerecha();
        jugadorActual.moverUnidad(casillero.getPosicion(), direccion);

        vistaController.crearCasilleros();

    }

    public void moverAbajoIzquierda(MouseEvent mouseEvent) {

        Direccion direccion = new DireccionAbajoIzquierda();
        jugadorActual.moverUnidad(casillero.getPosicion(), direccion);

        vistaController.crearCasilleros();

    }

    public void moverAbajoDerecha(MouseEvent mouseEvent) {

        Direccion direccion = new DireccionAbajoDerecha();
        jugadorActual.moverUnidad(casillero.getPosicion(), direccion);

        vistaController.crearCasilleros();

    }

    public void desmontar(){
        jugadorActual.desmontarArmaDeAsedio((ArmaDeAsedio)casillero.getEntidadContenida());
        vistaController.crearCasilleros();
    }

    public void montar(){
        jugadorActual.montarArmaDeAsedio((ArmaDeAsedio)casillero.getEntidadContenida());
        vistaController.crearCasilleros();
    }
}
