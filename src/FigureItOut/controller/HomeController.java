package FigureItOut.controller;



import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import FigureItOut.Aplicacion;
import FigureItOut.model.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomeController implements Initializable  {
    private ModelFactoryController modelFactoryController; 
    Jugador jugadorLogueado;
    private MediaPlayer mediaPlayer;
    ArrayList<Jugador> listaJugdoresAux = new ArrayList<>();

    private boolean running = true;
    @FXML
    private ResourceBundle resources;
    Aplicacion aplicacion;
    @FXML
    private URL location;
    
    private static Thread thread;
    @FXML
    private Label labelNombre;

    @FXML
    private TableColumn<Jugador, String> puntaje;

    @FXML
    private TableColumn<Jugador, String> jugador;

    @FXML
    private Label labelSaldo;

    @FXML
    private TableView<Jugador> tableJugadores;

    @FXML
    void modoCasinoEvent(ActionEvent event) {
        if (modelFactoryController.my_list.size()!=9) {
            modelFactoryController.inicializarPreguntas();

        }

        aplicacion.showApuesta();
       
    }
    @FXML
    void cerrarSesion(ActionEvent event) {
        cerrarSesionAction();
        
    }


    private void cerrarSesionAction() {
        if (!(listaJugdoresAux.contains(modelFactoryController.getJugadorLogueado()))) {
            listaJugdoresAux.add(modelFactoryController.getJugadorLogueado());
            
        }
        aplicacion.showLogin();   
        try {
            Persistencia.guardarJugadores(listaJugdoresAux);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @FXML
    void modoClasicoEvent(ActionEvent event) {
        if (modelFactoryController.my_list.size()!=9) {
            modelFactoryController.inicializarPreguntas();

        }
        aplicacion.showModoClasico();
//        try {
//            // Cargo la vista
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ModoClasico.fxml"));
//
//            // Cargo la ventana
//            Parent root = loader.load();
//
//            // Cojo el controlador
//            ModoClasicoController controlador = loader.getController();
//            controlador.initAttributtes(modelFactoryController.getJugadorLogueado());
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
//            stage.showAndWait();
//
//        } catch (IOException ex) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText(null);
//            alert.setTitle("Error");
//            alert.setContentText(ex.getMessage());
//            alert.showAndWait();
//        }
//        
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modelFactoryController = ModelFactoryController.getInstance();
      
        
        if (thread == null) {

            thread = new Thread() {
                @Override
                public void run() {
                    if (running) {
                        String musicFile = getClass().getResource("../resources/videoplayback.mp3").toExternalForm();
                        Media sound = new Media(musicFile);
                        mediaPlayer = new MediaPlayer(sound);
                        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                        mediaPlayer.play();
                    }
                }
            };
            thread.start();
            /*task = new Task() {
                @Override
                protected Object call() throws Exception {
                    return null;
                }
            };
            thread = new Thread(task);
            thread.start();*/

        }

    }
    ObservableList<Jugador> listaJugadoresData = FXCollections.observableArrayList();


    public ObservableList<Jugador> getListaVendedorData() {

        listaJugadoresData.addAll(modelFactoryController.obtenerVendedor());

        return listaJugadoresData;
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
      
    }

    public void initAttributtes(Jugador jugadorLogueado) {
        this.jugadorLogueado = jugadorLogueado;
        jugador.setCellValueFactory(new PropertyValueFactory<Jugador, String>("nombre"));
        puntaje.setCellValueFactory(new PropertyValueFactory<Jugador, String>("puntaje"));

        labelNombre.setText(labelNombre.getText()+jugadorLogueado.getNombre());
        labelSaldo.setText(labelSaldo.getText()+String.valueOf(jugadorLogueado.getSaldo()));
        tableJugadores.getItems().clear();
        tableJugadores.setItems(getListaVendedorData());



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
}

