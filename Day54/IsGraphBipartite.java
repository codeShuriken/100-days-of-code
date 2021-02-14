import java.util.LinkedList;
import java.util.Queue;

class IsGraphBipartite {
    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartiteBFS(graph));
        System.out.println(isBipartiteDFS(graph));

        int[][] graph1 = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartiteBFS(graph1));
        System.out.println(isBipartiteDFS(graph1));


    }

    public static boolean isBipartiteBFS(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i){
            if (colors[i] != 0)continue;
            colors[i] = 1;
            q.offer(i);
            
            while (!q.isEmpty()){
                int cur  = q.poll();
                for (int v : graph[cur]){
                    if (colors[v] == 0){
                        colors[v] = -colors[cur];
                        q.offer(v);
                    }else if (colors[v] != -colors[cur]){
                        return false;
                    }
                }
                
            }
        }
        return true;
    }

    public static boolean isBipartiteDFS(int[][] graph){
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; ++i){
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)){
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int[][] graph, int[] colors, int cur, int color){
        if (colors[cur] != 0)return colors[cur] == color;
        colors[cur] = color;
        for (int v : graph[cur]){
            if (!dfs(graph, colors, v, -color)){
                return false;
            }
        }
        return true;
    }
}