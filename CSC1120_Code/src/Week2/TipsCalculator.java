package Week2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
//import java.awt.*;

public class TipsCalculator extends Application {

    public void  start(Stage primaryStage){
        primaryStage.setTitle("Calculator");

        // Create the UI Components
        GridPane grid = new GridPane();
        // grid is the layout manager that arranges the components
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); // set the horizontal gaps in pixels
        grid.setVgap(10); // set the vertical gaps
        grid.setPadding(new Insets(25, 25,25,25));
        // Add some buttons
        Label billLabel= new Label("Bill amount: ");
        grid.add(billLabel, 0,1);
        // Input to add the textfield to add the bill amount
        TextField billTextField= new TextField();
        grid.add(billTextField, 1,1);
        // text field to add th tip percentage
        Label tipLabel= new Label("Tip percentage");
        grid.add(tipLabel, 0,2);
        // input to add the textfield
        TextField tipTextfield = new TextField();
        grid.add(tipTextfield, 1,2);
        //
        Button btn = new Button("Calculate Tips");
        grid.add(btn, 1,3);

        // final label to display the percentage
        Label resultLabel= new Label();
            grid.add(resultLabel, 1, 4);


            // set the event handler
        btn.setOnAction( e->{   //lambda expression
            try {
                double billAmount = Double.parseDouble(billTextField.getText());
                double tipPercentage = Double.parseDouble(tipTextfield.getText()) / 100;
                double tip= billAmount*tipPercentage;
                resultLabel.setText(String.format("Tip: $%.2f", tip));

            }
            catch (NumberFormatException n) {
                resultLabel.setText("Enter a number");
            }
        });

        ///
        Scene scene= new Scene(grid, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
