import java.util.*;
class AlienDictionary{
    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(Arrays.toString(alienOrder(words)));


        String[] words1 = {"xww", "wxyz", "wxyw", "ywx", "ywz"};
        System.out.println(Arrays.toString(alienOrder(words1)));

        String[] words2 = {"z", "x"};
        System.out.println(Arrays.toString(alienOrder(words2)));

    }


    public static char[] alienOrder(String[] words){
        Graph g = buildGraph(words);
        return topologicalSort(g);
    }

    private static Graph buildGraph(String[] words){
        Graph g = new Graph();
        for (String word : words){
            for (char c : word.toCharArray()){
                g.addNode(c);
            }
        }

        for (int i = 0; i < words.length-1; ++i){
            String a  = words[i], b  = words[i+1];
            for (int j = 0; j < Math.min(a.length(), b.length()); ++j){
                if (a.charAt(j) != b.charAt(j)){
                    g.addEdge(a.charAt(j), b.charAt(j));
                    break;
                }
            }
        }

        return g;
    }

    private static char[] topologicalSort(Graph g){
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (char c : g.getNodes()){
            if (g.indegree[c] == 0)q.offer(c);
        }

        while (!q.isEmpty()){
            char node = q.poll();
            sb.append(node);
            for (char adj : g.getEdges(node)){
                g.indegree[adj]--;
                if (g.indegree[adj] == 0)q.offer(adj);
            }
        }
        
        if (sb.length() != g.getNodes().size())return new char[0];
        return sb.toString().toCharArray();
    }

    

    
}
class Graph{
    public Map<Character, Set<Character>> graph = new HashMap<>();
    public int[] indegree = new int[128];

    public void addNode(char u){
        this.graph.putIfAbsent(u, new HashSet<>());
    }

    public void addEdge(char u, char v){
        this.graph.get(u).add(v);
        this.indegree[v]++;
    }

    public Set<Character> getNodes(){
        return this.graph.keySet();
    }

    public Set<Character> getEdges(char u){
        return this.graph.getOrDefault(u, Collections.emptySet());
    }
}