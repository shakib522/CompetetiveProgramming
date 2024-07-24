package src.main.kotlin.cses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Labyrinth {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> square = new ArrayList<>();
        for (int i=0;i<n;i++){
            String inp=scanner.nextLine();
            square.add(i,inp);
        }
        int[][] vis = new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(square.get(i).charAt(j)=='A'){
                    if (vis[i][j]==0){
                        bfs(vis,square,i,j);
                    }
                }
            }
        }
    }
    public static void bfs(int[][]vis,ArrayList<String> square,int f,int s){
        vis[f][s]=1;
        Queue<Pairs> queue = new LinkedList<>();
        queue.add(new Pairs(f,s));
        while (!queue.isEmpty()){
            Pairs val=queue.poll();
            int i=val.first;
            int j=val.second;
            if (i<square.size()-1&& square.get(i+1).charAt(j)=='.' && vis[i+1][j]==0){
                queue.add(new Pairs(i+1,j));
                vis[i+1][j]=1;
            }
            if (i>0 && square.get(i-1).charAt(j)=='.' && vis[i-1][j]==0){
                queue.add(new Pairs(i-1,j));
                vis[i-1][j]=1;
            }
            if (j>0 && square.get(i).charAt(j-1)=='.'&& vis[i][j-1]==0){
                queue.add(new Pairs(i,j-1));
                vis[i][j-1]=1;
            }
            if (j< square.get(0).length()-1 && square.get(i).charAt(j+1)=='.'&& vis[i][j+1]==0) {
                queue.add(new Pairs(i,j+1));
                vis[i][j+1]=1;
            }
        }

    }
}
class P{
    int first;
    int second;
    P(int first,int second){
        this.first=first;
        this.second=second;
    }
}