package com.desktopapp;


import java.io.IOException;

import com.desktopapp.implementations.userRepository;
import com.desktopapp.model.Message;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MessageComponent {
    
    private Pane container = new Pane();
    private Label from = new Label();
    private Label title = new Label();
    private Button open = new Button();

    public MessageComponent(AnchorPane ancPane, Message message, Integer x, Integer y){
        container.getChildren().setAll(from, title, open);

        userRepository userRepo = new userRepository();
        from.setText(userRepo.getById(message.getId_by()).getName() + ":");

        title.setText(message.getAbout());

        
        open.setOnAction(e -> {
            try {
                Stage stage = new Stage();
                stage.setScene(OpenMessage.CreateScene(message));
                stage.showAndWait();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        open.setText("Abrir");

        from.setLayoutX(0);
        title.setLayoutX(50);
        open.setLayoutX(200);
        
        from.setLayoutY(1);
        title.setLayoutY(0);
        open.setLayoutY(0);

        container.setLayoutX(x);
        container.setLayoutY(y);

        ancPane.getChildren().add(container);
    }
}
