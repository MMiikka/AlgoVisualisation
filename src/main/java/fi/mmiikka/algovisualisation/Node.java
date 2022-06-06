package fi.mmiikka.algovisualisation;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Node extends Rectangle implements Comparable<Node> {

    private int row;
    private int col;
    private int distance;
    private Node prev;
    private Color color;
    private boolean isVisited;
    private boolean isSource;
    private boolean isGoal;
    private boolean isWall;

    public Node(int row,int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.setWidth(25);
        this.setHeight(25);
        this.setStroke(Color.WHITE);
        this.setFill(color);

    }
    public void setPrev(Node n) {this.prev = n;}
    public void setDistance(int distance) {this.distance = distance;}
    public int getDistance() {return this.distance;}

    public void setSource(){
        this.isSource = true;
        this.setFill(Color.GREEN);
        this.distance = 0;
    }
    public boolean isSource() {return isSource;}

    public void setGoal(){
        this.isGoal = true;
        this.setFill(Color.RED);
    }
    public boolean isGoal() {return this.isGoal;}
    public void setIsVisited() {this.isVisited = true;}
    public int getRow() {return this.row;}
    public int getCol(){ return this.col; }
    public boolean isVisited() {return isVisited;}
    public Node getPrev() {return this.prev;}
    public boolean isWall() {return this.isWall;}

    public void setWall() {
        this.isWall = true;
        this.setFill(Color.BLACK);
    }
    @Override
    public int compareTo(Node n2) {
        if(this.distance < n2.distance) {return -1;}
        if(this.distance > n2.distance) {return 1;
        }else {return 0;}
    }
}
