package src.main.kotlin.leetcode.top100.javaSolution;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] mergeAra = new int[len1 + len2];
        int ptr1 = 0;
        int ptr2 = 0;
        int ptr3 = 0;
        while (ptr1 < len1 && ptr2 < len2) {
            if (nums1[ptr1] < nums2[ptr2]) {
                mergeAra[ptr3] = nums1[ptr1];
                ptr1++;
            } else {
                mergeAra[ptr3] = nums2[ptr2];
                ptr2++;
            }
            ptr3++;
        }
        while (ptr1 < len1) {
            mergeAra[ptr3] = nums1[ptr1];
            ptr1++;
            ptr3++;
        }
        while (ptr2 < len2) {
            mergeAra[ptr3] = nums2[ptr2];
            ptr2++;
            ptr3++;
        }
        double ans = 0.0;
        int mid = (len1 + len2) / 2;
        if (((len1 + len2) & 1) == 0) {
            ans = (mergeAra[mid] + mergeAra[mid - 1]) / 2.0;
        } else {
            ans = mergeAra[mid];
        }
        return ans;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            findMedianSortedArrays2(nums2, nums1);
        }
        int low = 0, high = n1;
        int left = (n1 + n2 + 1) / 2;
        int n = n1 + n2;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];
            if (l1 <= r2 && l2 <= r1) {
                if ((n %2) == 1) return Math.max(l1, l2);
                return ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2){
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0.0;
    }
}
