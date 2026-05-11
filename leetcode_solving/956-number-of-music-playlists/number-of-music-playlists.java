
class Solution {
    int MOD = 1_000_000_007;

    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] dp = new long[goal+1][n+1];

        for(int i=0; i< goal+1; i++) { 
            Arrays.fill(dp[i], -1);
        }

        return (int) solve(goal, 0,dp,n,k );
    }

    long solve(int currGoal, int oldSongs, long[][] dp, int n, int k) {

        if(currGoal == 0 && oldSongs == n) return 1;
        if(currGoal == 0 || oldSongs > n) return 0;

        if(dp[currGoal][oldSongs] != -1) {
            return dp[currGoal][oldSongs];
        }

        long newSong = ( n - oldSongs) * solve(currGoal-1, oldSongs+1, dp,n,k);
       
        long Repeat = 0;
        if(oldSongs > k) {
            Repeat = ((oldSongs - k) * solve(currGoal-1, oldSongs ,dp,n,k)) % MOD;
        }

        return dp[currGoal][oldSongs] = ( newSong + Repeat ) % MOD;
    }
}