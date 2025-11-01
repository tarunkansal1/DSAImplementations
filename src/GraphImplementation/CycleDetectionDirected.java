package GraphImplementation;
import java.util.*;

public class CycleDetectionDirected {

    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    //graph1 - true
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }
//graph2 - false
// static void createGraph(ArrayList<Edge> graph[]) {
// for(int i=0; i<graph.length; i++) {
// graph[i] = new ArrayList<>();
// }
// graph[0].add(new Edge(0, 1));
// graph[0].add(new Edge(0, 2));

// graph[1].add(new Edge(1, 3));
// graph[2].add(new Edge(2, 3));
// }

    public static boolean isCyclicUtil(ArrayList<Edge> [] graph,boolean[] vis, boolean[] path,int curr){
        vis[curr] = true;
        path[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] && path[e.dest])
                return true;
            else if(!vis[e.dest] && isCyclicUtil(graph,vis,path,e.dest)){
                return true;
            }
        }
        path[curr] = false;
        return false;
    }
    public static boolean isCyclic(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                boolean res = isCyclicUtil(graph,vis,new boolean[graph.length],i);
                if(res){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println(isCyclic(graph));
    }
}
