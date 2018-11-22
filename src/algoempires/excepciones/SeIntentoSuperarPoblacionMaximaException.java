package algoempires.excepciones;

public class SeIntentoSuperarPoblacionMaximaException extends RuntimeException {

    public SeIntentoSuperarPoblacionMaximaException() {
        super("Casi se alcanza la sobrepoblacion!");
    }
}
