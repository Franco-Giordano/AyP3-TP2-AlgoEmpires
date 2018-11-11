package algoempires;



import org.omg.PortableServer.AdapterActivator;

public class Parcela {

	private boolean ocupada;
	private Entidad entidadOcupante;
	private int coordenadaHorizontal;
	private int coordenadaVertical;

	public Parcela() {
		ocupada = false;
		entidadOcupante = null;
		coordenadaHorizontal= 0;
		coordenadaVertical= 0;
	}
	
	public void setCoordenadaHorizontal(int nuevaCoordenadaHorizontal) {
		this.coordenadaHorizontal=nuevaCoordenadaHorizontal;
	}
	
	public void setCoordenadaVertical(int nuevaCoordenadaVertical) {
		this.coordenadaVertical=nuevaCoordenadaVertical;
	}

	public void ocupar(Entidad entidadOcupanteRecibida) {
		
		entidadOcupanteRecibida.setParcelaQueOcupo(this);;
		
		this.entidadOcupante = entidadOcupanteRecibida;
		
		this.ocupada= true;
	}

	public boolean estaOcupada() {
		return ocupada;
	}
	
	
	public boolean estasAUnaDistanciaMenorQue(int coordenadaHorizontalDeAtaque, int coordenadaVerticalDeAtaque,int rangoDeLaUnidad) {
		 
		return (Math.abs(coordenadaHorizontal-coordenadaHorizontalDeAtaque) <=rangoDeLaUnidad) &&
				(Math.abs(coordenadaVertical-coordenadaVerticalDeAtaque) <= rangoDeLaUnidad);
	}

}
