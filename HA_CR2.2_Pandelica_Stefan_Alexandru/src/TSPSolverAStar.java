import java.util.*;

class TSPSolverAStar extends TSPSolver {

    // Constructor for TSPSolverAStar
    public TSPSolverAStar(int[][] distances) {
        super(distances);
    }

    private int heuristic(int city, Set<Integer> visited) {
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < distances.length; i++) {
            if (!visited.contains(i)) {
                minDistance = Math.min(minDistance, distances[city][i]);
            }
        }
        return minDistance;
    }

    @Override
    public Result solve() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost + n.estimatedCost));
        priorityQueue.add(new Node(0, new ArrayList<>(List.of(0)), 0, heuristic(0, Set.of(0))));
        List<Integer> bestPath = null;
        int minMaxDistance = Integer.MAX_VALUE;

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            if (currentNode.path.size() == distances.length) {
                currentNode.path.add(0);
                int maxDistance = Utils.calculateMaxDistance(currentNode.path, distances);
                if (maxDistance < minMaxDistance) {
                    minMaxDistance = maxDistance;
                    bestPath = new ArrayList<>(currentNode.path);
                }
                currentNode.path.remove(currentNode.path.size() - 1);
            } else {
                for (int i = 0; i < distances.length; i++) {
                    if (!currentNode.path.contains(i)) {
                        List<Integer> newPath = new ArrayList<>(currentNode.path);
                        newPath.add(i);
                        int newCost = currentNode.cost + distances[currentNode.path.get(currentNode.path.size() - 1)][i];
                        int h = heuristic(i, new HashSet<>(newPath));
                        priorityQueue.add(new Node(newCost, newPath, Math.max(currentNode.maxDistance, distances[currentNode.path.get(currentNode.path.size() - 1)][i]), newCost + h));
                    }
                }
            }
        }
        return new Result(bestPath, minMaxDistance);
    }
}
