package Week3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

import static javafx.scene.control.Alert.AlertType.INFORMATION;

public class PasswordController {
    @FXML
    private PasswordField password;

    @FXML
    private  void checkPassword(ActionEvent actionEvent){
        int length= password.getText().length();
        if(length>4){
            Alert alert = new Alert(INFORMATION, "congrats thats a good password");
        }
        else {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("password in the clear prompt");
            dialog.setHeaderText("Enter a longer password");
            Optional<String> response= dialog.showAndWait();
            response.ifPresent(passwordverfiy->password.setText(passwordverfiy));
        }



    }
}
