package FigureItOut;

import java.io.IOException;

import FigureItOut.controller.GanadorController;
import FigureItOut.controller.HomeController;
import FigureItOut.controller.LoginController;
import FigureItOut.controller.ModelFactoryController;
import FigureItOut.controller.ModoCasinoController;
import FigureItOut.controller.ModoClasicoController;
import FigureItOut.controller.PreguntaController;
import FigureItOut.controller.PreguntaControllerA;
import FigureItOut.controller.RegistroController;
import FigureItOut.controller.ResultadoController;
import FigureItOut.controller.ResultadoControllerA;
import FigureItOut.controller.ResultadoIncorrectoController;
import FigureItOut.model.Pregunta;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Aplicacion extends Application {
    private Stage primaryStage;

    LoginController logIn;

    Pregunta pregunta;
    ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();



    @Override
    public void start(Stage primaryStage) {

        try {
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("FigureItOut");
            showLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * carga la vista del loggin
     */
    public void showLogin() {


        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("view/LoginView.fxml"));

            BorderPane rootLayout = (BorderPane) loader.load();
            logIn = loader.getController();
            logIn.setAplicacion(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Inicio de sesion");
            //			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("resources/iconMarketplace.png")));

            /*
             * "C://Users//kssm1//OneDrive//Documentos//GitHub//Marketplace//info//iconMarketplace.png
             * ../../../../../../../../../info/iconMarketplace.png
             */

            primaryStage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void showRegistro() {


        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("view/RegistroView.fxml"));

            BorderPane rootLayout = (BorderPane) loader.load();
            RegistroController controlador = loader.getController();
            controlador.setAplicacion(this);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Registro");
            //          primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("resources/iconMarketplace.png")));

            /*
             * "C://Users//kssm1//OneDrive//Documentos//GitHub//Marketplace//info//iconMarketplace.png
             * ../../../../../../../../../info/iconMarketplace.png
             */

            primaryStage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    int CONT=0;
    public void showHome() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("view/HomeView.fxml"));

            BorderPane rootLayout = (BorderPane) loader.load();
            HomeController controller = loader.getController();
            controller.setAplicacion(this);
            controller.initAttributtes(modelFactoryController.getJugadorLogueado());


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Home");

            primaryStage.show();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void showPregunta() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("view/PreguntaView.fxml"));

            BorderPane rootLayout = (BorderPane) loader.load();
            PreguntaController controller = loader.getController();
            controller.setAplicacion(this);
            pregunta= modelFactoryController.obtenerPregunta();
            controller.initAttributtes(modelFactoryController.getJugadorLogueado(), pregunta);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Figure it out");

            primaryStage.show();



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void showPreguntaA(double apuesta, int numAcertadas) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("view/PreguntaAView.fxml"));

            BorderPane rootLayout = (BorderPane) loader.load();
            PreguntaControllerA controller = loader.getController();
            controller.setAplicacion(this);
            pregunta= modelFactoryController.obtenerPregunta();
            controller.initAttributtes(modelFactoryController.getJugadorLogueado(), pregunta, apuesta, numAcertadas);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Figure it out");

            primaryStage.show();



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void showModoClasico() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("view/ModoClasico.fxml"));

            BorderPane rootLayout = (BorderPane) loader.load();
            ModoClasicoController controller = loader.getController();
            controller.setAplicacion(this);
            controller.initAttributtes(modelFactoryController.getJugadorLogueado());

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Figure it out");

            primaryStage.show();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void showResultado(boolean flag) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("view/Resultado.fxml"));


            BorderPane rootLayout = (BorderPane) loader.load();
            ResultadoController controller = loader.getController();
            controller.setAplicacion(this);

            controller.initAttributtes(modelFactoryController.getJugadorLogueado(), flag);



            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Figure it out");

            primaryStage.show();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void showResultadoA(boolean flag, double apuesta, int numAcertadas) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("view/ResultadoA.fxml"));


            BorderPane rootLayout = (BorderPane) loader.load();
            ResultadoControllerA controller = loader.getController();
            controller.setAplicacion(this);

            controller.initAttributtes(modelFactoryController.getJugadorLogueado(), flag,apuesta, numAcertadas);



            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Figure it out");

            primaryStage.show();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void showTiempoExpirado(boolean flag) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("view/TiempoExpirado.fxml"));


            BorderPane rootLayout = (BorderPane) loader.load();
            ResultadoIncorrectoController controller = loader.getController();
            controller.setAplicacion(this);

            controller.initAttributtes(modelFactoryController.getJugadorLogueado(), flag,-1,-1);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Figure it out");

            primaryStage.show();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void showResultadoI(boolean flag, double apuesta, int numAcertadas) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("view/ResultadoIncorrecto.fxml"));


            BorderPane rootLayout = (BorderPane) loader.load();
            ResultadoIncorrectoController controller = loader.getController();
            controller.setAplicacion(this);

            controller.initAttributtes(modelFactoryController.getJugadorLogueado(), flag,apuesta, numAcertadas);



            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Figure it out");

            primaryStage.show();



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        public void showResultadoIA(boolean flag, double apuesta, int numAcertadas) {

            try {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Aplicacion.class.getResource("view/GanadorApuesta.fxml"));


                BorderPane rootLayout = (BorderPane) loader.load();
                ResultadoIncorrectoController controller = loader.getController();
                controller.setAplicacion(this);

                controller.initAttributtes(modelFactoryController.getJugadorLogueado(), flag,apuesta, numAcertadas);



                Scene scene = new Scene(rootLayout);
                primaryStage.setScene(scene);
                primaryStage.setTitle("Figure it out");

                primaryStage.show();



            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    /**
     * @return the primaryStage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * @param primaryStage the primaryStage to set
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void showApuesta() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("view/ApuestaView.fxml"));


            BorderPane rootLayout = (BorderPane) loader.load();
            ModoCasinoController controlador = loader.getController();
            controlador.setAplicacion(this);
            controlador.initAttributtes(modelFactoryController.getJugadorLogueado());



            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Figure it out");

            primaryStage.show();



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }





    }

    public void showMuchoNivel(boolean b) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("view/Muchonivel.fxml"));


            BorderPane rootLayout = (BorderPane) loader.load();
            ResultadoIncorrectoController controller = loader.getController();
            controller.setAplicacion(this);

            controller.initAttributtes(modelFactoryController.getJugadorLogueado(), b,-1,-1);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Figure it out");

            primaryStage.show();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void showGanador(boolean b) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("view/Ganador.fxml"));


            BorderPane rootLayout = (BorderPane) loader.load();
            GanadorController controller = loader.getController();
            controller.setAplicacion(this);

            controller.initAttributtes(modelFactoryController.getJugadorLogueado(), b,-1,-1);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Figure it out");

            primaryStage.show();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }






}
