package FigureItOut.controller;

import java.net.URL;
import java.util.ResourceBundle;

import FigureItOut.Aplicacion;
import FigureItOut.model.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RegistroController implements Initializable {
    Aplicacion aplicacion;
    private ModelFactoryController modelFactoryController; 

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtUsuario;




    @FXML
    void registrarseEvent(ActionEvent event) {
        if (txtNombre.getText().toString().equals("")||txtNombre.getText().toString().equals("")||txtContrasena.getText().toString().equals("")) {
            mostrarMensajeError("Debe ingresar la informacion solicitada");
        }else{
            registrarAction();
        }
       
    }



    private void registrarAction() {
        String nombre = txtNombre.getText().toString();
        String usuario = txtUsuario.getText().toString();
        String contrasenia = txtContrasena.getText().toString();
       

        if (datosValidoJugador(nombre, usuario, contrasenia) == true) {
          
            

                Jugador jugador = modelFactoryController.crearJugador(nombre, usuario, contrasenia);

                if (jugador != null) {

                   
                    limpiarCasillasJugador();
                    mostrarMensaje("Notificacion Jugador", null, "El Jugador se ha registrado con exito",
                            AlertType.INFORMATION);
                    
                    aplicacion.showLogin();

                } else {
                  
                   mostrarMensajeError("El vendedor: " + nombre + " ya se encuentra registrado");

                }
           
        }
        
    }

    private void limpiarCasillasJugador() {

        txtNombre.setText("");
        txtUsuario.setText("");
        txtContrasena.setText("");

    }
    private boolean datosValidoJugador(String nombre, String usuario, String contrasena) {

        String mensaje = "";

        if (nombre == null || nombre.equals(""))
            mensaje += "El nombre del vendedor es invalido \n";


        if (usuario == null || usuario.equals(""))
            mensaje += "El usuario del vendedor es invalido \n";

        if (contrasena == null || contrasena.equals(""))
            mensaje += "La contrasenia del vendedor es invalida \n";

        if (mensaje.equals("")) {
            return true;
        } else {
            mostrarMensaje("Notificacion jugador", "Datos invalidos", mensaje, AlertType.WARNING);
            return false;
        }
    }

    private void mostrarMensajeInformacion(String mensaje) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Informacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private void mostrarMensajeError(String mensaje) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Confirmacion");
        alert.setContentText(mensaje);
        alert.showAndWait();

    }
    private void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modelFactoryController = ModelFactoryController.getInstance();


    }



    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        
    }
}
