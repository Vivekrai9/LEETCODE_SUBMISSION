
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == destination) return true;
            for (int nei : adj[cur]) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
        return false;
    }
}
