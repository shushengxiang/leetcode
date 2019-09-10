package com.shusx.p1_twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2019/9/10 15:04
 **/
public class Solution {

    /**
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0){
            return null;
        }

        // key is num , value is index
        Map<Integer,Integer> map = new HashMap<>();
        for (int index=0;index<nums.length;index++){
            int i = target - nums[index];
            if (map.containsKey(i)){
                return new int[]{map.get(i),index};
            }
            map.put(nums[index],index);
        }
        return null;

    }


    public static void main(String[] args) {

    }

}
