package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of integers nums and an integer target, return indices of the two
 * numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * */
public class TwoSum {

    public static void main(String[] args) {

        int nums[] = {2,7,11,15};
        int[] ans = indexOfSum(nums,9);
        System.out.println(ans[0] +""+ans[1] );
    }

    private static int[] indexOfSum(int nums[],int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = {-1,-1};
        for(int i=0;i< nums.length;i++) {
            if(map.containsKey(target-nums[i])) {
                ans[0] = map.get(target-nums[i]);
                ans[1] = i;
            } else {
                map.put(nums[i],i);
            }
        }

        return ans;
    }
}