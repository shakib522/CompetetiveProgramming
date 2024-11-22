package src.main.kotlin.leetcode;

public class CountUnguardedCellsInTheGrid {
    public static void main(String[] args) {

    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid=new int[m][n];
        for (int i = 0; i < walls.length; i++) {
            grid[walls[i][0]][walls[i][1]]=2;
        }
        for (int i = 0; i < guards.length;i++) {
            grid[guards[i][0]][guards[i][1]]=2;
        }
        int[] dir={-1,0,1,0,-1};
        for(int[] g:guards){
            for (int k = 0; k < 4; k++) {
                int x=g[0];
                int y=g[1];
                int dx=dir[k];
                int dy=dir[k+1];
                while(x+dx>=0 && x+dx<m && y+dy>=0&&y+dy<n&&grid[x+dx][y+dy]<2){
                    x+=dx;
                    y+=dy;
                    grid[x][y]=1;
                }
            }
        }
        int cnt=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
