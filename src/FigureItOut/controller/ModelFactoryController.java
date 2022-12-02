package FigureItOut.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.jws.WebParam.Mode;
import javax.swing.JOptionPane;

import FigureItOut.Aplicacion;
import FigureItOut.model.Juego;
import FigureItOut.model.Jugador;
import FigureItOut.model.Pregunta;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;




public class ModelFactoryController {


    Juego juego= new Juego();
    Hashtable<Integer, Pregunta> tablePreguntas;
    ArrayList<Integer> my_list ;
    Jugador jugadorLogueado;
    boolean flagPregunta=false;
    Pregunta preguntaActual;
    private int acertadas;
    Aplicacion aplicacion;

    // ------------------------------ Singleton0
    // ------------------------------------------------5
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aquï¿½ al ser protected0
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Mï¿½todo para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
//        try {
//            Persistencia.cargarJugadores();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        inicializarPreguntas();
    }


    /**
     * @return the juego
     */
    public Juego getJuego() {
        return juego;
    }

    /**
     * @param juego the juego to set
     */
    public void setJuego(Juego juego) {
        this.juego = juego;
    }




    /**
     * @return the acertadas
     */
    public int getAcertadas() {
        return acertadas;
    }

    /**
     * @param acertadas the acertadas to set
     */
    public void setAcertadas(int acertadas) {
        this.acertadas = acertadas;
    }


    public Jugador crearJugador(String nombre, String usuario, String contrasenia) {

        Jugador jugador = null;

        jugador = juego.crearJugador(nombre, usuario, contrasenia);

        return jugador;

    }




    //    public Jugador ingreso(String usuario, String contrasena) {
    //        Jugador user = null;
    //        listaJugadores.clear();
    //        listaJugadores.addAll(obtenerJugador());
    //
    //        for (Jugador jug : listaJugadores) {
    //            if (usuario.equals(jug.getUsuario()) && contrasena.equals(jug.getContrasena())) {
    //
    //                return jug;
    //            }
    //        }
    //
    //        return user;
    //    }
    //
    //    public ArrayList<Jugador> obtenerJugador() {
    //
    //        return this.juego.getListaJugadores();
    //
    //    }
    //   
    public Jugador ingreso(String usuario, String contrasena) {
        Jugador user = null;
        ArbolBinario arbolJugadores =this.juego.getArbolJugadores();

        if ((arbolJugadores.dispararBusquedad(0, usuario, contrasena))!=null) {
            System.out.println("hola modef"+arbolJugadores.dispararBusquedad(0, usuario, contrasena));
            return arbolJugadores.dispararBusquedad(0, usuario, contrasena);

        }



        return user;
    }
    public ArrayList<Jugador> obtenerVendedor() {
        for (Jugador integer : juego.getListaJugdoresAux()) {
            System.out.println(integer.getNombre());
        }

        return this.juego.getListaJugdoresAux();

    }

    public void inicializarPreguntas(){  
        tablePreguntas=new Hashtable<Integer, Pregunta>();
        my_list = new ArrayList<Integer>();
        Pregunta pregunta= new Pregunta(1, 1000, "¿Cuál es la cordillera más extensa del mundo?", "Cordillera de Nahuelbuta", "Coordillera de la Sierra", "Coordillera de la Costa","Coordillera de los Andes",'d');
        tablePreguntas.put(1, pregunta);

        pregunta= new Pregunta(1, 1000, "¿Cual de estos animales no es un mamifero?", "Delfin", "Ocelote", "Gallina","Ballena",'c');
        tablePreguntas.put(2, pregunta);

        pregunta= new Pregunta(1, 1000, "La sal común está formada por dos elementos, ¿cuáles son?", "Sodio y potasio", "Sodio y cloro", "Potasio y cloro","Ninguna de las anteriores",'b');
        tablePreguntas.put(3, pregunta);

        pregunta= new Pregunta(1, 1000, "¿En qué periodo de la prehistoria fue descubierto el fuego?", "Paleolitico", "Neolitico", "Mesolitico","Edad de piedra",'a');
        tablePreguntas.put(4, pregunta);

        pregunta= new Pregunta(1, 1000, "¿Cuál fue el primer país en aprobar el sufragio femenino?", "Nueva Zelanda", "Chile", "Suiza","Colombia",'a');
        tablePreguntas.put(5, pregunta);

        pregunta= new Pregunta(1, 1000, " ¿En qué año llegó el hombre a la Luna?", "1959", "1990", "1969","1970",'c');
        tablePreguntas.put(6, pregunta);

        pregunta= new Pregunta(1, 1000, "¿En qué año tuvo lugar el genocidio de Ruanda?", "1922", "1952", "1986","1994",'d');
        tablePreguntas.put(7, pregunta);

        pregunta= new Pregunta(1, 1000, "¿En qué año se disolvió la Unión Soviética?", "1945", "1991", "1995","1992",'b');

        tablePreguntas.put(8, pregunta);
        pregunta= new Pregunta(1, 1000, "¿Cuál es el río más caudaloso del mundo?", "Nilo", "Amazonas", "Quindio","Rio verde",'b');

        tablePreguntas.put(9, pregunta);
        pregunta= new Pregunta(1, 1000, "¿Cuál es el monte más alto del mundo?", "Peñas blancas", "Monte Yozu", "Monte Everest","Ninguna de las anteriores",'c');

        tablePreguntas.put(10, pregunta);
        pregunta= new Pregunta(1, 1000, "¿Cuál es la lengua más hablada del mundo?", "Español", "Ingles", "Mandarín","Chino",'c');

        tablePreguntas.put(11, pregunta);
        pregunta= new Pregunta(1, 1000, " ¿Dónde podemos encontrar la Casa Rosada?", "Francia", "USA", "Argentina","Paraguay",'c');

        tablePreguntas.put(12, pregunta);
        pregunta= new Pregunta(1, 1000, "¿Cuál es el país de mayor tamaño del mundo?", "China", "Canada", "Groelandia","Rusia",'d');

        tablePreguntas.put(13, pregunta);
        pregunta= new Pregunta(1, 1000, "¿Cuál es la capital de Nueva Zelanda?", "Sidney", "Auckland", "Vancouver","Maori",'b');

        tablePreguntas.put(14, pregunta);
        pregunta= new Pregunta(1, 1000, " ¿Cuál es la capital de Filipinas?", "Manila", "Philips", "Ulan","Vols",'a');

        tablePreguntas.put(15, pregunta);
        pregunta= new Pregunta(1, 1000, "¿En qué país se habla mayoritariamente el idioma tagálog", "Tailandia", "Filipinas", "Groelandia","Islandia",'b');

        tablePreguntas.put(16, pregunta);
        pregunta= new Pregunta(1, 1000, "¿Cuál es la ciudad más poblada de África?", "El cairo", "Mangalá", "Congo","Uira",'a');

        tablePreguntas.put(17, pregunta);
        


      


        // adding elements
        my_list.add(0);
        my_list.add(1);
        my_list.add(2);
        my_list.add(3);
        my_list.add(4);
        my_list.add(5);
        my_list.add(6);
        my_list.add(7);
        my_list.add(8);
        my_list.add(9);
        my_list.add(10);
        my_list.add(11);
        my_list.add(12);
        my_list.add(13);
        my_list.add(14);
        my_list.add(15);
        my_list.add(16);
        my_list.add(17);

    }

    public Pregunta obtenerPregunta() {



        int numR=(int) ((Math.random() * ((my_list.size()-1 - 1) + 1)) + 1);

        Pregunta prg=tablePreguntas.get(my_list.get(numR));
        my_list.remove(numR);

        if (my_list.size()==1) {
            mostrarMensajeError("Se acabaron las preguntas JAHSDJASH"); 
        }
            return prg;
        }


        /**
         * @return the my_list
         */
        public ArrayList<Integer> getMy_list() {
            return my_list;
        }
        private void mostrarMensajeError(String mensaje) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ALERTA");
            alert.setContentText(mensaje);
            alert.show();

        }
        /**
         * @param my_list the my_list to set
         */
        public void setMy_list(ArrayList<Integer> my_list) {
            this.my_list = my_list;
        }

        /**
         * @return the tablePreguntas
         */
        public Hashtable<Integer, Pregunta> getTablePreguntas() {
            return tablePreguntas;
        }

        /**
         * @param tablePreguntas the tablePreguntas to set
         */
        public void setTablePreguntas(Hashtable<Integer, Pregunta> tablePreguntas) {
            this.tablePreguntas = tablePreguntas;
        }

        /**
         * @return the preguntaActual
         */
        public Pregunta getPreguntaActual() {
            return preguntaActual;
        }

        /**
         * @param preguntaActual the preguntaActual to set
         */
        public void setPreguntaActual(Pregunta preguntaActual) {
            this.preguntaActual = preguntaActual;
        }

        /**
         * @return the jugadorLogueado
         */
        public Jugador getJugadorLogueado() {
            return jugadorLogueado;
        }

        /**
         * @param jugadorLogueado the jugadorLogueado to set
         */
        public void setJugadorLogueado(Jugador jugadorLogueado) {
            this.jugadorLogueado = jugadorLogueado;
        }


    }
