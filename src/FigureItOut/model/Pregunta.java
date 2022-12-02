package FigureItOut.model;

public class Pregunta {
    
	int nivelPregunta; 
	long tiempo;
	String interrogante;
	String opcionA ;
	String opcionB ;
	String opcionC;
	String opcionD ;
	char respuesta;
	/**
	 * @param nivelPregunta
	 * @param tiempo
	 * @param interrogante
	 * @param opcionA
	 * @param opcionB
	 * @param opcionC
	 * @param opcionD
	 * @param respuesta
	 */
	public Pregunta(int nivelPregunta, long tiempo, String interrogante, String opcionA, String opcionB, String opcionC,
			String opcionD, char respuesta) {
		super();
		this.nivelPregunta = nivelPregunta;
		this.tiempo = tiempo;
		this.interrogante = interrogante;
		this.opcionA = opcionA;
		this.opcionB = opcionB;
		this.opcionC = opcionC;
		this.opcionD = opcionD;
		this.respuesta = respuesta;
	}
	/**
	 * @return the nivelPregunta
	 */
	public int getNivelPregunta() {
		return nivelPregunta;
	}
	/**
	 * @param nivelPregunta the nivelPregunta to set
	 */
	public void setNivelPregunta(int nivelPregunta) {
		this.nivelPregunta = nivelPregunta;
	}
	/**
	 * @return the tiempo
	 */
	public long getTiempo() {
		return tiempo;
	}
	/**
	 * @param tiempo the tiempo to set
	 */
	public void setTiempo(long tiempo) {
		this.tiempo = tiempo;
	}
	/**
	 * @return the interrogante
	 */
	public String getInterrogante() {
		return interrogante;
	}
	/**
	 * @param interrogante the interrogante to set
	 */
	public void setInterrogante(String interrogante) {
		this.interrogante = interrogante;
	}
	/**
	 * @return the opcionA
	 */
	public String getOpcionA() {
		return opcionA;
	}
	/**
	 * @param opcionA the opcionA to set
	 */
	public void setOpcionA(String opcionA) {
		this.opcionA = opcionA;
	}
	/**
	 * @return the opcionB
	 */
	public String getOpcionB() {
		return opcionB;
	}
	/**
	 * @param opcionB the opcionB to set
	 */
	public void setOpcionB(String opcionB) {
		this.opcionB = opcionB;
	}
	/**
	 * @return the opcionC
	 */
	public String getOpcionC() {
		return opcionC;
	}
	/**
	 * @param opcionC the opcionC to set
	 */
	public void setOpcionC(String opcionC) {
		this.opcionC = opcionC;
	}
	/**
	 * @return the opcionD
	 */
	public String getOpcionD() {
		return opcionD;
	}
	/**
	 * @param opcionD the opcionD to set
	 */
	public void setOpcionD(String opcionD) {
		this.opcionD = opcionD;
	}
	/**
	 * @return the respuesta
	 */
	public char getRespuesta() {
		return respuesta;
	}
	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(char respuesta) {
		this.respuesta = respuesta;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pregunta [nivelPregunta=" + nivelPregunta + ", tiempo=" + tiempo + ", interrogante=" + interrogante
				+ ", opcionA=" + opcionA + ", opcionB=" + opcionB + ", opcionC=" + opcionC + ", opcionD=" + opcionD
				+ ", respuesta=" + respuesta + "]";
	}
	
	

}
