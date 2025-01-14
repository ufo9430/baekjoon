import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> buttons = new ArrayList<>();
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int result = Math.abs(N-100);

        if(M == 0){
            result = Math.min(result, String.valueOf(N).length());
            System.out.println(result);
            return;
        }

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            buttons.add(Integer.parseInt(split[i]));
        }

        for (int i = 0; i < 999999; i++) {
            String num = String.valueOf(i);

            boolean match = true;
            for (int j = 0; j < num.length(); j++) {
                if(buttons.contains(num.charAt(j) - '0')){
                    match = false;
                    break;
                }
            }
            if(match){
                int gap = Math.abs(N-i) + num.length();
                result = Math.min(gap,result);
            }
        }

        System.out.println(result);
    }
}
