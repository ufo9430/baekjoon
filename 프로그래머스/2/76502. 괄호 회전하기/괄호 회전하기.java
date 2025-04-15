import java.util.Stack;
class Solution {
    public static int solution(String s) {
        int answer = 0;
        String s1 = s;
        for (int i = 0; i < s.length(); i++) {
            s1 = s1.substring(1) + s1.charAt(0);
            Stack<Character> stack = new Stack<>();
            boolean isPushed = false;
            for (int j = 0; j < s1.length(); j++) {
                char c = s1.charAt(j);
                if(c == '{' || c == '[' || c == '('){
                    isPushed = true;
                    stack.push(c);
                }
                if(!stack.isEmpty()){
                    Character top = stack.peek();
                    if((c == ')' && top == '(') ||
                            ( c == '}' && top == '{') ||
                            (c == ']' && top == '[')){
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty() && isPushed){
                answer++;
            }
        }
        return answer;
    }
}