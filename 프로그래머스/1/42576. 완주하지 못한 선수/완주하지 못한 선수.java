
import java.util.*;
class Solution {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for(i=0;i<completion.length;i++){
            answer = participant[i];
            if(!participant[i].equals(completion[i])){
                break;
            }
        }
        if(i == completion.length){
            return participant[participant.length-1];
        }
        return answer;
    }
}