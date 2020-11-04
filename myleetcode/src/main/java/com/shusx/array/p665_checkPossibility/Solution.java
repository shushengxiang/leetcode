package com.shusx.array.p665_checkPossibility;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 * 说明：
 *
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 */
public class Solution {

    /**
     * 思路：
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * 通过一次遍历检查nums[i] > nums[i+1]个数有多少个
     * 当结果为0个时，表明当前就是一个非递减数列
     * 当结果大于1个时，则一次变化满足不了
     * 当结果为1个时，再判断当前下标的位置，如果为第一位或者倒数第二位，可以直接返回true
     *              当nums[i-1] <= nums[i+1] 或者 nums[i] < nums[i+2] 都可以满足条件
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1){
            return true;
        }
        int result = 0;
        int index = 0;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i] > nums[i+1]){
                index = i;
                result ++;
            }
        }
        if (result > 1){
            return false;
        }else if (result == 0){
            return true;
        }

        if (index == 0 || index == nums.length-2){
            return true;
        }

        if (index > 0 && index + 1 < nums.length){
            if (nums[index - 1] <= nums[index + 1]) {
                return true;
            }
        }
        if (index + 2 < nums.length){
            if (nums[index] < nums[index + 2]){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkPossibility(new int[]{1,4,1,2}));
    }
}
