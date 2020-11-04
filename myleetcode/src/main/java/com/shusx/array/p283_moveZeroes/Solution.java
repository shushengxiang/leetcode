package com.shusx.array.p283_moveZeroes;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class Solution {

    /**
     * 思路： 遇到0往后移，如果下一个不是0则交换，如果下一个也是0则增加需要移动0的个数
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int zeroLength = 0;
        for (int index=0;index<nums.length;index++){
            if (nums[index] == 0){
                zeroLength++;
                // 需要往后移动
                while (index+1<nums.length && nums[index+1] != 0){
                    nums[index - zeroLength + 1] = nums[index+1];
                    nums[index+1] = 0;
                    index++;
                }
            }else {
                zeroLength = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
