package FigureItOut.model;

import java.util.ArrayList;


public class Jugador {

	String nombre;
	double saldo;
	String puntaje;
	String usuario;
	String contrasena;
	
	ArrayList<Comodin> listaComodines = new ArrayList<>();

	/**
	 * @param nombre
	 * @param saldo
	 * @param usuario
	 * @param contrasena
	 */
	public Jugador(String nombre, String usuario, String contrasena) {
		super();
		this.nombre = nombre;
		this.saldo = 0;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.puntaje="0";
	}
	public Jugador() {
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
     * @return the puntaje
     */
    public String getPuntaje() {
        return puntaje;
    }
    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }
    /**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * @return the listaComodines
	 */
	public ArrayList<Comodin> getListaComodines() {
		return listaComodines;
	}

	/**
	 * @param listaComodines the listaComodines to set
	 */
	public void setListaComodines(ArrayList<Comodin> listaComodines) {
		this.listaComodines = listaComodines;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", saldo=" + saldo + ", usuario=" + usuario + ", contrasena=" + contrasena
				+ ", listaComodines=" + listaComodines + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contrasena == null) ? 0 : contrasena.hashCode());
		result = prime * result + ((listaComodines == null) ? 0 : listaComodines.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (contrasena == null) {
			if (other.contrasena != null)
				return false;
		} else if (!contrasena.equals(other.contrasena))
			return false;
		if (listaComodines == null) {
			if (other.listaComodines != null)
				return false;
		} else if (!listaComodines.equals(other.listaComodines))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
	
	

}
