package algoempires.entidad.edificio;

import algoempires.entidad.Atacante;
import algoempires.entidad.Entidad;
import algoempires.excepciones.EdificioNoFuncionalException;
import algoempires.excepciones.NoSeToleraFuegoAmigoException;
import algoempires.excepciones.PosicionInvalidaException;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.Posicion;
import algoempires.tablero.Region;

import java.util.ArrayList;

public abstract class Edificio extends Entidad {

    protected int TAMANIO_HORIZONTAL;
    protected int TAMANIO_VERTICAL;
    protected int VELOCIDAD_DE_REPARACION;

    private boolean estaEnReparacion;
    private int turnosDeConstruccion;

    private Region regionQueLoContiene;

    public Edificio(Jugador jugador) throws PosicionInvalidaException {
        super(jugador);
        jugadorPropietario.agregar(this);
        this.turnosDeConstruccion = getTurnosDeConstruccionInicial();
        this.estaEnReparacion = true;
    }

    public Edificio() {
        super();
    }

    protected abstract int getTurnosDeConstruccionInicial();

    public Region generarRegion(ArrayList<Casillero> casillerosAOcupar) {

        return new Region(this, casillerosAOcupar);

    }

    public void sumarVida(int vidaASumar) {
        this.vida += vidaASumar;

        if (this.tieneVidaLlena()) {
            this.vida = getVidaMaxima();
        }
    }

    public void reparar() {

        this.sumarVida(this.VELOCIDAD_DE_REPARACION);

        if (this.tieneVidaLlena()) {
            this.estaEnReparacion = false;
        }
    }

    @Override
    public void restarVida(int vidaARestar) {

        vida -= vidaARestar;

        if (vida <= 0) {
            regionQueLoContiene.vaciar();
        }

    }

    public void recibirAtaqueDe(Atacante atacante) {

        if (atacante.esDelEquipo(jugadorPropietario)) {
            throw new NoSeToleraFuegoAmigoException("Un atacante intento herir un aliado!");
        }

        atacante.atacar(this);
    }

    public boolean tieneVidaLlena() {
        return this.vida >= getVidaMaxima();
    }

    public void continuarConstruccion() {
        this.turnosDeConstruccion--;
        this.sumarVida(getVidaInicial());

        if (this.tieneVidaLlena()) {
            this.vida = getVidaMaxima();
            this.estaEnReparacion = false;
        }
    }


    public void esFuncional() throws EdificioNoFuncionalException {
        if (this.estaEnReparacion) {
            throw new EdificioNoFuncionalException("No se pudo realizar la accion porque el " +
                    "edificio no esta funcional en este momento");
        }
    }


    public boolean terminoConstruccion() {
        return turnosDeConstruccion == 0;
    }

    //  TODO ver si esto se puede hacer mejor, probablemente se pueda.
    public void informarRegionOcupada(Region regionOcupada) {
        this.regionQueLoContiene = regionOcupada;
    }

    public int getTamanioHorizontal() {
        return TAMANIO_HORIZONTAL;
    }

    public int getTamanioVertical() {
        return TAMANIO_VERTICAL;
    }

    public Region getRegionQueLoContiene() {
        return regionQueLoContiene;
    }

    public ArrayList<Posicion> calcularPosicionesAOcupar(Posicion posInfIzquierda) {

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for (int i = 0; i < getTamanioHorizontal(); i++) {
            for (int j = 0; j < getTamanioVertical(); j++) {

                Posicion posicion = new Posicion(i, j, posInfIzquierda);
                posiciones.add(posicion);

            }
        }

        return posiciones;
    }

    public Casillero getCasilleroPertenecienteAlEdificio() {
        return regionQueLoContiene.getUnCasillero();
    }

    public void terminarConstruccion() {
        while (estaEnReparacion) {
            this.continuarConstruccion();
        }
    }

    @Override
    public int getVidaMaxima() {
        return getVidaInicial() * getTurnosDeConstruccionInicial();
    }

    public boolean estaConstruido() {
        return tieneVidaLlena();
    }

}
