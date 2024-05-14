package se2203.aassignment1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class HydraGameController {
   @FXML
   private Button resetButton;

   @FXML
   private Button playButton;

   @FXML
   private Slider headSizeSlider;

   @FXML
   private ImageView headImageView;

   @FXML
   private AnchorPane anchorPane;
    private void addHead(int size, double x, double y) {
        if (size == 0) return; // Stop if the size is less than the minimum

        String imagePath = String.format("/se2203/aassignment1/HeadSize%d.png", size);
        Image headImage = new Image(getClass().getResourceAsStream(imagePath));
        ImageView imageView = new ImageView(headImage);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(40); // Adjust the size factor as needed

        imageView.setLayoutX(x);
        imageView.setLayoutY(y);

        imageView.setOnMouseClicked(event -> handleHeadClick(event, size));

        anchorPane.getChildren().add(imageView);
    }

    private void handleHeadClick(MouseEvent event, int currentSize) {
        anchorPane.getChildren().remove(event.getSource());

        Random rand = new Random();
        int headsToGenerate = rand.nextBoolean() ? 2 : 3; // Randomly decide to generate 2 or 3 heads

        for (int i = 0; i < headsToGenerate; i++) {
            double randomX = rand.nextDouble() * (anchorPane.getWidth() - 50 * (currentSize - 1));
            double randomY = rand.nextDouble() * (anchorPane.getHeight() - 100) + 50;
            addHead(currentSize - 1, randomX, randomY);
        }
    }

    @FXML
    protected void handlePlay() {
        playButton.setDisable(true);
        headSizeSlider.setDisable(true);
        int size = (int) headSizeSlider.getValue();

        // Generate random coordinates for the initial head
        Random rand = new Random();
        double randomX = rand.nextDouble() * (anchorPane.getWidth() - 50 * size);
        double randomY = rand.nextDouble() * (anchorPane.getHeight() - 100) + 50;

        addHead(size, randomX, randomY);
    }

   // Method to handle the reset button action
   @FXML
   protected void handleReset() {
      anchorPane.getChildren().removeIf(node -> node instanceof ImageView);
       playButton.setDisable(false);
       headSizeSlider.setDisable(false);
   }
}