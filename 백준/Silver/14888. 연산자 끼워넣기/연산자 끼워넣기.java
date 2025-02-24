import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators;

    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;

        operators = new int[4];
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        line = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(line[i]);
        }

        process(new ArrayList<>(), operators);

        System.out.println(max);
        System.out.println(min);
    }

    public static void process(List<Integer> operators, int[] remain){
        if(operators.size() == N-1){
            int result = numbers[0];
            for (int i = 0; i < N - 1; i++) {
                result = calculate(result, numbers[i+1], operators.get(i));
            }
            max = Math.max(max, result);
            min = Math.min(min, result);
        }else{
            for (int i = 0; i < 4; i++) {
                if(remain[i] > 0){
                    remain[i]--;
                    operators.add(i);
                    process(new ArrayList<>(operators), remain);
                    operators.remove(operators.size()-1);
                    remain[i]++;
                }
            }
        }
    }

    public static int calculate(int a, int b, int operator){
        if(operator == 0){
            return a + b;
        } else if (operator == 1) {
            return a - b;
        } else if (operator == 2){
            return a * b;
        } else{
            if (a < 0) {
                return -(-a / b); // C++14 스타일 정수 나눗셈 적용
            }
            return a / b;
        }
    }
}