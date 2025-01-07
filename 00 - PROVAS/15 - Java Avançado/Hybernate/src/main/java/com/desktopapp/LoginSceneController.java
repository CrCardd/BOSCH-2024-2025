package com.desktopapp;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.desktopapp.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginSceneController {

    public static Scene CreateScene() throws Exception {
        URL sceneUrl = LoginSceneController.class
                .getResource("_login-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);

        return scene;
    }
    private User user;
    
    @FXML
    protected Button btLogin;
    @FXML
    protected TextField tfLogin;
    @FXML
    protected PasswordField pfPass;
    @FXML
    protected CheckBox cbPass;
    @FXML
    protected VBox box;
 
    @FXML
    protected void submit(ActionEvent e) throws Exception {

        Context ctx = new Context();
        var query = ctx.createQuery(User.class,
            "FROM User u WHERE u.name = :input OR u.email = :input");
        query.setParameter("input", tfLogin.getText());

        List<User> users = query.getResultList();

        if (users.isEmpty()) {
            Alert alert = new Alert(
                AlertType.ERROR,
                "Usuário não encontrado!",
                ButtonType.OK
            );
            alert.showAndWait();
            return;
        }

        var user = users.get(0);
 
        if (!pfPass.getText().equals(user.getPassword())) {
            Alert alert = new Alert(
                AlertType.ERROR,
                "Senha incorreta!",
                ButtonType.OK
            );
            alert.showAndWait();
            return;
        }
 
        this.user = user;

        VBox scene = UserSceneController.CreateScene(user);
        
        box.getChildren().setAll(scene);
        
    }

    @FXML
    protected void CreateAccount() throws IOException{
        Stage stage = (Stage)btLogin.getScene().getWindow();
        Stage new_stage = new Stage();
        Scene scene = RegisterScene.CreateScene();
        new_stage.setScene(scene);
        new_stage.showAndWait();

    }

}
