import java.util.List;

// Class representing a node in the search space for the Traveling Salesman Problem (TSP)
class Node {
    int cost;
    List<Integer> path;
    int maxDistance;
    int estimatedCost;

    // Constructor to initialize a Node without an estimated cost
    Node(int cost, List<Integer> path, int maxDistance) {
        this(cost, path, maxDistance, 0);
    }

    // Constructor to initialize a Node with an estimated cost
    Node(int cost, List<Integer> path, int maxDistance, int estimatedCost) {
        this.cost = cost;
        this.path = path;
        this.maxDistance = maxDistance;
        this.estimatedCost = estimatedCost;
    }
}