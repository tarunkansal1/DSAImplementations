package GraphImplementation;
import java.util.*;

public class bfsDfsInGraph {

    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge> [] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(6, 5, 1));

    }

    static void graphBfs(ArrayList<Edge> [] graph,int v){
        Queue<Integer> q = new LinkedList<>();
        boolean [] vis = new boolean[v];
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            //System.out.println("queue" + curr);
            if(!vis[curr]){
                vis[curr] = true;
                System.out.print(curr + "");
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    static void graphDfs(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                graphDfs(graph,e.dest,vis);
            }
        }
    }
    public static void main (String[] args){
        int V = 7;
        ArrayList<Edge> [] graph  = new ArrayList[V];
        createGraph(graph);
        System.out.print("BFS: ");
        graphBfs(graph,V);
        System.out.println();
        System.out.print("DFS: ");
        graphDfs(graph,0,new boolean [V]);

    }
}
