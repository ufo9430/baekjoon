class Solution {public static int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = (int)1e9;
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            long totalTime = calc(diffs, times, mid);

            if (totalTime <= limit) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    private static long calc(int[] diffs, int[] times, long level) {
        long total_time = 0;
        for (int i = 0; i < diffs.length; i++) {
            if(level >= diffs[i]){
                total_time += times[i];
            }else{
                total_time += (diffs[i] - level) * (times[i] + times[i-1]) + times[i];
            }
        }
        return total_time;
    }
}