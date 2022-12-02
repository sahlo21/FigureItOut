package FigureItOut.model;

import java.util.ArrayList;
import java.util.Hashtable;

import FigureItOut.controller.ArbolBinario;


public class Juego {

    int CONT=0;

    ArrayList<Pregunta> listaPreguntas = new ArrayList<>();

    ArrayList<Jugador> listaJugdoresAux = new ArrayList<>();
    
    ArbolBinario arbolJugadores = new ArbolBinario();



    /**
     * 
     */
    public Juego() {
        super();
    }

    /**
     * @return the arbolJugadores
     */
    public ArbolBinario getArbolJugadores() {
        return arbolJugadores;
    }

    /**
     * @param arbolJugadores the arbolJugadores to set
     */
    public void setArbolJugadores(ArbolBinario arbolJugadores) {
        this.arbolJugadores = arbolJugadores;
    }

    /**


    /**
     * @return the listaPreguntas
     */
    public ArrayList<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    /**
     * @param listaPreguntas the listaPreguntas to set
     */
    public void setListaPreguntas(ArrayList<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }





    /**
     * @return the listaJugdoresAux
     */
    public ArrayList<Jugador> getListaJugdoresAux() {
        return listaJugdoresAux;
    }

    /**
     * @param listaJugdoresAux the listaJugdoresAux to set
     */
    public void setListaJugdoresAux(ArrayList<Jugador> listaJugdoresAux) {
        this.listaJugdoresAux = listaJugdoresAux;
    }

    public Jugador crearJugador(String nombre, String usuario, String contrasena) {
        Jugador jugador = null;
        jugador = buscarJugador(usuario);

        if(jugador == null){



            jugador = new Jugador(nombre,  usuario,  contrasena);


            jugador.setNombre(nombre);
            jugador.setUsuario(usuario);
            jugador.setContrasena(contrasena);



            getListaJugdoresAux().add(jugador);
            
            arbolJugadores.armarArbol(CONT++, jugador);
           
            return jugador;
        }else{
            return null;

        }
    }




    private Jugador buscarJugador(String name) {
        int bus=0;

        if ((arbolJugadores.dispararBusquedadRegistro(0, name))!=null) {
            System.out.println("hola nose"+arbolJugadores.dispararBusquedadRegistro(0, name));
            return arbolJugadores.dispararBusquedadRegistro(bus+1, name);

        }
        return null;
    }




}
