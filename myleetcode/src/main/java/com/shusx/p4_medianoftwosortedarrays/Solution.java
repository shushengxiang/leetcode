package com.shusx.p4_medianoftwosortedarrays;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2019/9/10 18:10
 **/
public class Solution {

    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int[] nums = new int[nums1.length + nums2.length];
        int index = 0;
        while (i<nums1.length || j<nums2.length){
            if (i == nums1.length){
                nums[index++] = nums2[j++];
                continue;
            }
            if (j == nums2.length){
                nums[index++] = nums1[i++];
                continue;
            }

            if (nums1[i] < nums2[j]){
                nums[index++] = nums1[i++];
            }else {
                nums[index++] = nums2[j++];
            }
        }

        if (nums.length % 2 == 1){
            return nums[(nums.length - 1) / 2];
        }

        int medianIndex = nums.length / 2;

        return (double) (nums[medianIndex] + nums[medianIndex - 1]) / 2;

    }

}
