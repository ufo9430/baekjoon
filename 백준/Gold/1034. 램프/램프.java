import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M, K;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, Integer> rowMap = new HashMap<>();
        String[] rows = new String[N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            rows[i] = row;
            rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
        }

        K = Integer.parseInt(br.readLine());

        int max = 0;
        for (String row : rowMap.keySet()) {
            int zeroCount = 0;
            for (char c : row.toCharArray()) {
                if (c == '0') zeroCount++;
            }

            // 0의 개수 ≤ K이고, (K - 0의 개수)가 짝수일 때만 가능
            if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
                max = Math.max(max, rowMap.get(row));
            }
        }

        System.out.println(max);
    }
}
