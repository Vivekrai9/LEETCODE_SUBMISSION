class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (source == destination)
            return true;

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[n];
        return dfs(adj, source, destination, visited);
    }

    private boolean dfs(List<Integer>[] adj, int curr, int dest, boolean[] visited) {
        if (curr == dest) return true;
        if (visited[curr])
            return false;
        visited[curr] = true;
        
        for (int nei : adj[curr]) {
            if (dfs(adj, nei, dest, visited))
                return true;
        }
        return false;
    }
}
