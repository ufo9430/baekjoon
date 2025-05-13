
import java.util.*;
class Solution {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        int count = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long q1tot = 0;
        long q2tot = 0;

        for (int i : queue1) {
            q1.add(i);
            q1tot += i;
        }
        for (int i : queue2) {
            q2.add(i);
            q2tot += i;
        }
        int maxCount = q1.size() * 3;
        while (count <= maxCount){
            if(q1tot == q2tot){
                answer = count;
                break;
            }
            if(q1tot > q2tot){
                Integer poll = q1.poll();
                q1tot -= poll;
                q2tot += poll;
                q2.add(poll);
            }else{
                Integer poll = q2.poll();
                q2tot -= poll;
                q1tot += poll;
                q1.add(poll);
            }
            count++;
        }
        return answer;
    }
}