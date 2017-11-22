package hw3.puzzle;
import edu.princeton.cs.algs4.*;
import java.util.List;
import java.util.ArrayList;

public class Solver {
    Node initialNode;
    MinPQ<Node> pq = new MinPQ(5);
    List<WorldState> nodelist= new ArrayList();

    public Solver(WorldState initial){
        initialNode = new Node(initial, 0, null);
    }

    public int moves(){
        return initialNode.worldState.estimatedDistanceToGoal();
    }

    public Iterable<WorldState> solution(){
        pq.insert(initialNode);
        while ( ! pq.min().worldState.isGoal()) {
            Node minNode = pq.delMin();
            nodelist.add(minNode.worldState);
            for (WorldState w : minNode.worldState.neighbors()) {
                Node neighborNode = new Node(w, minNode.moves+1, minNode);
                if (minNode.pre == null || ! neighborNode.worldState.equals(minNode.pre.worldState)){
                    pq.insert(neighborNode);
                }
            }
        }
        nodelist.add(pq.delMin().worldState);
        return nodelist;
    }


    private class Node implements Comparable<Node>{
        WorldState worldState;
        Integer moves = 0;
        Node pre;

        Node(WorldState worldState, int move, Node pre){
            this.worldState = worldState;
            this.moves = move;
            this.pre = pre;
        }

        private Integer dis(){
            return moves + worldState.estimatedDistanceToGoal();
        }

        @Override
        public int compareTo(Node node){
             return this.dis() - node.dis();
        }

        /*
        @Override
        public boolean equals(Object node1){
            Node node = (Node) node1;
            return this.worldState.equals(node.worldState);
        }


        @Override
        public int hashCode(){
            return pri().hashCode();
        }
        */
    }
}
