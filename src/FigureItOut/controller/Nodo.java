package FigureItOut.controller;

import FigureItOut.model.Jugador;

public class Nodo {

	private int indice;
	private Jugador jugador;
	private Nodo derecho, izquierdo;

	public Nodo(int indice, Jugador jugador) {
		this.indice = indice;
		this.jugador= jugador; 
		this.derecho = null;
		this.izquierdo = null;
	}

	public int getIndice() {
		return indice;
	}

	

	/**
	 * @return the jugador
	 */
	public Jugador getJugador() {
		return jugador;
	}

	public Nodo getDerecho() {
		return derecho;
	}

	public Nodo getIzquierdo() {
		return izquierdo;
	} 

	

	public void asignarPosicion(int indiceNuevoNod, Jugador jugador) {
		
		if (indiceNuevoNod < this.indice) {
			if (this.izquierdo == null) {
				this.izquierdo = new Nodo(indiceNuevoNod, jugador);
			} else {
				this.izquierdo.asignarPosicion(indiceNuevoNod, jugador);
			}
		}

		else {
			if (this.derecho == null) {
				this.derecho = new Nodo(indiceNuevoNod, jugador);
			} else {
				this.derecho.asignarPosicion(indiceNuevoNod, jugador);
			}
		}

	}
}
	