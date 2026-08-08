class Pair {
    int distance;
    int node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // code here
        // PriorityQueue<pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] e : times) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new Pair(w, v));
       
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        pq.add(new Pair(0,k));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int d = current.distance;

            if (d > dist[node])
                continue;

            for (Pair edge : adj.get(node)) {
                int adjnode = edge.node;
                int wt = edge.distance;

                if (d + wt < dist[adjnode]) {
                    dist[adjnode] = d + wt;
                    pq.add(new Pair(dist[adjnode], adjnode));
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;

    }
}