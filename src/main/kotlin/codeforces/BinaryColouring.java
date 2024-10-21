package src.main.kotlin.codeforces;

import java.util.Scanner;

public class BinaryColouring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i=0;i<t;i++){
            long x=scanner.nextLong();
            int[] result =new int[31];
            for (int j=0;j<30;j++){
                if ((x& (1L<<j))!=0){
                    if (result[j]==1){
                        result[j+1]=1;
                        result[j]=0;
                    }else if (j>0){
                        if (result[j-1]==1){
                            result[j-1]=-1;
                            result[j+1]=1;
                        }else{
                            result[j]=1;
                        }
                    }else {
                        result[j]=1;
                    }
                }
            }
            System.out.println(31);
            for (int k=0;k<31;k++){
                System.out.print(result[k]+" ");
            }
            System.out.println();
        }
    }
}
