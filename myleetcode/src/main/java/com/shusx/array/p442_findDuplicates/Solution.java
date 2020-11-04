package com.shusx.array.p442_findDuplicates;

import java.util.LinkedList;
import java.util.List;

public class Solution {


    /**
     * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
     *
     * 找到所有出现两次的元素。
     *
     * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
     *
     * 输入:
     * [4,3,2,7,8,2,3,1]
     *
     * 输出:
     * [2,3]
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int index=0;index<nums.length;index++){
            int i = Math.abs(nums[index]) - 1;
            int j = nums[i];
            if (j < 0){
                result.add(Math.abs(nums[index]));
            } else {
                nums[i] = j * -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }

}
