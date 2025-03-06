package edu.farmingdale.csc311_mod3_assignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 290);

        stage.setTitle("Card Game-24");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    // Give 4 random cards
        // Have a list of cards, and one for their suits

    // check math equation
        // grab input and if == 24, CONGRATS!
    // have a button to re-roll cards
    // Try and have find solution to work

}