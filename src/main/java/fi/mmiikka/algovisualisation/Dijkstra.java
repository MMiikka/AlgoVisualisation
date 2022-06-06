package fi.mmiikka.algovisualisation;

import javafx.concurrent.Task;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Dijkstra extends Task<PriorityBlockingQueue<Node>> {

    private Node closest;
    private Node source;
    private Node goal;
    private Node[][] grid;
    private PriorityBlockingQueue<Node> visitedNodes;
    private PriorityBlockingQueue<Node>  unvisitedNodes;

    public Dijkstra(Node source, Node goal, Node[][] grid){
        this.source = source;
        this.goal = goal;
        this.grid = grid;
    }

    public PriorityBlockingQueue<Node> findGoal(){
        unvisitedNodes = new PriorityBlockingQueue<>();
        visitedNodes = new PriorityBlockingQueue<>();

        for(Node[] nodeVector : grid){
            for(Node n : nodeVector){
                unvisitedNodes.add(n);
            }
        }
        long iterator = 0;
        while(unvisitedNodes.size() != 0){
           iterator++;
            closest = unvisitedNodes.poll();
            if(closest.getDistance() == Integer.MAX_VALUE) return visitedNodes;
            closest.setIsVisited();
            visitedNodes.add(closest);
            if(closest.isGoal()) return visitedNodes;
            updateProgress(iterator, unvisitedNodes.size());
            updateUnvisitedNeighbors(closest, grid, unvisitedNodes);
        }


        return visitedNodes;
    }

    private void updateUnvisitedNeighbors(Node closest, Node[][] grid, PriorityBlockingQueue<Node> unvisitedNodes) {

    }

    @Override
    protected PriorityBlockingQueue<Node> call() throws Exception {
        var result = findGoal();
        return result;
    }
}
