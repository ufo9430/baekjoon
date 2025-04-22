import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> a[2])); // 비용 오름차순 정렬

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int answer = 0;
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];

            if (find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                answer += c;
            }
        }

        return answer;
    }
    private int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]); // 경로 압축
    }

    private void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }
}