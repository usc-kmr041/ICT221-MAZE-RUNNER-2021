package mazerunner.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mazerunner.engine.GameEngine;

import java.awt.event.MouseEvent;

public class Controller {

    public void moveup(javafx.scene.input.MouseEvent mouseEvent) {
        System.out.println("up");
    }
    public void movedown(javafx.scene.input.MouseEvent mouseEvent) {
        System.out.println("down");
    }
    public void moveleft(javafx.scene.input.MouseEvent mouseEvent) {
        System.out.println("left");
    }
    public void moveright(javafx.scene.input.MouseEvent mouseEvent) {
        System.out.println("right");
    }





    public class GameGUI extends Application {
        // TODO: move this to Controller class if you use FXML...
        private GameEngine engine = new GameEngine(10);


        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("game_gui.fxml"));
            //Button root = new Button("Amazing Miner Game coming soon...");
            //root.setFont(new Font(24));

            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.setTitle("Maze Runner Game");
            primaryStage.setResizable(false);
            primaryStage.show();
        }
    }
}
