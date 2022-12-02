package FigureItOut.model;

public class Partida {
	int numero;
	int nivel;
    /**
     * @param i
     * @param nivel2
     */
    public Partida(int i, int nivel) {
        super();
        this.numero = i;
        this.nivel = nivel;
    }
    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }
    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
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
    
}
