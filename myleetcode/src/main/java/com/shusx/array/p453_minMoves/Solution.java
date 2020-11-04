package com.shusx.array.p453_minMoves;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
 *
 * 输入:
 * [1,2,3]
 *
 * 输出:
 * 3
 *
 * 解释:
 * 只需要3次移动（注意每次移动会增加两个元素的值）：
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 */
public class Solution {

    /**
     * 思路：先将数组排序，然后将前n-1个数+1，当nums[n-1]大于nums[n]时，将nums[n]往前移动
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        if (nums.length == 2){
            return Math.abs(nums[0]-nums[1]);
        }
        Arrays.sort(nums);
        if (nums[0] == nums[nums.length-2]){
            return nums[nums.length-1] - nums[0];
        }
        int result = 0;
        while (nums[0] != nums[nums.length-1]){
            result++;
            for (int i=0;i<nums.length-1;i++){
                nums[i] = nums[i] + 1;
            }
            int index = nums.length-1;
            while(nums[nums.length-1] < nums[index-1]){
                index--;
            }
            if (index != nums.length-1){
                int temp = nums[nums.length-1];
                nums[nums.length-1] = nums[index];
                nums[index] = temp;
            }
            if (nums[0] == nums[nums.length-2]){
                return nums[nums.length-1] - nums[0] + result;
            }
        }
        return result;
    }

    /**
     * 分而治之
     * 思路：
     * 如：[1,4,2,3]
     * 先将 [1,4] => 经过3步 => [4,4] => 此时第三位也应该经过3步后变为2+3=5 => [4,4,5] => 经过1步 => [5,5,5] => 此时第四位的3也因经过3+1步变为 3+4 = 7
     *     => [5,5,5,7] => 经过2步 => [7,7,7,7] : total = 3+1+4 = 7
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        if (nums.length == 2){
            return Math.abs(nums[0]-nums[1]);
        }
        Arrays.sort(nums);
        int result = 0;
        for (int index=1;index<nums.length;index++){
            // 当前的值
            int value = nums[index] + result;
            // 经过了多少步
            result += value - nums[0];
            // 第一个值需要变换
            nums[0] = value;
        }

        return result;
    }


    /**
     * 分而治之
     * 思路：
     * 如：[2,4,1,3]
     * 先将 [2,4] => 经过2步 => [4,4] =>  此时第三位也应该经过2步后变为1+2=3 => [4,4,3] => 此时因为3<4 将3换到第一位 => [3,4,4]
     *      [3,4] => 经过1步 => [4,4] =>  此时第三位也应该经过1步后变为4+1=5 => [4,4,5]
     *      [4,4,5] => 经过1步 => [5,5,5] => 此时第四位的3也因经过2+1+1步变为 = 7 => [5,5,5,7]
     *     [5,5,5,7] => 经过2步 => [7,7,7,7] : total = 3+1+4 = 7
     * @param nums
     * @return
     */
    public int minMoves3(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        if (nums.length == 2){
            return Math.abs(nums[0]-nums[1]);
        }

        return cal(nums.length,nums);
    }

    private int cal(int length,int[] nums){
        int result = 0;

        for (int index=1;index<length;index++){
            // 当前的值
            int value = nums[index] + result;
            nums[index] = value;

            if (nums[0] > value){
                nums[index] = nums[0];
                nums[0] = value;
                result += cal(index + 1,nums);
            }else {
                // 经过了多少步
                result += value - nums[0];
                // 第index-1值需要变换
                int i = index;
                do{
                    nums[--i] = value;
                }while (i>0);
            }

        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().minMoves3(new int[]{83,86,77,15,93,35,86,92,49,21}));
    }




}
