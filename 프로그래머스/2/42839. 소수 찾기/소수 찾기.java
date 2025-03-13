import java.util.HashSet;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        process(numbers, "", set);

        for (Integer integer : set) {
            if(isPrime(integer)) answer++;
        }
        return answer;
    }

    public void process(String numbers, String currentNumber, HashSet<Integer> set){
        if(!currentNumber.isEmpty()){
            set.add(Integer.parseInt(currentNumber));
        }

        for (int i = 0; i < numbers.length(); i++) {
            String nextNumber = currentNumber + numbers.charAt(i);
            process(numbers.substring(0,i)+numbers.substring(i+1), nextNumber, set );
        }
    }

    public boolean isPrime(int n) {
        if(n < 2) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}