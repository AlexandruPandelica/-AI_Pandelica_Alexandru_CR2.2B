import java.util.List;

// Class representing the result of solving the Traveling Salesman Problem (TSP)
public class Result {
    private final List<Integer> path;
    private final int cost;

    // Constructor to initialize the Result object with the path and its associated cost
    public Result(List<Integer> path, int cost) {
        this.path = path;
        this.cost = cost;
    }

    public List<Integer> getPath() {
        return path;
    }

    public int getCost() {
        return cost;
    }

    // Override the toString method to provide a string representation of the Result object
    @Override
    public String toString() {
        return "Path: " + path.toString() + ", Cost: " + cost;
    }
}

