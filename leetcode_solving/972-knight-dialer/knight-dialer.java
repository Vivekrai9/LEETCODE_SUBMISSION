class Solution {
    private static final int MOD = 1_000_000_007;

    public int knightDialer(int n) {

        

        int [][]dp = new int[10][n];
        for(int [] r : dp)
        Arrays.fill(r ,-1);

        // ArrayList<ArrayList<Integer> adj = new ArrayList<>();

        // for(int i=0;i<=9;i++){
        //     adj.add(new ArrayList<>());
        // }

        // adj.get(0).add(4,6);
        // adj.get(1).add(1,8);
        // adj.get(2).add(7,9);
        // adj.get(3).add(4,8);
        // adj.get(4).add(0,3,9);
        // adj.get(5).add();
        // adj.get(6).add(0,1,7);
        // adj.get(7).add(2,6);
        // adj.get(8).add(1,3);
        // adj.get(9).add(2,4);

        int [][] adj = {{4,6},
                        {6,8},
                        {7,9},
                        {4,8},
                        {0,3,9},
                        {},
                        {0,1,7},
                        {2,6},
                        {1,3},
                        {2,4}
                                };

        int t=0;

        for(int i=0;i<=9;i++){
            t= (t + solve(i,n,1,adj,dp))% MOD;
        }

        return t;

    }

    public int solve(int num, int n,int clen,int [][] adj ,int [][]dp){
        if(clen == n) return 1;

        if(dp[num][clen] != -1) return dp[num][clen];

        int ans=0;

        for(int next : adj[num]){
            ans=(ans + solve( next , n, clen + 1 , adj ,dp)) % MOD;
        }

        return dp[num][clen] = ans;

        
    }
}