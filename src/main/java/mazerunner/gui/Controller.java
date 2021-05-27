package mazerunner.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import mazerunner.engine.GameEngine;
import mazerunner.engine.Map;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {



    public void start(javafx.scene.input.MouseEvent mouseEvent){
        Map Map = new Map();
        Map.GenerateMap(4);
        //somehow get value from GUI to add as response to set difficulty.//
        Map.PrintMap();
        //Get PrintMap() to print elements in the 10x10 grid in the GUI.//
        //set win conditions and move commands//
    }



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

    @FXML private Label Stamina;
    @FXML private Label Coins;
    @FXML private ChoiceBox<Integer> Mydifficulty;
    private Integer[] difficultylist = {1,2,3,4,5,6,7,8,9,10};

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Mydifficulty.getItems().addAll(difficultylist);

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
