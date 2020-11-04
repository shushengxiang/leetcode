package com.shusx.array.p697_findShortestSubArray;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
     *
     * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
     *
     * 输入: [1, 2, 2, 3, 1]
     * 输出: 2
     * 解释:
     * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
     * 连续子数组里面拥有相同度的有如下所示:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * 最短连续子数组[2, 2]的长度为2，所以返回2.
     *
     * 注意:
     *
     *     nums.length 在1到50,000区间范围内。
     *     nums[i] 是一个在0到49,999范围内的整数。
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {

        // 思路： 构建一个map，k为值，v为一个数组，第一项为k出现的次数，第二项为k出现的开始位置，第三项为k出现的结束位置
        Map<Integer,int[]> map = new HashMap<>();

        for (int index=0;index<nums.length;index++){
            if (map.containsKey(nums[index])){
                int[] ints = map.get(nums[index]);
                ints[0] = ints[0] + 1;
                ints[2] = index;
            }else {
                int[] ints = new int[3];
                ints[0] = 1;
                ints[1] = index;
                map.put(nums[index],ints);
            }
        }

        int max = 1;
        for (Map.Entry<Integer,int[]> entry:map.entrySet()){
            if (entry.getValue()[0] > max){
                max =  entry.getValue()[0];
            }
        }

        if (max == 1){
            return 1;
        }

        int result = nums.length;
        for (Map.Entry<Integer,int[]> entry:map.entrySet()){
            if (entry.getValue()[0] == max){
                int i = entry.getValue()[2] - entry.getValue()[1] + 1;
                if (i < result){
                    result = i;
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findShortestSubArray(new int[]{1,2,2,3,1}));
    }

}
