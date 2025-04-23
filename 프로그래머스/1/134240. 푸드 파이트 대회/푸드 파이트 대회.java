class Solution {
    public static String solution(int[] food) {
        String answer = "";
        StringBuilder str = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i]/2; j++) {
                str.append(i);
            }
        }
        answer = str.toString();
        answer = answer + "0" + str.reverse();
        return answer;
    }
}