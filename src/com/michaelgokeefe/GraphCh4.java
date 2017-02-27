package com.michaelgokeefe;

import java.util.*;

/**
 * Created by Michael on 2/18/17.
 */
public class GraphCh4 {

    private Map<Integer, Node> adjList = new HashMap<>();

    private class Node {
        private int id;
        private ArrayList<Node> adjacent = new ArrayList<>();

        Node(int id) {
            this.id = id;
        }

        Node(int id, ArrayList adjacent) {
            this.id = id;
            this.adjacent = adjacent;
        }

        void addAdjNode(Node adjNode) {
            adjacent.add(adjNode);
        }

        ArrayList<Node> getAdjacent() {
            return adjacent;
        }

        int getId() {
            return id;
        }
    }

    /**
     * Quick and simple graph constructor
     * Assumes correctly formatted user input and does no error checking
     */
    public GraphCh4(String adjList) {

        Scanner lineScanner = new Scanner(adjList);

        boolean first = true;

        while (lineScanner.hasNextLine()) {

            String line = lineScanner.nextLine();
            Scanner nodeScanner = new Scanner(line);

            if (first) {
                while (nodeScanner.hasNext()) {
                        int id = nodeScanner.nextInt();
                        this.adjList.put(id, new Node(id));
                }
                first = false;
            }

            else {
                int parentNodeId = nodeScanner.nextInt();
                while (nodeScanner.hasNext()) {
                    this.adjList.get(parentNodeId).addAdjNode(this.adjList.get(nodeScanner.nextInt()));
                }
            }
        }
    }

    public Node getNodeById(int id) {
        return adjList.get(id);
    }

    // 4.1
    public boolean areNodesConnected(Node src, Node dst) {

        if (src == null || dst == null) { return false; }
        if (src == dst) { return true; }

        Queue<Node> toVisit = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        toVisit.add(src);
        visited.add(src);

        while (!toVisit.isEmpty()) {

            Node nodeToVisit = toVisit.remove();

            for (Node adjNode : nodeToVisit.getAdjacent()) {

                // Returns true only if the adj node has not been visited
                if (visited.add(adjNode)) {
                    if (adjNode == dst) {
                        return true;
                    }
                    toVisit.add(adjNode);
                }
            }
        }
        return false;
    }
}
