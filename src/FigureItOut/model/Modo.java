package FigureItOut.model;

public class Modo {
	int nivel;
	double dineroGanado;
	/**
	 * @param nivel
	 * @param dineroGanado
	 */
	public Modo(int nivel, double dineroGanado) {
		super();
		this.nivel = nivel;
		this.dineroGanado = dineroGanado;
	}
	/**
	 * @return the nivel
	 */
	public int getNivel() {
		return nivel;
	}
	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	/**
	 * @return the dineroGanado
	 */
	public double getDineroGanado() {
		return dineroGanado;
	}
	/**
	 * @param dineroGanado the dineroGanado to set
	 */
	public void setDineroGanado(double dineroGanado) {
		this.dineroGanado = dineroGanado;
	}
	
	

}
