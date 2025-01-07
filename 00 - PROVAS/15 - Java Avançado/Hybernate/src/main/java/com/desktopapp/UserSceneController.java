package com.desktopapp;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.desktopapp.implementations.messageRepository;
import com.desktopapp.model.Message;
import com.desktopapp.model.User;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserSceneController {
    
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }


    public static VBox CreateScene(User user) throws IOException{
        URL sceneUrl = UserSceneController.class
            .getResource("_main-user-scene.fxml");
            
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        VBox scene = new VBox(root);

        UserSceneController controller = loader.getController();

        scene.setMinWidth(532);

        controller.setUser(user);
        controller.initialize();

        return scene;
    }

    @FXML
    Button btnLogout;
    @FXML
    Button btnSend;
    @FXML
    Label lbName;
    @FXML
    VBox box;
    @FXML
    AnchorPane ancPane;


    @FXML
    protected void newEmail() throws IOException{
        Stage stage = (Stage)btnSend.getScene().getWindow();
        Stage new_stage = new Stage();
        Scene scene = SendEmailSceneController.CreateScene(user);
        new_stage.setScene(scene);
        new_stage.showAndWait();
    }


    @FXML
    protected void logout() throws Exception{
        Stage stage = (Stage)btnLogout.getScene().getWindow();
        stage.close();

        Scene scene = LoginSceneController.CreateScene();

        stage.setScene(scene);

        stage.show();

    }

    protected void initialize(){
        lbName.setText(user.getName());

        messageRepository messageRepo = new messageRepository();
        List<Message> messages = messageRepo.getMessagesByUser(user.getId());
        Iterator<Message> iterator = messages.iterator();
        ArrayList<MessageComponent> showMessages = new ArrayList<>();
        Integer n = 0;
        while(iterator.hasNext()){
            showMessages.add(new MessageComponent(ancPane, iterator.next(), 40, (n+90)));
            n+=25;
        }
    }
    
}
