import java.util.ArrayList;
import java.util.List;

class Solution {
    int[][] pattern = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,1,2,4,5}};
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] count = {0,0,0};
        for (int i = 0; i < answers.length; i++) {
            count[0] += pattern[0][i%5] == answers[i] ? 1 : 0;
            count[1] += pattern[1][i%8] == answers[i] ? 1 : 0;
            count[2] += pattern[2][(i/2)%5] == answers[i] ? 1 : 0;
        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, count[i]);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if(count[i] == max){
                result.add(i + 1);
            }
        }

        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}