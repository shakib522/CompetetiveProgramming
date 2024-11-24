package src.main.kotlin.leetcode.dailyChallenge;

public class RotatingTheBox {
    public static void main(String[] args) {
    }
    public char[][] rotateTheBox(char[][] box) {
        int row=box.length;
        int col=box[0].length;
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j < col; j++) {
                if (box[i][j]=='.'){
                    move(i,j,box);
                }
            }
        }
        char [][] rotateBox=new char[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = row-1; j >=0; j--) {
                rotateBox[i][row-1-j]=box[j][i];
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(rotateBox[i][j]+" ");
            }
            System.out.println();
        }
        return rotateBox;
    }
    void move(int row,int col,char[][] box){
        int exCol=col;
        for (int i = col; i >=0 ; i--) {
            if (box[row][i]=='#'){
                box[row][exCol]='#';
                box[row][i]='.';
                exCol--;
            }else if(box[row][i]=='*'){
                break;
            }
        }
    }
}
