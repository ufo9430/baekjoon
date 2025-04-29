import java.util.*;
class Solution {
    public static int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));
        double missile = -1;

        for (int[] t : targets) {
            if (missile <= t[0]) {
                missile = t[1] - 0.5;
                answer++;
            }
        }

        return answer;
    }
}