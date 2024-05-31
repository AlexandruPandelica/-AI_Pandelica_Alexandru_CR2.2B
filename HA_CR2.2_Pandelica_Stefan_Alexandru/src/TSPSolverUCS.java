import java.util.*;

class TSPSolverUCS extends TSPSolver {

    // Constructor for TSPSolverUCS
    public TSPSolverUCS(int[][] distances) {
        super(distances);
    }

    @Override
    public Result solve() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        priorityQueue.add(new Node(0, new ArrayList<>(List.of(0)), 0));
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
                currentNode.path.removeLast();
            } else {
                for (int i = 0; i < distances.length; i++) {
                    if (!currentNode.path.contains(i)) {
                        List<Integer> newPath = new ArrayList<>(currentNode.path);
                        newPath.add(i);
                        int newCost = currentNode.cost + distances[currentNode.path.getLast()][i];
                        priorityQueue.add(new Node(newCost, newPath, Math.max(currentNode.maxDistance, distances[currentNode.path.getLast()][i])));
                    }
                }
            }
        }
        return new Result((bestPath), minMaxDistance);
    }
}