
import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public static int solution(int[][] routes){
        int answer = 0;
        int index = -30001;
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        for (int[] route : routes) {
            if(index < route[0]){
                answer++;
                index = route[1];
            }
        }
        return answer;
    }
}