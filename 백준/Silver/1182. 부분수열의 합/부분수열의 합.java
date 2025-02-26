import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int S;
    static List<Integer> array = new ArrayList<>();

    static int count = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        S = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            array.add(Integer.parseInt(line[i]));
        }
        calculate(0,0);
        
        if(S == 0) count--;

        System.out.println(count);

    }

    public static void calculate(int index, int sum){
        if(index == N){
            if(sum == S){
                count++;
            }
            return;
        }

        calculate(index+1, sum + array.get(index));

        calculate(index+1, sum);
    }

}