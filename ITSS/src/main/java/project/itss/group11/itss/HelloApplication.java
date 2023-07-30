package project.itss.group11.itss;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    public static Stage MAIN_STAGE;
    private static final List<Stage> secondaryStages = new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


        MAIN_STAGE = stage;
		MAIN_STAGE.setOnCloseRequest(ev -> {
            for (var secondaryStage : secondaryStages) {
                secondaryStage.close();
            }
        });
    }
    public static void main(String[] args) {
        launch();
    }
}