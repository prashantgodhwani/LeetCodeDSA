import java.util.ArrayList;
import java.util.List;

public class Leetcode_AllPathsFromSourceToTarget_797 {
    public static void main(String[] args) {
        int[][] graph = {{4,3,1}, {3,2,4}, {}, {4}, {}};
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        allPathsSourceTarget(graph, 0, path, paths);
        System.out.println(paths);
    }

    public static void allPathsSourceTarget(int[][] graph, int pos, List<Integer> path, List<List<Integer>> paths) {
            if(pos == graph.length-1){
            System.out.println(path);
            paths.add(new ArrayList<>(path));
            return;
        }


        for(int i = 0; i < graph[pos].length; i++){
            path.add(graph[pos][i]);
            allPathsSourceTarget(graph, graph[pos][i], path, paths);
            path.remove(path.size() - 1);
        }
    }
}
