package src.main.kotlin;

public class BitWiseAndOfNumberRange {

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(1,2147483647));
    }
    public static int rangeBitwiseAnd(int left, int right) {
        long ans=left;
        for (long i=left;i<=right;i++){
            System.out.println(i);
            System.out.println("loop");
            ans= ans& left;
            if (ans==0){
                return 0;
            }
        }
        return (int)ans;
    }
}
