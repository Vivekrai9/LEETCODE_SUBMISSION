//dijkstra’s algorithm
class Graph {
    
    ArrayList<ArrayList<int []>> graph;
    int n;
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    
    public Graph(int n, int[][] edges) {
        graph= new ArrayList<>();
        this.n=n;


        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            addEdge(edge);
        }

    }


    
    public void addEdge(int[] edge) {
        int u=edge[0];
        int v=edge[1];
        int w=edge[2];
        graph.get(u).add(new int[]{v,w});
        
    }
    
    public int shortestPath(int node1, int node2) {

        int[] result = new int[n];
        Arrays.fill(result , Integer.MAX_VALUE);
        result[node1]=0;
        pq.add(new int[]{0,node1});

        while(!pq.isEmpty()){
            int [] top= pq.poll();
            int d= top[0];
            int node = top[1];

            if (d > result[node]) continue;

            for(int[] it: graph.get(node)){
                int adjNode = it[0];
                int dist = it[1];

                if(d + dist < result[adjNode]) {
                    result[adjNode] = d+ dist;
                    pq.offer(new int[]{ d+ dist , adjNode} );
                }
            }
        }

        return result[node2] == Integer.MAX_VALUE ? -1 : result[node2] ;

        
        
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */