import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static int N;
    static int[] dice = new int[6];
    static int[][] doubleIndex = {
            {0,1},{0,2},{0,3},{0,4},
            {1,0},{1,2},{1,3},{1,5},
            {2,0},{2,1},{2,4},{2,5},
            {3,0},{3,1},{3,4},{3,5},
            {4,0},{4,2},{4,3},{4,5},
            {5,1},{5,2},{5,3},{5,4}
            };
    static int[][] tripleIndex = {
            {0,1,2},{0,1,3},{0,3,4},{0,2,4},
            {5,1,2},{5,1,3},{5,3,4},{5,2,4}
    };

    static BigInteger result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;

        N = Integer.parseInt(br.readLine());

        line = br.readLine().split(" ");
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(line[i]);
        }
        int singleMin = singleMin();
        int doubleMin = doubleMin();
        int tripleMin = tripleMin();

        int addition = N - 2;

        if(N == 1){
            int max = 0;
            int sum = 0;
            for (int i = 0; i < 6; i++) {
                max = Math.max(max,dice[i]);
                sum += dice[i];
            }
            sum = sum - max;
            System.out.println(sum);
            return;
        }

        result = BigInteger.valueOf((4L * tripleMin + 4L * doubleMin +
                8L * addition * doubleMin +
                4L * addition * singleMin +
                5L * addition * addition * singleMin));

        System.out.println(result);
    }
    public static int singleMin(){
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            result = Math.min(result,dice[i]);
        }
        return result;
    }

    public static int doubleMin(){
        int result = Integer.MAX_VALUE;
        for (int[] index : doubleIndex) {
            result = Math.min(result, dice[index[0]] + dice[index[1]]);
        }
        return result;
    }

    public static int tripleMin(){
        int result = Integer.MAX_VALUE;
        for (int[] index : tripleIndex) {
            int sum = dice[index[0]] + dice[index[1]] + dice[index[2]];
            result = Math.min(result, sum);
        }
        return result;
    }
}