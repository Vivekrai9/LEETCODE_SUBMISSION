class Solution {
    public int numberOfWays(String corridor) {

        int MOD = 1_000_000_007;
        int seat = 0;
        int plant = 0;
        long way = 1;

        for(char ch : corridor.toCharArray()) {

            if(ch == 'S') {
                seat++;

           
                if(seat > 2 && seat % 2 == 1) {

                    way = (way * (plant + 1)) % MOD;
                    plant = 0;
                }
            }

            else { 

                if(seat >= 2 && seat % 2 == 0) {
                    plant++;
                }
            }
        }

        if(seat > 0 && seat % 2 == 0)
            return (int) way;

        return 0;
    }
}