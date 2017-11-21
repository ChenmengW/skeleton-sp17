package hw3.puzzle;


import edu.princeton.cs.algs4.MinPQ;

public class Solver {
    Node initialNode;
    MinPQ<Node> pq = new MinPQ(5);

    public Solver(WorldState initial){
        initialNode = new Node(initial);
    }

    public int moves(){
        return initialNode.worldState.estimatedDistanceToGoal();
    }

    public Iterable<WorldState> solution(){
        pq.insert(initialNode);
    }



    private class Node{
        WorldState worldState;
        int moves = 0;
        Node pre;
        Node(WorldState worldState){
            this.worldState = worldState;
        }
    }
}
