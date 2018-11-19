package algoempires.entidad;

public class SoloUnidadesPuedenVerASuAlrededorException extends RuntimeException {

    public SoloUnidadesPuedenVerASuAlrededorException() {
        //TODO esto es mentira, el castillo puede, pero andá a implementarlo.
        super(String.format("Solamente las unidades pueden ser capaces de distinguir a otras unidades."));
    }
}
