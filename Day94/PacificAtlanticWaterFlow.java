import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlanticBFS(matrix));
        System.out.println(pacificAtlanticDFS(matrix));
    }

    public static List<List<Integer>> pacificAtlanticDFS(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)return res;
        
        int m  = matrix.length, n = matrix[0].length;
        boolean[][] PVisited = new boolean[m][n], AVisited = new boolean[m][n];
        
        for (int i = 0; i < m; ++i){
            dfs(matrix, PVisited, Integer.MIN_VALUE, i, 0);
            dfs(matrix, AVisited, Integer.MIN_VALUE, i, n-1);
        }
        
        for (int i = 0; i < n; ++i){
            dfs(matrix, PVisited, Integer.MIN_VALUE, 0, i);
            dfs(matrix, AVisited, Integer.MIN_VALUE, m-1, i);
        }
        
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (PVisited[i][j] && AVisited[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        
        return res;
    }

    public static List<List<Integer>> pacificAtlanticBFS(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)return res;
        int m  = matrix.length, n = matrix[0].length;
        boolean[][] PVisited = new boolean[m][n], AVisited = new boolean[m][n];
        
        Queue<int[]> pQueue = new LinkedList<>(), aQueue = new LinkedList<>();
        for (int i = 0; i < m; ++i){
            PVisited[i][0] = true;
            pQueue.offer(new int[]{i,0});
            AVisited[i][n-1] = true;
            aQueue.offer(new int[]{i, n-1});
        }
        
        for (int i = 0; i < n; ++i){
            PVisited[0][i] = true;
            pQueue.offer(new int[]{0,i});
            AVisited[m-1][i] = true;
            aQueue.offer(new int[]{m-1, i});
        }
        
        bfs(matrix, PVisited, pQueue);
        bfs(matrix, AVisited, aQueue);

       for (int i = 0; i < m; ++i){
         for (int j = 0; j < n; ++j){
            if (PVisited[i][j] && AVisited[i][j]){
                res.add(Arrays.asList(i, j));
            }
          }
       }
        return res;
    }
    
    static int[][] dirs = {{1,0}, {-1,0}, {0, 1}, {0,-1}};
    private static void dfs(int[][] A, boolean[][] visited, int prev, int i, int j){
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || visited[i][j] || A[i][j] < prev){
            return;
        }
        
        visited[i][j]=true;
        
        for (int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(A, visited, A[i][j], x, y);
        }
    }

    private static void bfs(int[][] matrix, boolean[][] visited, Queue<int[]> q){
        int m = matrix.length, n = matrix[0].length;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            for (int[] d : dirs){
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && matrix[x][y] >= matrix[cur[0]][cur[1]]){
                    visited[x][y] = true;
                    q.offer(new int[]{x,y});
                }
            }
        }
    }
}