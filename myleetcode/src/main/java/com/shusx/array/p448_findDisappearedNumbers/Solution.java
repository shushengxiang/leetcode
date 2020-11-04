package com.shusx.array.p448_findDisappearedNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     *
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     *
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     *
     *
     * 输入:
     * [4,3,2,7,8,2,3,1]

     * 输出:
     * [5,6]
     *
     * 新思路： 2如果存在，将[4,-3,2...]数组的第二位置为负数
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length);
        for (int num:nums){
            result.add(null);
        }
        for (int num:nums){
            result.set(num-1,1);
        }
        for (int index=0;index<result.size();index++){
            if (result.get(index) != null){
                result.set(index,null);
            }else {
                result.set(index,index+1);
            }
        }
        for (int num:nums){
            result.remove(null);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

}
