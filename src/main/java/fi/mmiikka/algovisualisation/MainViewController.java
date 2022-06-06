package fi.mmiikka.algovisualisation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Random;

public class MainViewController {
    private Node[][] grid;
    private Pane pane;
    private Node source;
    private Node goal;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button startButton;
    @FXML
    private Button resetButton;
    @FXML
    private ProgressBar progressBar;


    @FXML
    public void initialize(){
        pane = new Pane();
        grid = new Node[20][20];
        for(int x = 0; x< 20;x++){
            for(int y = 0; y<20;y++){
                var node = new Node(x,y, Color.rgb(200,200,200));
                grid[x][y] = node;
                node.setX(x*25);
                node.setY(y*25);
                node.setDistance(Integer.MAX_VALUE);
                pane.getChildren().add(node);
            }
        }
        Random r = new Random();
        int startRow = r.nextInt(20);
        r.setSeed(r.nextInt(1000));
        int startCol = r.nextInt(20);
        int goalRow = r.nextInt(20);
        r.setSeed(r.nextInt(1000));
        int goalCol = r.nextInt(20);
        grid[startRow][startCol].setSource();
        grid[goalRow][goalCol].setGoal();
        this.source = grid[startRow][startCol];
        this.goal = grid[goalRow][goalCol];
        borderPane.setCenter(pane);
    }
    @FXML
    void startDijkstra(ActionEvent event) {
        System.out.println("works!");
        Dijkstra dijkstra = new Dijkstra(source, goal, grid);

        dijkstra.setOnRunning((e) -> {

            resetButton.setText("Cancel");
            //statusLabel.textProperty().bind(lookupTask.messageProperty());
           //progressBar.progressProperty().bind(dijkstra.progressProperty());
        });

        Thread t = new Thread(dijkstra);
        t.start();

    }





}