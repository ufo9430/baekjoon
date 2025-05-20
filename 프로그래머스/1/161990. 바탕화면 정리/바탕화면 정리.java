import java.util.Arrays;
class Solution {
    public static int[] solution(String[] wallpaper) {
        int[] answer;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < wallpaper.length; i++) {
            String line = wallpaper[i];
            for (int j = 0; j < line.length(); j++) {
                char symbol = line.charAt(j);
                if(symbol == '#'){
                    minX = Math.min(minX,i);
                    minY = Math.min(minY,j);
                    maxX = Math.max(maxX,i+1);
                    maxY = Math.max(maxY,j+1);
                }
            }
        }
        answer = new int[]{minX, minY, maxX, maxY};
        return answer;
    }
}