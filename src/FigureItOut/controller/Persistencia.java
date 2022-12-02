package FigureItOut.controller;

import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import FigureItOut.model.Jugador;



public class Persistencia {
	/**
	 * Kevin
	 */
	public static final String RUTA_ARCHIVO_JUGADORES= "jugadores.txt";
	

//	/**
//	 * Didier
//	 */
//	public static final String RUTA_ARCHIVO_VENDEDORES = "C:\\Users\\Daniel Guiral\\Documents\\GitHub\\Marketplace\\td\\persistencia\\archivos\\archivoVendedores.txt";
//	public static final String RUTA_ARCHIVO_PRODUCTOS = "C:\\Users\\Daniel Guiral\\Documents\\GitHub\\Marketplace\\td\\persistencia\\archivos\\archivoProductos.txt";
//	public static final String RUTA_ARCHIVO_COMENTARIOS = "C:\\Users\\Daniel Guiral\\Documents\\GitHub\\Marketplace\\td\\persistencia\\archivos\\archivoComentarios.txt";
//	public static final String RUTA_ARCHIVO_LOG_EXCEPTIONS = "C:\\Users\\Daniel Guiral\\Documents\\GitHub\\Marketplace\\td\\persistencia\\log\\exceptionsMarketplaceLog.txt";
//	public static final String RUTA_ARCHIVO_LOG_MARKETPLACE = "C:\\Users\\Daniel Guiral\\Documents\\GitHub\\Marketplace\\td\\persistencia\\log\\marketplaceLog.txt";
//	public static final String RUTA_ARCHIVO_LOG_LOGIN = "C:\\Users\\Daniel Guiral\\Documents\\GitHub\\Marketplace\\td\\persistencia\\log\\registroLogin.txt";

	/**
	 * Agregue una ruta dentro del proyecto para poder mirar como se comportaba el
	 * archivo
	 */
	// public static final String RUTA_ARCHIVO_MODELO_MARKETPLACE_BINARIO =
	// "C:\\Users\\Daniel
	// Guiral\\Documents\\GitHub\\Marketplace\\td\\persistencia\\model.dat";


