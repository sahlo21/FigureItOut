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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModoCasinoController implements Initializable  {
    private ModelFactoryController modelFactoryController; 
    Jugador jugadorLogueado;
    boolean flag=false;

 Aplicacion aplicacion;
  

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label labelRespuesta;

        @FXML
        private Label labelRespuesta1;

        @FXML
        private Label labelSaldo;

        @FXML
        private TextField txtValor;

        @FXML
        private TextField txtNumero;

        @FXML
        private Label labelNombre;

       


    


    @FXML
    void realizarApuesta(ActionEvent event) {
       iniciar();
    }
    private void iniciar() {
        double apuesta = Double.parseDouble(txtValor.getText().toString());
        int numAcertadas = Integer.parseInt(txtNumero.getText().toString());
        
        
        aplicacion.showPreguntaA(apuesta, numAcertadas);   
        
        System.out.println("ACERTADAS"+modelFactoryController.getAcertadas());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modelFactoryController = ModelFactoryController.getInstance();

    }
    public void initAttributtes(Jugador jugadorLogueado) {
        this.jugadorLogueado = jugadorLogueado;
        labelNombre.setText(labelNombre.getText()+jugadorLogueado.getNombre());
        labelSaldo.setText(labelSaldo.getText()+String.valueOf(jugadorLogueado.getSaldo()));

    }
    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion=aplicacion;

    }
}
