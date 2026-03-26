
class Solution {

    int n, goal, k;
    int MOD = 1_000_000_007;


    public int numMusicPlaylists(int n, int goal, int k) {
        this.n = n;
        this.goal = goal;
        this.k = k;

        long[][] dp = new long[goal+1][n+1];

        for(int i=0; i< goal+1; i++) {
             
            Arrays.fill(dp[i], -1);
        }

        return (int) recurse(goal, 0,dp );
    }


    long recurse(int currGoal, int oldSongs, long[][] dp) {

        if(currGoal == 0 && oldSongs == n) {
            return 1;
        }
        if(currGoal == 0 || oldSongs > n) {
            return 0;
        }

        if(dp[currGoal][oldSongs]!=-1) {
            return dp[currGoal][oldSongs];
        }

        long newSong = ( n - oldSongs) * recurse(currGoal-1, oldSongs+1, dp);
        // newSong = newSong % MOD;


        long Repeat = 0;
        if(oldSongs > k) {

            Repeat = ((oldSongs - k) * recurse(currGoal-1, oldSongs ,dp)) % MOD;

        }

        return dp[currGoal][oldSongs] = ( newSong + Repeat ) % MOD;
    }
}