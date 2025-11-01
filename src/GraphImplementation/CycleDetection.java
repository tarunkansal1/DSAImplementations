package GraphImplementation;
import java.util.*;

public class CycleDetection {
    static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static void createGraph(ArrayList<Edge> [] graph,int V){
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));
    }
    public static boolean cycleDetectUtil(ArrayList<Edge> [] graph, boolean[] vis,int curr, int par){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] && e.dest != par){
                return true;
            }else if(!vis[e.dest] && cycleDetectUtil(graph,vis,e.dest,curr)){
                return true;
            }
        }
        return false;
    }
    public static void cycleDetect(ArrayList<Edge>[] graph, int V){
        boolean [] vis = new boolean[V];
        for(int i = 0; i<V; i++){
            System.out.println(i);
            if(!vis[i]){
                boolean res = cycleDetectUtil(graph,vis,i,-1);
                if(res){
                    System.out.println("True");
                    break;
                }
            }
        }
    }
    public static void main(String[] args){
        int V = 5;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph,V);
        cycleDetect(graph,V);
    }
}
