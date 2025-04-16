class Solution {
    public String solution(String s) {
        String answer = "";
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String[] line = s.split(" ");
        for(String f : line){
            int a = Integer.parseInt(f);
            max = Math.max(max,a);
            min = Math.min(min,a);
        }
        answer = String.valueOf(min) + " "+ String.valueOf(max);
        return answer;
    }
}