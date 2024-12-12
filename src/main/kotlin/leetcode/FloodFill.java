package src.main.kotlin.leetcode;

import src.main.kotlin.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

//class Pair<T, U> {
//    private T first;
//    private U second;
//    public Pair(T first,U second){
//        this.first=first;
//        this.second=second;
//    }
//    public T getFirst(){
//        return first;
//    }
//    public void setFirst(T first){
//        this.first=first;
//    }
//    public U getSecond(){
//        return second;
//    }
//    public void setSecond(U second){
//        this.second = second;
//    }
//}
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    void bfs(int[][] image, int sr, int sc, int color, int oldColor) {
        int totalRow = image.length;
        int totalCol = image[0].length;
        boolean[][] vis = new boolean[image.length][image[0].length];
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        q.add(new Pair<>(sr, sc));
        int[] dir = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            Pair<Integer, Integer> val = q.poll();
            int row = val.getFirst();
            int col = val.getSecond();
            image[row][col] = color;
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dir[i];
                int nextCol = col + dir[i + 1];
                if (nextRow < totalRow && nextCol < totalCol && nextRow >= 0 && nextCol >= 0 && !vis[nextRow][nextCol] && image[nextRow][nextCol] == oldColor) {
                    q.add(new Pair<>(nextRow, nextCol));
                    vis[nextRow][nextCol] = true;
                }
            }
        }
    }

    void dfs(int[][] image, int sr, int sc, int color, int oldColor) {
        if (sr >= image.length || sc >= image[0].length || sr < 0 || sc < 0 || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = color;
        dfs(image, sr + 1, sc, color, oldColor);
        dfs(image, sr - 1, sc, color, oldColor);
        dfs(image, sr, sc + 1, color, oldColor);
        dfs(image, sr, sc - 1, color, oldColor);
    }
}
