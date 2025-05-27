import java.util.Arrays;

class Solution {
    static int maxDiff = Integer.MIN_VALUE;
    static int[] maxLion = {-1};

    public static void main(String[] args) {
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        System.out.println(Arrays.toString(solution(n, info)));
    }

    public static int[] solution(int n, int[] info) {
        find(0, 0, n, info, new int[11]);
        return maxLion;
    }

    private static void find(int index, int used, int n, int[] apeach, int[] lion) {
        if (used == n || index == 11) {
            if (used < n) lion[10] += (n - used);
            int diff = calc(apeach, lion);
            if (diff > 0) {
                if (diff > maxDiff) {
                    maxDiff = diff;
                    maxLion = Arrays.copyOf(lion, 11);
                } else if (diff == maxDiff) {
                    for (int i = 10; i >= 0; i--) {
                        if (lion[i] > maxLion[i]) {
                            maxLion = Arrays.copyOf(lion, 11);
                            break;
                        } else if (lion[i] < maxLion[i]) {
                            break;
                        }
                    }
                }
            }
            if (used < n) lion[10] -= (n - used);
            return;
        }
        if (n - used > apeach[index]) {
            lion[index] = apeach[index] + 1;
            find(index + 1, used + lion[index], n, apeach, lion);
            lion[index] = 0;
        }
        find(index + 1, used, n, apeach, lion);
    }

    private static int calc(int[] apeach, int[] lion) {
        int apeachScore = 0, lionScore = 0;
        for (int i = 0; i < 11; i++) {
            if (apeach[i] == 0 && lion[i] == 0) continue;
            if (lion[i] > apeach[i]) lionScore += (10 - i);
            else apeachScore += (10 - i);
        }
        return lionScore - apeachScore;
    }
}
