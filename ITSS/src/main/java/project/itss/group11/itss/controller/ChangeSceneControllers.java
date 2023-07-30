package project.itss.group11.itss.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import project.itss.group11.itss.HelloApplication;

import java.io.IOException;

public abstract class ChangeSceneControllers {
    protected void changeScene(String fxLink) {
        changeScene(fxLink, null);
    }
    protected void changeScene(String fxLink, Object controller) {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxLink));
        if (controller != null) loader.setController(controller);
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        HelloApplication.MAIN_STAGE.setScene(scene);
    }
}

