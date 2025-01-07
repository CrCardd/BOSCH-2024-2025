package com.desktopapp;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.desktopapp.implementations.userRepository;
import com.desktopapp.model.User;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterScene {
    
    public static Scene CreateScene() throws IOException{
        URL sceneUrl = RegisterScene.class
            .getResource("_register-scene.fxml");
            
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        // RegisterScene controller = loader.getController();

        return scene;
    }

    @FXML
    TextField inputName;
    @FXML
    TextField inputEmail;
    @FXML
    PasswordField inputPassword;
    @FXML
    PasswordField inputPasswordT;
    @FXML
    Button createAccount;
    @FXML
    Label message;

    @FXML
    protected void CreateAccount() throws Exception{
        String email = inputEmail.getText().trim();
        String name = inputName.getText().trim();
        String password = inputPassword.getText().trim();
        String passwordT = inputPasswordT.getText().trim();

        userRepository userRepo = new userRepository();
        List<User> byName = userRepo.getByName(name);
        List<User> byEmail = userRepo.getByEmail(email);
        if(!byName.isEmpty() && !byEmail.isEmpty()){
            Alert alert = new Alert(
                AlertType.ERROR,
                "Email ou nome de usuário já cadastrado!",
                ButtonType.OK
            );
            alert.showAndWait();
            return;
        }
        if(!validatePassword()){
            return;
        }
        if((!password.contentEquals(passwordT))){
            message.setText("Revise sua senha!");
            return;
        }     
        

        User new_user = new User();
        new_user.setEmail(email);
        new_user.setName(name);
        new_user.setPassword(password);
        userRepo.create(new_user);

        Stage stage = (Stage)createAccount.getScene().getWindow();
        stage.close();
        Scene scene = LoginSceneController.CreateScene();
        stage.setScene(scene);
        stage.show();
    }
    
    private boolean validatePassword(){
        
        
        String password = inputPassword.getText().trim();
        
        boolean result = true;


        if(password.length() < 8){
            message.setText(message.getText() + "\nA senha deve conter mais de 8 caracteres");
            result = false;
        }

        if( !password.contains("@") && 
            !password.contains("!") &&
            !password.contains("_") &&
            !password.contains("#") &&
            !password.contains(">") &&
            !password.contains("<") &&
            !password.contains("*")){
            message.setText(message.getText() + "\nA senha deve conter caracteres especiais (@, !, _, #, >, <, *)");
            result = false;
        }
        if(!password.chars().anyMatch(c -> c >= '0' && c <= '9')){
            message.setText(message.getText() + "\nA senha deve conter pelo menos um número");
            result = false;
        }
        if(!password.chars().anyMatch(c -> c >= 'a' && c <= 'z')){
            message.setText(message.getText() + "\nA senha deve conter pelo menos uma letra");
            result = false;
        }


        System.err.println("\n\n\n\n\nTESTEZAO DA MASSA");



        // var g = Stream.of(password.toCharArray())
        //     .map(a -> a.equals("@") || a.equals("."))
        //     .collect(Collectors.toList());


        // var g = Stream.of(password.toCharArray())
        //     .collect(Collectors.toList());

        // System.out.println(g.toString());

        return result;
    }

    @FXML
    protected void clearMessage(){
        message.setText("");
    }
    
}
