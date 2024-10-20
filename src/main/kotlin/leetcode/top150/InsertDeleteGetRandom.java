package src.main.kotlin.leetcode.top150;

import java.util.*;

public class InsertDeleteGetRandom {
    class RandomizedSet {
        Map<Integer, Integer> map;
        Random random;
        List<Integer> list;

        public RandomizedSet() {
            map = new HashMap<>();
            random = new Random();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                list.add(val);
                map.put(val, list.size() - 1);
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int index = map.get(val);
                Collections.swap(list, index, list.size() - 1);
                map.put(list.get(index), index);
                list.remove(list.size() - 1);
                map.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
