package com.shusx.array.p485_findMaxConsecutiveOnes;

public class Solution {

    /**
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     * 输入: [1,1,0,1,1,1]
     * 输出: 3
     * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
     * 输入的数组只包含 0 和1。
     * 输入数组的长度是正整数，且不超过 10,000。
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        //short -32768~32767
        short index = 0;
        short length = 0;
        short max = 0;
        while(index < nums.length){
            if (nums[index] == 1){
                length++;
            }else {
                if (length > max){
                    max = length;
                }
                length = 0;
            }
            index++;
        }
        if (length > max){
            max = length;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }

}
