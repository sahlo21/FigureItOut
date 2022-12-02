package FigureItOut.controller;



import java.net.URL;
import java.util.ResourceBundle;

import FigureItOut.Aplicacion;
import FigureItOut.model.Jugador;
import FigureItOut.model.Pregunta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ResultadoIncorrectoController implements Initializable  {
    private ModelFactoryController modelFactoryController; 
    Jugador jugadorLogueado;
    Pregunta preguntaAux;
    Aplicacion aplicacion;

   
    boolean flag=false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelGanado;

    @FXML
    private Label labelSaldo;

    @FXML
    private Label labelNombre;
    @FXML
    private Label labelRespuesta;
    

   
    



    @FXML
    void abandonarEvent(ActionEvent event) {
        aplicacion.showHome();        

    }


    @FXML
    void continuarEvent(ActionEvent event) {
        System.out.println("ACERTADAS INCOEE R"+modelFactoryController.getAcertadas());

        aplicacion.showPregunta();
    }
    public void initAttributtes(Jugador jugadorLogueado, boolean flag, double apuesta, int numAcertadas) {
        this.jugadorLogueado = jugadorLogueado;
        labelNombre.setText(labelNombre.getText()+jugadorLogueado.getNombre());
        labelSaldo.setText(labelSaldo.getText()+String.valueOf(jugadorLogueado.getSaldo()));
        
        System.out.println("ACERTADAS INCOEE R"+modelFactoryController.getAcertadas());


    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modelFactoryController = ModelFactoryController.getInstance();

    }
  
    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion=aplicacion;
        
    }
  
}
