package FigureItOut.controller;

import java.util.LinkedList;

import FigureItOut.model.Jugador;


public class ArbolBinario {

	Nodo root;
	LinkedList<Nodo> cola = new LinkedList<Nodo>();

	public Nodo getRoot() {
		return root;
	}

	public void setRoot(Nodo root) {
		this.root = root;
	}

	public ArbolBinario() {
		this.root = null;
	}

	public void armarArbol(int indice, Jugador jugador) {

		// si no existe root o raiz
		if (this.root == null) {
			this.root = new Nodo(indice, jugador);
		} else {
			this.root.asignarPosicion(indice, jugador);
		}
	}

	// preorden raiz izq der
	public void preorden() {

		imprimirpreorden(this.root);
	}

	public void imprimirpreorden(Nodo nodo) {
		if (nodo == null) {
			System.out.print(" ");
		} else {
			System.out.print(" " + nodo.getIndice());
			imprimirpreorden(nodo.getIzquierdo());
			imprimirpreorden(nodo.getDerecho());
		}

	}

	// inorden izq raiz der
	public void inorden() {

		imprimirInorden(this.root);
	}

	public void imprimirInorden(Nodo nodo) {
		if (nodo == null) {
			System.out.print("");
		} else {

			imprimirpreorden(nodo.getIzquierdo());
			System.out.print(" " + nodo.getIndice());
			imprimirpreorden(nodo.getDerecho());
		}

	}

	// posorden izq der raiz
	public void posorden() {

		imprimirPosorden(this.root);
	}

	public void imprimirPosorden(Nodo nodo) {
		if (nodo == null) {
			System.out.print("");
		} else {
			imprimirpreorden(nodo.getIzquierdo());
			imprimirpreorden(nodo.getDerecho());
			System.out.print(" " + nodo.getIndice());
		}

	}

	// recorrido por niveles
	public void porNiveles() {
		
		recorrerPorNiveles(this.root);
	}

	public void recorrerPorNiveles(Nodo nodo_puntero){
	
		cola.offer(nodo_puntero); 
		
		if(root==null){
			System.out.println("no hay arbol");
		}
		else{
			while(cola.isEmpty()==false){
			
			System.out.print(" "+cola.peek().getIndice());
			nodo_puntero=cola.poll(); 
			
			if(nodo_puntero.getIzquierdo()!=null){
				cola.offer(nodo_puntero.getIzquierdo()); 
			}
			if(nodo_puntero.getDerecho()!=null){
				cola.offer(nodo_puntero.getDerecho()); 
		}
			}
	}
	
}
	public Jugador dispararBusquedad(int indice,  String user, String pass) {
	    return buscarNodoIngreso(this.root, indice, user, pass);
	}

	public Jugador buscarNodoIngreso(Nodo nodo,int indice,  String user, String pass) {

		if (nodo == null) {
		    return null;
		} else {

			if (nodo.getJugador().getUsuario().equals(user) && nodo.getJugador().getContrasena().equals(pass)) {
				return nodo.getJugador();
			} else {
				
				
			    return buscarNodoIngreso(nodo.getDerecho(),indice+1, user, pass);
				
			}

		}
	}
	public Jugador dispararBusquedadRegistro(int indice,  String user) {
	    return buscarNodoRegistro(this.root, indice, user);
    }
	public Jugador buscarNodoRegistro(Nodo nodo,int indice,  String user) {

        if (nodo == null) {
        } else {

            if (nodo.getJugador().getUsuario().equals(user) ) {
                System.out.print(nodo.getIndice() + "---" + nodo.getJugador().getNombre());
                return nodo.getJugador();
            } else {
                
                
                buscarNodoRegistro(nodo.getDerecho(),indice+1, user);
                
            }

        }
        return null;

    }
}