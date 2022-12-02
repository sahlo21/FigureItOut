package FigureItOut.controller;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import FigureItOut.Aplicacion;
import FigureItOut.model.Jugador;
import FigureItOut.model.Partida;
import FigureItOut.model.Pregunta;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class PreguntaController  implements Initializable  {
    private ModelFactoryController modelFactoryController; 
    Jugador jugadorLogueado;
    Pregunta preguntaAux;
    Integer STARTTIME =59;

    ArrayList<Jugador> listaJugdoresAux = new ArrayList<>();

    IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
    @FXML
    private Label timerLabel;
    boolean flag=false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button respuestaA;

    @FXML
    private Button respuestaC;

    @FXML
    private Button respuestaB;

    @FXML
    private Button respuestaD;

    @FXML
    private Text labelPregunta;

    @FXML
    private Label labelSaldo;

    @FXML
    private Label labelNombre;
    Aplicacion aplicacion;

    boolean flagAux=false;

    public void aaaa() {
        Timeline timeline = new Timeline();;


        timerLabel.textProperty().bind(timeSeconds.asString());


        timeSeconds.set(STARTTIME);
        //        Timeline timeline2 = new Timeline(new KeyFrame(
        //                Duration.millis(5000),
        //                ae -> aplicacion.showTiempoExpirado(false)));
        //        timeline2.play();

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(STARTTIME+1),
                        new KeyValue(timeSeconds, 0)));

        timeline.playFromStart(); 


        //        TimeOut timeout = new TimeOut();
        //        timeout.start(0, 1000);

        //
        //        //        timeline.se
//        timeline.setOnFinished(
//                event -> {
//
//                    aplicacion.showTiempoExpirado(false);
//
//
//
//
//
//                });


    }



    class TimeOut {

        private int hour = 0;
        private int minute = 0;
        private int second = 11;
        private Timer timer;
        private boolean isTimerRunning=false;
        private Display display;

        public TimeOut() {
            timer = new Timer();
            display = new Display();
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                isTimerRunning = true;
                if(second > 0) {
                    second--;
                } else {
                    second = 59;
                    if(minute > 0) minute--;
                    else {
                        minute = 59;
                        if(hour > 0) hour--;
                        // si segundo = 0, minuto = 0 y hora = 0,
                        // cancelamos el timer
                        else {
                            isTimerRunning = false;
                            timer.cancel();
                            timer.purge();
                            aplicacion.showTiempoExpirado(false);

                        }
                    }
                }
                if(isTimerRunning){
                    display.printTime(hour, minute, second);
                }
            }


        }; // fin timertask

        public void start(int timeout, int interval) {
            timer.schedule(task, timeout, interval);
        }

    }
    class Display {

        public void printTime(int hour, int minute, int second) {
            String fullHour = "";

            fullHour += (hour > 9) ? ":" + hour : "0" + hour;
            fullHour += (minute > 9) ? ":" + minute : ":0" + minute;
            fullHour += (second > 9) ? ":" + second : ":0" + second;

            System.out.println(fullHour);
        }
    }


    private void resolucion() {
       


            String answer=String.valueOf(preguntaAux.getRespuesta());


            respuestaA.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String click="";
                    click="a";
                    if (click.equals(answer)) {
                        modelFactoryController.getJugadorLogueado().setSaldo(modelFactoryController.getJugadorLogueado().getSaldo()+10000);

                        aplicacion.showResultado(true);

                    }else{
                        modelFactoryController.getJugadorLogueado().setSaldo(modelFactoryController.getJugadorLogueado().getSaldo()-10000);

                        aplicacion.showResultadoI(false,-1,-1);

                    }   
                }
            });
            respuestaB.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String click="";
                    click="b";
                    if (click.equals(answer)) {
                        modelFactoryController.getJugadorLogueado().setSaldo(modelFactoryController.getJugadorLogueado().getSaldo()+10000);
                        aplicacion.showResultado(true);

                    }else{
                        modelFactoryController.getJugadorLogueado().setSaldo(modelFactoryController.getJugadorLogueado().getSaldo()-10000);

                        aplicacion.showResultadoI(false,-1,-1);

                    }   
                }
            });
            respuestaC.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String click="";
                    click="c";
                    if (click.equals(answer)) {
                        modelFactoryController.getJugadorLogueado().setSaldo(modelFactoryController.getJugadorLogueado().getSaldo()+10000);

                        aplicacion.showResultado(true);
                    }else{
                        modelFactoryController.getJugadorLogueado().setSaldo(modelFactoryController.getJugadorLogueado().getSaldo()-10000);

                        aplicacion.showResultadoI(false,-1,-1);

                    }      

                }

            });
            respuestaD.setOnAction(new EventHandler<ActionEvent>() {
                String click="";
                @Override
                public void handle(ActionEvent event) {
                    click="d";
                    if (click.equals(answer)) {
                        modelFactoryController.getJugadorLogueado().setSaldo(modelFactoryController.getJugadorLogueado().getSaldo()+10000);

                        aplicacion.showResultado(true);
                    }else{
                        modelFactoryController.getJugadorLogueado().setSaldo(modelFactoryController.getJugadorLogueado().getSaldo()-10000);

                        aplicacion.showResultadoI(false,-1,-1);

                    }   
                }
            });

            if (!(listaJugdoresAux.contains(modelFactoryController.getJugadorLogueado()))) {
                listaJugdoresAux.add(modelFactoryController.getJugadorLogueado());
                
            }
            try {
                Persistencia.guardarJugadores(listaJugdoresAux);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }




    }
    public void god(){

        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final Runnable runnable = new Runnable() {
            int countdownStarter = 5;

            public void run() {
                System.out.println(countdownStarter);
                countdownStarter--;

                if (countdownStarter < 0) {
                    flag=true;

                    System.out.println("Timer Over!");
                    scheduler.shutdown();
                }
            }

        };

        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);


    }
    public void initAttributtes(Jugador jugadorLogueado, Pregunta preguntaAux) {
        this.jugadorLogueado = jugadorLogueado;
        this.preguntaAux = preguntaAux;


        labelNombre.setText(labelNombre.getText()+jugadorLogueado.getNombre());
        labelSaldo.setText(labelSaldo.getText()+String.valueOf(jugadorLogueado.getSaldo()));
        labelPregunta.setText(String.valueOf(preguntaAux.getInterrogante()));
        respuestaA.setText(preguntaAux.getOpcionA());
        respuestaB.setText(preguntaAux.getOpcionB());
        respuestaC.setText(preguntaAux.getOpcionC());
        respuestaD.setText(preguntaAux.getOpcionD());


        resolucion();
        //                aaaa();

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
        aaaa();


        //god();
    }
    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion=aplicacion;

    }
}






