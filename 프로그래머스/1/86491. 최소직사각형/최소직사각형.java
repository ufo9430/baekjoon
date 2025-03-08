class Solution {
    public int solution(int[][] sizes) {
        int maxhei = 0;
        int maxlen = 0;
        for (int i = 0; i < sizes.length; i++) {
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);

            maxhei = Math.max(maxhei, height);
            maxlen = Math.max(maxlen, width);
        }
        int answer = maxhei * maxlen;
        return answer;
    }
}