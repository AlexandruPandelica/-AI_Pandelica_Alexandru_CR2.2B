import java.util.List;

// Utility class containing helper methods for the Traveling Salesman Problem (TSP)
public class Utils {
    // Method to calculate the maximum distance between any two consecutive cities in a given path
    public static int calculateMaxDistance(List<Integer> path, int[][] distances) {
        // Initialize the maximum distance to 0
        int maxDistance = 0;

        // Iterate through the path starting from the second city
        for (int i = 1; i < path.size(); i++) {
            // Calculate the distance between the current city and the previous city
            int distance = distances[path.get(i - 1)][path.get(i)];

            // Update the maximum distance if the current distance is greater
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }

        // Return the maximum distance found
        return maxDistance;
    }
}
