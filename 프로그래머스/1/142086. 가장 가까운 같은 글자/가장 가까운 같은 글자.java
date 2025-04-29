class Solution {
   public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            answer[i] = -1;
            char c = s.charAt(i);
            for (int j = 0; j < i; j++) {
                if(c == s.charAt(j)){
                    answer[i] = i-j;
                }
            }
        }
        return answer;
    }
}