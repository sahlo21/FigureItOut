package FigureItOut.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;

import FigureItOut.Aplicacion;
import FigureItOut.model.Jugador;
import FigureItOut.model.Partida;
import FigureItOut.model.Pregunta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModoClasicoController implements Initializable  {
    private ModelFactoryController modelFactoryController; 
    Jugador jugadorLogueado;
    boolean flag=false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelSaldo;

    @FXML
    private Label labelNombre;
    Aplicacion aplicacion;





    @FXML
    void modoClasicoEvent(ActionEvent event) {
        iniciar();
    }

    private void iniciar() {

        int nivel= 0;
        Partida partida= new Partida(0, nivel);

        aplicacion.showPregunta();
        //        try {
        //            // Cargo la vista
        //            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PreguntaView.fxml"));
        //
        //            // Cargo la ventana
        //            Parent root = loader.load();
        //
        //            // Cojo el controlador
        //            PreguntaController controlador = loader.getController();
        //            controlador.initAttributtes(modelFactoryController.getJugadorLogueado(), preguntaAux, flag);
        //            
        //
        //            // Creo el Scene
        //            Scene scene = new Scene(root);
        //            Stage stage = new Stage();
        //            stage.initModality(Modality.APPLICATION_MODAL);
        //            stage.setScene(scene);
        //            stage.setTitle("Figure it out");
        ////            stage.getIcons().add(new Image(getClass().getResourceAsStream("../resources/iconMarketplace.png")));
        //
        //            stage.show();
        //            if (modelFactoryController.isFlagPregunta()) {
        //                stage.close();
        //            }
        //            
        //
        //        } catch (IOException ex) {
        //            Alert alert = new Alert(Alert.AlertType.ERROR);
        //            alert.setHeaderText(null);
        //            alert.setTitle("Error");
        //            alert.setContentText(ex.getMessage());
        //            alert.showAndWait();
        //        }



    }





    public void initAttributtes(Jugador jugadorLogueado) {
        this.jugadorLogueado = jugadorLogueado;
        labelNombre.setText(labelNombre.getText()+jugadorLogueado.getNombre());
        labelSaldo.setText(labelSaldo.getText()+String.valueOf(jugadorLogueado.getSaldo()));

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


    /**
     * @return the flag
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modelFactoryController = ModelFactoryController.getInstance();

    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion=aplicacion;

    }
}
