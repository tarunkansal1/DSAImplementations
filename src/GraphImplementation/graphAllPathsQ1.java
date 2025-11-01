package GraphImplementation;
import java.util.*;

public class graphAllPathsQ1 {
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

    static void allPaths(ArrayList<Edge> [] graph,boolean [] vis,int curr,int target,String path){
        if(curr == target){
            System.out.println(path);
            return;
        }

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                vis[e.dest] = true;
                allPaths(graph,vis,e.dest,target,path+e.dest);
                vis[e.dest] = false;
            }
        }
    }

    public static void main(String[] args){
        int V = 7;
        ArrayList<Edge> [] graph  = new ArrayList[V];
        createGraph(graph);
        boolean [] vis = new boolean[V];
        vis[0] = true;
        allPaths(graph,vis,0,5,"");
    }
}
