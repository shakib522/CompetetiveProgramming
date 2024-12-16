package src.main.kotlin.leetcode.dailyChallenge;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperationsI {

    public int[] getFinalState2(int[] nums, int k, int multiplier) {
        int index;
        for (int i = 0; i < k; i++) {
            index=getMin(nums);
            nums[index]=nums[index]*multiplier;
        }
        return nums;
    }
    public int getMin(int[] ara){
        int index=0;
        for (int i = 0; i < ara.length; i++) {
            if (ara[i]<ara[index]){
                index=i;
            }
        }
        return index;
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Element> pq = new PriorityQueue<>(new Cmp());
        for (int i = 0; i < nums.length; i++) {
            pq.add(new Element(nums[i], i));
        }
        while (k-- > 0 && !pq.isEmpty()) {
            Element element = pq.remove();
            element.value *= multiplier;
            pq.add(element);
        }
        while (!pq.isEmpty()) {
            Element element = pq.poll();
            nums[element.index] = element.value;
        }
        return nums;
    }
}

//class Element implements Comparable<Element> {
//    int value;
//    int index;
//
//    Element(int value, int index) {
//        this.value = value;
//        this.index = index;
//    }
//

/// /    @Override
/// /    public int compare(Element o1, Element o2) {
/// /        if (o1.value == o2.value) {
/// /            return o1.index - o2.index;
/// /        }
/// /        return o1.value - o2.value;
/// /    }
//
//    @Override
//    public int compareTo(@NotNull Element o) {
//        if (o.value == this.value) {
//            return this.index - o.index;
//        }
//        return this.value - o.value;
//    }
//}

class Element {
    int value;
    int index;

    Element(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class Cmp implements Comparator<Element> {

    @Override
    public int compare(Element o1, Element o2) {
        if (o1.value == o2.value) {
            return o1.index - o2.index;
        }
        return o1.value - o2.value;
    }
}

