package Week2;

import  javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleWindow extends  Application{
    private static final int WIDTH= 200;
    private  static  final int HEIGHT= 200;

    public static  void main(String[] args){

        launch(args);
    }
    public void start(Stage primaryStage) {
        // set some pane
        Pane root = new HBox();
        // create a label to display a message
        Label label1 = new Label("Hello JAVAFX");
        Label label2 = new Label("This class is fun!!");
        VBox pane1 = new VBox();
        pane1.getChildren().addAll(new Label("foo"), new Label("Bar"), new Label("taco"), new Label("Cat"));
        Pane root3 = new HBox();
        Label label3 = new Label("YAY!!");
        root3.getChildren().addAll(label3);
        // add buttons to the JAVAFX
        Button b1 = new Button("On");
        b1.setOnAction(this::respond);// ::this is method reference operator
        Button b2 = new Button("Off");
        EventHandler<ActionEvent> handler2 = (ActionEvent event) -> {
            System.out.println("Button pressed also!");
        if (b2.getText().equalsIgnoreCase("On")) {
            b2.setText("Off");
        } else {
            b2.setText("On");
        }
    };
        b2.setOnAction(handler2);
        // Textfield
        Label textprompt= new Label("Enter some text below:");
        TextField t1= new TextField();
        t1.setOnAction((ActionEvent event)->{
            System.out.println("Text enter was");
            System.out.println(t1.getText());
        });
      root.getChildren().addAll(label1, label2, b1, b2, textprompt, t1);
        Scene scene= new Scene(root, WIDTH,HEIGHT);
        primaryStage.setScene(scene);
        /// setting the stage title
        primaryStage.setTitle("Simple Window CSC1120");
        // show/ display the stage
        primaryStage.show();
    }
    private void respond(ActionEvent event){
        System.out.println("Button pressed!");
    }
}