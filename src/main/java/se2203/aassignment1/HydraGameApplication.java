package se2203.aassignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HydraGameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HydraGameApplication.class.getResource("HydraGame-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 850);
        stage.setTitle("Hydra Game");
        stage.setScene(scene);
        stage.show();
        Image icon = new Image(HydraGameApplication.class.getResourceAsStream("/se2203/aassignment1/HydraIcon.png"));
        stage.getIcons().add(icon);
    }

    public static void main(String[] args) {
        launch();
    }
}