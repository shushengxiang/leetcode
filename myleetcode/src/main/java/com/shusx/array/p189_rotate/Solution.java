package com.shusx.array.p189_rotate;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Solution  {

    // 时间 O(kn)
    public void rotate(int[] nums, int k) {
        int index = 0;
        while (index < k){
            int temp = nums[0];
            for (int i=0;i<nums.length;i++){
                if (i == nums.length - 1){
                    nums[0] = temp;
                }else {
                    int t = nums[i+1];
                    nums[i+1] = temp;
                    temp = t;
                }
            }
            index++;
        }
    }

    public void rotate1(int[] nums, int k) {
        if (k == 0){
            return;
        }
        int temp = nums[0];
        if (nums.length % k == 0){
            for (int i=0;i<k;i++){
                int index = i;
                temp = nums[i];
                for (int j=0;j<nums.length/k;j++){
                    int next = (index + k) % nums.length;
                    int t = nums[next];
                    nums[next] = temp;
                    temp = t;
                    index += k;
                }
            }
        }else {
            int index = 0;
            for (int i=0;i<nums.length;i++){
                int next = (index + k) % nums.length;
                int t = nums[next];
                nums[next] = temp;
                temp = t;
                index += k;
            }
        }

    }


    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6};
        new Solution().rotate1(ints,4);
        System.out.println(Arrays.toString(ints));
    }

}
