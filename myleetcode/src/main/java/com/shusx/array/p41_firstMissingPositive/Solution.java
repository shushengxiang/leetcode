package com.shusx.array.p41_firstMissingPositive;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
     *
     * 输入: [1,2,0]
     * 输出: 3
     *
     * 输入: [3,4,-1,1]
     * 输出: 2
     *
     * 输入: [7,8,9,11,12]
     * 输出: 1
     *
     * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
     *
     *
     * 更好的思路：
     * 在恢复后，数组应当有 [1, 2, ..., N] 的形式，但其中有若干个位置上的数是错误的，
     * 每一个错误的位置就代表了一个缺失的正数。以题目中的示例二 [3, 4, -1, 1] 为例，恢复后的数组应当为 [1, -1, 3, 4]，我们就可以知道缺失的数为 2。
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        /**
         * 思路：
         * 最小值大于1 返回1
         * 最大值小于1 返回1
         * 最小的正数大于1 返回1
         *
         * 正常情况一个数组长度为n，那么最小的正整数一定在1 - n+1 之间，遍历这个集合在不在数组中即可
         *
         */
        if (nums == null || nums.length == 0){
            return 1;
        }
        int min = nums[0],max = nums[0],minPositive = 0;
        Set<Integer> set = new HashSet<>(nums.length+1);
        for (int i=0;i<nums.length;i++){
            if (min > nums[i]){
                min = nums[i];
            }
            if (max < nums[i]){
                max = nums[i];
            }
            if (nums[i] > 0 && (minPositive == 0 || minPositive > nums[i])){
                minPositive = nums[i];
            }
            if (nums[i] > 0 && nums[i] <= nums.length){
                set.add(nums[i]);
            }
        }
        if (min > 1 || max < 1){
            return 1;
        }
        if (minPositive > 1){
            return 1;
        }

        for (int i=2;i<=nums.length+1;i++){
            if (!set.contains(i)){
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(new int[]{1,2,0}));
    }

}
