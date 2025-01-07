package com.desktopapp;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.desktopapp.implementations.messageRepository;
import com.desktopapp.model.Message;
import com.desktopapp.model.User;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SendEmailSceneController {
    
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public static Scene CreateScene(User user) throws IOException{
        URL sceneUrl = SendEmailSceneController.class
            .getResource("_send-email-scene.fxml");
            
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        SendEmailSceneController controller = loader.getController();
        controller.setUser(user);

        return scene;
    }

    @FXML
    TextField inputEmail;
    @FXML
    TextField inputAbout;
    @FXML
    TextArea inputMessage;
    

    @FXML
    protected void SendEmail(){
        Context ctx = new Context();
        var query = ctx.createQuery(User.class,
            "FROM User u WHERE u.email = :input");
        query.setParameter("input", inputEmail.getText());

        List<User> users = query.getResultList();

        if (users.isEmpty()) {
            Alert alert = new Alert(
                AlertType.ERROR,
                "Não há nenhum usuário com este email!",
                ButtonType.OK
            );
            alert.showAndWait();
            return;
        }

        Message new_message = new Message();
        new_message.setAbout(inputAbout.getText());
        new_message.setMessage(inputMessage.getText());
        new_message.setId_by(user.getId());
        new_message.setId_from(users.get(0).getId());

        messageRepository messageRepo = new messageRepository();
        messageRepo.create(new_message);
    }



}
