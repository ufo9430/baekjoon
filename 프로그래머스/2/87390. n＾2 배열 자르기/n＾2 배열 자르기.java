import java.util.Arrays;
class Solution {
    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int startRow = (int) (left / n);
        int startCol = (int) (left % n);
        int row = startRow;
        int col = startCol;
        for(int i=0;i<= right - left; i++){
            if(col >= n){
                col = 0;
                row++;
            }
            int currNum = Math.max(col, row);
            answer[i] = currNum + 1;
            col++;
        }
        return answer;
    }
}