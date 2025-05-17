class Solution {
    public static int solution(int n, int k)  {
        String numbers = getChangedNumbers(n,k);
        String[] splitNumbers = numbers.split("0");
        int answer = 0;

        for (String splitNumber : splitNumbers) {
            if(splitNumber.isEmpty()) continue;
            long num = Long.parseLong(splitNumber);
            if(checkPrime(num)){
                answer++;
            }
        }

        return answer;
    }

    private static boolean checkPrime(long n){
        if(n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }

    private static String getChangedNumbers(int n, int k){
        StringBuffer s = new StringBuffer();
        while(n>=1){
            s.append(n%k);
            n/=k;
        }
        return s.reverse().toString();
    }
}