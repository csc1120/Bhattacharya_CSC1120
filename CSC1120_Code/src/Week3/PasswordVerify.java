package Week3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PasswordVerify extends Application {
    public  void start(Stage stage) throws  Exception{
        Parent root= FXMLLoader.load(getClass().getResource("Week3.PasswordVerify.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
