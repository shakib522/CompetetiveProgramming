package src.main.kotlin.leetcode.top100.javaSolution;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int[] mergeAra = new int[len1+len2];
        int ptr1=0;
        int ptr2=0;
        int ptr3=0;
        while (ptr1<len1&&ptr2<len2){
            if (nums1[ptr1]<nums2[ptr2]){
                mergeAra[ptr3]=nums1[ptr1];
                ptr1++;
            }else{
                mergeAra[ptr3]=nums2[ptr2];
                ptr2++;
            }
            ptr3++;
        }
        while (ptr1<len1){
                mergeAra[ptr3]=nums1[ptr1];
                ptr1++;
                ptr3++;
        }
        while (ptr2<len2){
            mergeAra[ptr3]=nums2[ptr2];
            ptr2++;
            ptr3++;
        }
        double ans=0.0;
        int mid=(len1+len2)/2;
        if (((len1+len2)&1)==0){
            ans = (mergeAra[mid]+mergeAra[mid-1])/2.0;
        }else{
            ans=mergeAra[mid];
        }
        return ans;
    }
}
