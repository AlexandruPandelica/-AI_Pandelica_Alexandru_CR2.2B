import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TSPSolverBFS extends TSPSolver {
    // Constructor for TSPSolverBSF
    public TSPSolverBFS(int[][] distances) {
        super(distances);
    }

    @Override
    public Result solve() {
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> startPath = new ArrayList<>();
        startPath.add(0);
        queue.add(startPath);
        List<Integer> bestPath = null;
        int minMaxDistance = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            List<Integer> path = queue.poll();
            if (path.size() == distances.length) {
                path.add(0);
                int maxDistance = Utils.calculateMaxDistance(path, distances);
                if (maxDistance < minMaxDistance) {
                    minMaxDistance = maxDistance;
                    bestPath = new ArrayList<>(path);
                }
                path.remove(path.size() - 1);
            } else {
                for (int i = 0; i < distances.length; i++) {
                    if (!path.contains(i)) {
                        List<Integer> newPath = new ArrayList<>(path);
                        newPath.add(i);
                        queue.add(newPath);
                    }
                }
            }
        }
        return new Result(bestPath, minMaxDistance);
    }
}