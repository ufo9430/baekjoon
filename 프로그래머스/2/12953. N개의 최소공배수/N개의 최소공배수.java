import java.util.*;
class Solution {
    public static int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = 0;
        Loop:
        while(true){
            answer += arr[arr.length-1];
            for (int num : arr) {
                if(answer%num != 0)
                    continue Loop;
            }
            return answer;
        }
    }
}