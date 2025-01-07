package com.desktopapp;

import java.io.IOException;
import java.net.URL;

import com.desktopapp.implementations.userRepository;
import com.desktopapp.model.Message;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class OpenMessage {
    private Message message;

    public static Scene CreateScene(Message message) throws IOException{
        URL sceneUrl = OpenMessage.class
            .getResource("_open-message-scene.fxml");
            
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        OpenMessage controller = loader.getController();

        controller.setMessage(message);
        controller.initialize();

        return scene;
    }

    @FXML
    Label labelFrom;
    @FXML
    Label labelAbout;
    @FXML
    TextArea textMessage;

    protected void initialize(){
        userRepository userRepo = new userRepository();
        labelFrom.setText(userRepo.getById(message.getId_by()).getName());
        labelAbout.setText(message.getAbout());

        textMessage.setDisable(true);;
        textMessage.setText(message.getMessage());
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
