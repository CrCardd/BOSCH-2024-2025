package com.desktopapp;

import com.desktopapp.model.Message;
import com.desktopapp.model.User;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) {
        User user = new User();
        User user_ = new User();
        User user__ = new User();

        user.setName("a");
        user.setPassword("a");
        user.setEmail("a");
        
        user_.setName("z");
        user_.setPassword("z");
        user_.setEmail("z");

        user__.setName("x");
        user__.setPassword("x");
        user__.setEmail("x");

        Message m = new Message();
        m.setAbout("about");
        m.setMessage("message");
        m.setId_by(Long.valueOf(1));
        m.setId_from(Long.valueOf(2));




        Context ctx = new Context();
        ctx.begin();
        ctx.persist(user);
        ctx.persist(user_);
        ctx.persist(user__);
        ctx.persist(m);
        ctx.commit();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = LoginSceneController.CreateScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }  
}
