import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] building;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        building = new int[N];

        int max = 0;

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            building[i] = Integer.parseInt(split[i]);
        }

        for (int i = 0; i < N; i++) {
            int py = building[i];
            int count = 0;
            for (int j = 0; j < N; j++) {
                if(i==j) continue;
                int ny = building[j];
                boolean possible = true;

                double lean = (double) (ny - py) /(j - i);

                for (int k = Math.min(i, j) + 1; k < Math.max(i, j); k++) {
                    double compareHeight = building[i] + lean * (k - i);
                    if (building[k] >= compareHeight) {
                        possible = false;
                        break;
                    }
                }
                if(possible) count++;
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}