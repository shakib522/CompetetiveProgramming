package src.main.kotlin.leetcode.top100.javaSolution;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int total=len2+len1;
        int index=total/2;
        int index2=0;
        if (total%2==0){
            index2=(index-1);
            int n1=returnNumber(index,nums1,nums2);
            int n2=returnNumber(index2,nums1,nums2);
            return (n1+n2)/2.0;
        }else{
            return returnNumber(index,nums1,nums2);
        }
    }
    public int returnNumber(int index,int[] num1,int[] num2){
        if (num1.length<=index){
            index-= num1.length;
            return num2[index];
        }else{
            return num1[index];
        }
    }
}