	// public static final String RUTA_ARCHIVO_OBJETOS =
	// "src/resources/archivoObjetos.txt";
	// public static final String RUTA_ARCHIVO_MODELO_BANCO_BINARIO =
	// "src/resources/model.dat";
	// public static final String RUTA_ARCHIVO_MODELO_BANCO_XML =
	// "src/resources/model.xml";
	// public static void cargarDatosArchivos(Banco banco) throws
	// FileNotFoundException, IOException {
	//
	//
	// //cargar archivo de clientes
	// ArrayList<Cliente> clientesCargados = cargarClientes();
	//
	// if(clientesCargados.size() > 0)
	// banco.getListaClientes().addAll(clientesCargados);
	//
	//
	// //cargar archivos empleados
	// ArrayList<Empleado> empleadosCargados = cargarEmpleados();
	//
	// if(empleadosCargados.size() > 0)
	// banco.getListaEmpleados().addAll(empleadosCargados);
	//
	// //cargar archivo objetos
	//
	// //cargar archivo empleados
	//
	// //cargar archivo prestamo
	//
	// }
	//
	//
	//
	//
	//
	// /**
	// * Guarda en un archivo de texto todos la informaci�n de las personas
	// almacenadas en el ArrayList
	// * @param objetos
	// * @param ruta
	// * @throws IOException
	// */
	// public static void guardarClientes(ArrayList<Cliente> listaClientes) throws
	// IOException {
	// // TODO Auto-generated method stub
	// String contenido = "";
	//
	// for(Cliente cliente:listaClientes)
	// {
	// contenido+=
	// cliente.getNombre()+","+cliente.getApellido()+","+cliente.getCedula()+","+cliente.getDireccion()
	// +","+cliente.getCorreo()+","+cliente.getFechaNacimiento()+","+cliente.getTelefono()+"\n";
	// }
	// ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contenido, false);
	//
	// }
	//
	//
	// public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados)
	// throws IOException {
	//
	// // TODO Auto-generated method stub
	// String contenido = "";
	//
	// for(Empleado empleado:listaEmpleados)
	// {
	// contenido+=
	// empleado.getNombre()+","+empleado.getApellido()+","+empleado.getCedula()+","+empleado.getFechaNacimiento()+"\n";
	// }
	// ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
	// }
	//
	//
	//
	//// ----------------------LOADS------------------------
	//
	// /**
	// *
	// * @param tipoPersona
	// * @param ruta
	// * @return un Arraylist de personas con los datos obtenidos del archivo de
	// texto indicado
	// * @throws FileNotFoundException
	// * @throws IOException
	// */
	// public static ArrayList<Cliente> cargarClientes() throws
	// FileNotFoundException, IOException
	// {
	// ArrayList<Cliente> clientes =new ArrayList<Cliente>();
	//
	// ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_CLIENTES);
	// String linea="";
	//
	// for (int i = 0; i < contenido.size(); i++)
	// {
	// linea = contenido.get(i);
	// Cliente cliente = new Cliente();
	// cliente.setNombre(linea.split(",")[0]);
	// cliente.setApellido(linea.split(",")[1]);
	// cliente.setCedula(linea.split(",")[2]);
	// cliente.setDireccion(linea.split(",")[3]);
	// cliente.setCorreo(linea.split(",")[4]);
	// cliente.setFechaNacimiento(linea.split(",")[5]);
	// cliente.setTelefono(linea.split(",")[6]);
	// clientes.add(cliente);
	// }
	// return clientes;
	// }
	//
	//
	//
	// private static ArrayList<Empleado> cargarEmpleados() throws IOException {
	//
	// ArrayList<Empleado> empleados =new ArrayList<Empleado>();
	//
	// ArrayList<String> contenido =
	// ArchivoUtil.leerArchivo(RUTA_ARCHIVO_EMPLEADOS);
	// String linea="";
	//
	// for (int i = 0; i < contenido.size(); i++)
	// {
	// linea = contenido.get(i);
	// Empleado empleado = new Empleado();
	// empleado.setNombre(linea.split(",")[0]);
	// empleado.setApellido(linea.split(",")[1]);
	// empleado.setCedula(linea.split(",")[2]);
	// empleado.setFechaNacimiento(linea.split(",")[3]);
	// empleados.add(empleado);
	// }
	// return empleados;
	// }
	//
	//
	//
	//


	/**
	 * Guarda en un archivo de texto todos la informaci�n de las personas
	 * almacenadas en el ArrayList
	 * 
	 * @param objetos
	 * @param ruta
	 * @throws IOException
	 */
	public static void guardarJugadores(ArrayList<Jugador> listaJugadores) throws IOException {
		// TODO Auto-generated method stub
		String contenido = "";
		
		System.out.println("lsita guardar vedne:" + listaJugadores);

		for (Jugador vendedor : listaJugadores) {
			contenido += vendedor.getNombre() + "@" + vendedor.getUsuario() + "@" + vendedor.getContrasena() + "@"
					+ vendedor.getSaldo()+ "\n" ;
			
			
		}
		
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_JUGADORES, contenido, false);
	
	}
	public static ArrayList<Jugador> cargarJugadores() throws FileNotFoundException, IOException {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_JUGADORES);
        String linea = "";

        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);
            Jugador jugador = new Jugador();
            jugador.setNombre(linea.split("@")[0]);
            jugador.setUsuario(linea.split("@")[1]);
            jugador.setContrasena(linea.split("@")[2]);
            jugador.setSaldo(Double.parseDouble(linea.split("@")[3]));

            jugadores.add(jugador);
        }
        return jugadores;
    }
	
	

}
