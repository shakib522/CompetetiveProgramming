package src.main.kotlin.leetcode.dailyChallenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumAveragePassRatio {
    public static void main(String[] args) {

        MaximumAveragePassRatio max = new MaximumAveragePassRatio();
        double res = max.maxAverageRatio(new int[][]{
                {1,2},
                {3,5},
                {2,2},
        }, 2);
        System.out.println(res);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassRecord> pq = new PriorityQueue<>(new Compare());
        for(int[] cl:classes){
            pq.add(new ClassRecord(cl));
        }
        while (extraStudents-->0){
            pq.add(pq.remove().addOneStudent());
        }
        double sum=0;
        ClassRecord cl;
        while (!pq.isEmpty()){
            cl=pq.remove();
            sum+=(double) cl.pass/cl.total;
        }
        return sum/classes.length;
    }
}
class ClassRecord{
    int pass;
    int total;
    double inc;
    public ClassRecord(int[] array){
        pass=array[0];
        total=array[1];
        inc=getIncrement();
    }
    public ClassRecord addOneStudent(){
        pass++;
        total++;
        inc=getIncrement();
        return this;
    }
    private double getIncrement(){
        return (pass+1.0)/(total+1) - (double) pass / total;
    }
}
class Compare implements Comparator<ClassRecord> {

    @Override
    public int compare(ClassRecord o1, ClassRecord o2) {
        if (o1.inc<o2.inc){
            return 1;
        }else if(o1.inc>o2.inc){
            return -1;
        }else{
            return 0;
        }
    }
}
