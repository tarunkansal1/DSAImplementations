package GraphImplementation;
import java.util.*;

public class DijkstraAlgo {
    public static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
    static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        Pair(int n,int d){
            this.node =  n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }

    public static int[] dijkstra(ArrayList<Edge>[] graph,int src){
        boolean [] vis = new boolean[graph.length];
        int [] dist = new int[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        dist[src] = 0;
        pq.add(new Pair(0,0));
        for(int i=1;i<dist.length;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(!vis[v] && (dist[u] + wt) < dist[v]){
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
        return dist;
    }
    public static void main(String[] args){
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        int [] dist = dijkstra(graph, src);
        for(int i=0; i<dist.length; i++) {
            System.out.println(dist[i]+" ");
        }
    }
}
