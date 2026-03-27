class Solution {
    public int numberOfWays(String corridor) {

        long MOD = 1_000_000_007;

        int seats = 0;
        long ways = 1;
        int plants = 0;

        for (char c : corridor.toCharArray()) {

            if (c == 'S') {
                seats++;

                if (seats > 2 && seats % 2 == 1) {
                    ways = (ways * (plants + 1)) % MOD;
                    plants = 0;
                }
            } else {
                if (seats >= 2 && seats % 2 == 0) {
                    plants++;
                }
            }
        }

        return seats % 2 == 0 && seats > 0 ? (int) ways : 0;
    }
}