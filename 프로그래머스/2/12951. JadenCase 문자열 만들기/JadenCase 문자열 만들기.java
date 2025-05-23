class Solution {
    public static String solution(String s) {
       StringBuffer answer = new StringBuffer();
       boolean isHeadChar = true;
       s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' '){
                isHeadChar = true;
            }else if(isHeadChar){
                isHeadChar = false;
                if(c >= 'a' && c <= 'z'){
                    c -= 32;
                }
            }
            answer.append(c);
        }
       return answer.toString();
    }
}