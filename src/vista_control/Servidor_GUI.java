package vista_control;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.*;

/**
 *
 * @author Juan Moncada
 */
public class Servidor_GUI extends Application {

    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;

    private Button button1;
    private Button button2;
    private Button button3;

    private ScrollPane scroll;

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(getRoot(), 800, 600);
        try
        {
            iniciarServidor();
        }catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        
        

        /*//manejo del evento del botón iniciar servidor
        button1.setOnAction(event-> 
        {
            
        });
        
        //manejo del evento del botón cerrar servidor
        button2.setOnAction(event-> 
        {
            
        });*/
        

        primaryStage.setTitle("¡Bienvenido!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void iniciarServidor () throws IOException
    {
        Consultorio c = new Consultorio();// se crear consultorio
        while(true)
        {
            Servidor serv = new Servidor(); //Se crea el servidor
            System.out.println("Iniciando servidor\n");
            serv.startServer(); //Se inicia el servidor
            Persona p = c.normalizarDatos(serv.getMensajeServidor());
            c.getCola().enColar(p,p.calcularPrioridad());
            serv.closeServer();
        }
    }

    private Parent getRoot() {
        Pane root = new Pane();

        /*Image img = new Image ("bosque rojo.jpg");
        ImageView logo = new ImageView (img); */
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();

        button1 = new Button();
        button2 = new Button();
        button3 = new Button();

        scroll = new ScrollPane();

        root.getChildren().addAll(label1, label2, label3, label4, label5, label6, button1, button2, button3, scroll);

        /*logo.setX(10);
        logo.setY(10);*/
        label1.setLayoutX(150);
        label1.setLayoutY(50);
        label1.setText("Lista de pacientes en espera");
        label1.setFont(Font.font("Impact", 25));

        label2.setLayoutX(575);
        label2.setLayoutY(100);
        label2.setText("Paciente actual");
        label2.setFont(Font.font("Impact", 20));

        label3.setLayoutX(525);
        label3.setLayoutY(175);
        label3.setText("Nombre: ");
        label3.setFont(Font.font("Impact", 16));

        label4.setLayoutX(525);
        label4.setLayoutY(275);
        label4.setText("Cédula: ");
        label4.setFont(Font.font("Impact", 16));

        label5.setLayoutX(525);
        label5.setLayoutY(375);
        label5.setText("Edad: ");
        label5.setFont(Font.font("Impact", 16));

        label6.setLayoutX(525);
        label6.setLayoutY(475);
        label6.setText("Turno: ");
        label6.setFont(Font.font("Impact", 16));

        button1.setLayoutX(200);
        button1.setLayoutY(525);
        button1.setPrefHeight(40);
        button1.setPrefWidth(100);
        button1.setText("Iniciar servidor");

        button2.setLayoutX(80);
        button2.setLayoutY(525);
        button2.setPrefHeight(40);
        button2.setPrefWidth(100);
        button2.setText("Cerrar servidor");
        button2.setDisable(true);
        button2.setVisible(false);

        button3.setLayoutX(320);
        button3.setLayoutY(525);
        button3.setPrefHeight(40);
        button3.setPrefWidth(100);
        button3.setText("Siguiente");
        button3.setDisable(true);
        button3.setVisible(false);

        scroll.setLayoutX(50);
        scroll.setLayoutY(100);
        scroll.setPrefHeight(400);
        scroll.setPrefWidth(450);

        return root;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        new Servidor_GUI();
    }

    public Servidor_GUI() {
        this.go();
    }

    public void go() {
        new JFXPanel();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                start(new Stage());
            }
        });
    }

}
