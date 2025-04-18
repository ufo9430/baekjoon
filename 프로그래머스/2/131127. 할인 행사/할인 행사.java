
import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int[] currentCart;
        for (int i = 0; i <= discount.length-10; i++) {
            currentCart = new int[number.length];
            for (int j = i; j < i+10; j++) {
                for (int k = 0; k < want.length; k++) {
                    if(want[k].equals(discount[j])){
                        currentCart[k]++;
                    }
                }
            }
            if(Arrays.equals(currentCart,number)){
                answer++;
            }
        }
        return answer;
    }
}