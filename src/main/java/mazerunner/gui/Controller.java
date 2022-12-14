package mazerunner.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mazerunner.engine.GameEngine;
import mazerunner.engine.Map;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {
    Map Map = new Map();

    //private void scanmap(){
      //  for (int row = 0; row < Map.map.length; row++){
        //    for (int col = 0; col < Map.map[row].length; col++){
          //      Map.map[row][col] = row * col;
            //    System.out.print(String.valueOf(Map.map) + "\t");
            //}}}

    public void start(javafx.scene.input.MouseEvent mouseEvent){
        Map.GenerateMap(Mydifficulty.getValue());
        //somehow get value from GUI to add as response to set difficulty.//
        Map.PrintMap();
        //Get PrintMap() to print elements in the 10x10 grid in the GUI.//
        //set win conditions and move commands//
        //Iterate through Map and represent values in Grid//
        //disable control buttons before starting game//
    }



    public void moveup(javafx.scene.input.MouseEvent mouseEvent) {
        Map.move('u');
        Map.PrintMap();
        Stamina.setText(String.valueOf(Map.stamina));
        Coins.setText(String.valueOf(Map.coin));
    }
    public void movedown(javafx.scene.input.MouseEvent mouseEvent) {
        Map.move('d');
        Map.PrintMap();;
        Stamina.setText(String.valueOf(Map.stamina));
        Coins.setText(String.valueOf(Map.coin));
    }
    public void moveleft(javafx.scene.input.MouseEvent mouseEvent) {
        Map.move('l');
        Map.PrintMap();;
        Stamina.setText(String.valueOf(Map.stamina));
        Coins.setText(String.valueOf(Map.coin));
    }
    public void moveright(javafx.scene.input.MouseEvent mouseEvent) {
        Map.move('r');
        Map.PrintMap();;
        Stamina.setText(String.valueOf(Map.stamina));
        Coins.setText(String.valueOf(Map.coin));
    }


    @FXML private Label Stamina;
    @FXML private Label Coins;
    @FXML private Button Set;

    @FXML private GridPane grid;
    //Image playerimage = new Image("mazerunner/gui/player.JPG");
    @FXML private ImageView playerimage;
    @FXML private Label playerlabel = new Label("Player");
    @FXML private ChoiceBox<Integer> Mydifficulty;
    private Integer[] difficultylist = {1,2,3,4,5,6,7,8,9,10};

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Mydifficulty.getItems().addAll(difficultylist);
        Mydifficulty.setValue(5);
        //grid.getChildren().add(new ImageView(playerimage));
        grid.add(playerlabel,Map.y,Map.x);
        Stamina.setText(String.valueOf(Map.stamina));
        Coins.setText(String.valueOf(Map.coin));
        //scanmap();
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
