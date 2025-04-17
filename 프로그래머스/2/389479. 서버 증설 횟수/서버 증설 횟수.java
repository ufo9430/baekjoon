
import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int currentServer = 1;
        Queue<int[]> timestamp = new LinkedList<>();
        for (int time = 0; time < players.length; time++) {
            if (!timestamp.isEmpty() && timestamp.peek()[1] + k == time) {
                currentServer -= timestamp.poll()[0];
            }
            int requiredServer = (players[time] / m) + 1;
            if (requiredServer > currentServer) {
                int add = requiredServer - currentServer;
                currentServer += add;
                answer += add;
                timestamp.add(new int[]{add, time});
            }
        }
        return answer;
    }
}