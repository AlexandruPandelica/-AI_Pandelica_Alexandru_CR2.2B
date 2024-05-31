// Abstract class for solving the Traveling Salesman Problem (TSP)
abstract class TSPSolver {

    // Matrix representing the distances between each pair of cities
    protected int[][] distances;

    // Constructor to initialize the distances matrix
    public TSPSolver(int[][] distances) {
        this.distances = distances;
    }
    // This method should return a Result object containing the optimal path and its cost
    public abstract Result solve();
}
