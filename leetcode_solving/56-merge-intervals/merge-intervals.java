class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> ans = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                ans.add(new int[] { start, end });

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        ans.add(new int[] { start, end });

        return ans.toArray(new int[ans.size()][]);

    }
}

// sort the array based on starting point. -->  then maintain (start, end) --> form 1 to intervals.length, if(intervals[i][0] <= end) then, end = Math.max(end , intervals[i][1])