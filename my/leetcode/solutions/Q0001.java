package my.leetcode.solutions;

import java.util.HashMap;

public class Q0001 {

    public static void main(String[] args) {

//     int[] nums = {2, 7, 11, 15};
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] r = twoSum(nums, target);
        System.out.println(r[0] + " " + r[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] r = new int[2];
        r[0] = -1;
        r[1] = -1;

        // add
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            int value = i;
            map.put(key, value);
        }
        // search
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                int value = map.get(key);
                if (value != i) {
                    r[0] = i;
                    r[1] = map.get(key);
                    break;
                }
            }
        }

        return r;
    }
}
