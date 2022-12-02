package FigureItOut.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import FigureItOut.Aplicacion;
import FigureItOut.model.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginController implements Initializable  {

    Aplicacion aplicacion;
    private ModelFactoryController modelFactoryController; 





    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtUsuarioLogin;

    @FXML
    private PasswordField txtContrasenaLogin;

    @FXML
    void bb97a1(ActionEvent event) {

    }



    @FXML
    void inicioSesionEvent(ActionEvent event) {
        if (txtUsuarioLogin.getText().toString().equals("")||txtContrasenaLogin.getText().toString().equals("")) {
            mostrarMensajeError("Debe ingresar la informacion solicitada");
        }else{
            inicioSesionAction();
        }
    }
    private void inicioSesionAction() {
//        
//        if (modelFactoryController.obtenerVendedor()==null) {
//for (Jugador iterable_element : modelFactoryController.listJugAux) {
//    modelFactoryController.crearJugador(iterable_element.getNombre(), iterable_element.getUsuario(), iterable_element.getContrasena());
//}      }
        
        String usuario = txtUsuarioLogin.getText().toString();
        String contrasena = txtContrasenaLogin.getText().toString();


        Jugador jugadorObtenido=null;
        jugadorObtenido = modelFactoryController.ingreso(usuario, contrasena);
        System.out.println("obtenid"+jugadorObtenido);

        if (jugadorObtenido!=null) {


            Jugador jugador = (Jugador) jugadorObtenido;
            mostrarMensajeInformacion("Bienvenido: "+jugador.getNombre());
            modelFactoryController.setJugadorLogueado(jugador);
            aplicacion.showHome();
//            try {
//                // Cargo la vista
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/HomeView.fxml"));
//
//                // Cargo la ventana
//                Parent root = loader.load();
//
//                // Cojo el controlador
//                HomeController controlador = loader.getController();
//                controlador.initAttributtes(modelFactoryController.getJugadorLogueado());
//                
//
//                // Creo el Scene
//                Scene scene = new Scene(root);
//                Stage stage = new Stage();
//                stage.initModality(Modality.APPLICATION_MODAL);
//                stage.setScene(scene);
//                stage.setTitle("Registro");
////                stage.getIcons().add(new Image(getClass().getResourceAsStream("../resources/iconMarketplace.png")));
//
//                stage.showAndWait();
//
//            } catch (IOException ex) {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setHeaderText(null);
//                alert.setTitle("Error");
//                alert.setContentText(ex.getMessage());
//                alert.showAndWait();
//            }


        } else {
            mostrarMensajeError("Ha ingresado mal el usuario y/o contraseña.");   
        }



    }




    @FXML
    void registroEvent(ActionEvent event) {
//        try {
//            // Cargo la vista
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/RegistroView.fxml"));
//
//            // Cargo la ventana
//            Parent root = loader.load();
//
//            // Cojo el controlador
//            RegistroController controlador = loader.getController();
//
//            
//
//            // Creo el Scene
//            Scene scene = new Scene(root);
//            Stage stage = new Stage();
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.setScene(scene);
//            stage.setTitle("Registro");
////            stage.getIcons().add(new Image(getClass().getResourceAsStream("../resources/iconMarketplace.png")));
//
//            stage.showAndWait();
//
//        } catch (IOException ex) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText(null);
//            alert.setTitle("Error");
//            alert.setContentText(ex.getMessage());
//            alert.showAndWait();
//        }
        aplicacion.showRegistro();
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
        this.aplicacion=aplicacion;


    }
}
