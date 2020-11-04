package com.shusx.array.p414_thirdMax;


/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 */
public class Solution {

    /**
     * 输入: [2, 2, 3, 1]
     *
     * 输出: 1
     *
     * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
     * 存在两个值为2的数，它们都排第二。
     *
     * @param nums 构建最大树
     * @return
     */
    public int thirdMax(int[] nums) {
        Integer a=null;
        Integer b=null;
        Integer c=null;
        for (int index=0;index<nums.length;index++){
            if (a == null || nums[index] > a){
                c = b;
                b = a;
                a = nums[index];
            }else if (nums[index] < a && (b == null || nums[index] > b ) ){
                c = b;
                b = nums[index];
            }else if (b != null && nums[index] < b && (c == null || nums[index] > c ) ){
                c = nums[index];
            }
        }

        return c == null ? a : c;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().thirdMax(new int[]{2,2,3,1}));
    }


}