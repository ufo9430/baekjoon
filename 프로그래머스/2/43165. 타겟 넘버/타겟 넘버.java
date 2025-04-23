class Solution {
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        int size = (int)Math.pow(2,numbers.length);
        for (int i = 1; i <= size; i++) {
            int sum = 0;
            for (int j = 0; j < numbers.length; j++) {
                if((i & (1 << j)) != 0){
                    sum += numbers[j];
                }else{
                    sum -= numbers[j];
                }
            }
            if(target == sum) answer++;
        }
        return answer;
    }
}