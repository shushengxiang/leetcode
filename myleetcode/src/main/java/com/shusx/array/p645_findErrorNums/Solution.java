package com.shusx.array.p645_findErrorNums;

import java.util.Arrays;

public class Solution {


    /**
     * 给定一个数组 nums 代表了集合 S [1,N] 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
     *
     * 输入: nums = [1,2,2,4]
     * 输出: [2,3]
     *
     * 注意:
     *
     * 给定数组的长度范围是 [2, 10000]。
     * 给定的数组是无序的。
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {

        // 思路： 构建一个bitmap
        byte[] bitmap = new byte[nums.length % 7 == 0 ? nums.length / 7 : nums.length / 7 + 1];

        int[] result = new int[2];

        for (short index=0;index<nums.length;index++){
            int i = (nums[index] - 1) / 7;
            byte b = bitmap[i];
            switch (nums[index] % 7){
                case 1:
                    if ((b & 1) == 1){
                        result[0] = nums[index];
                    }
                    bitmap[i] = (byte)(b | 1);
                    break;
                case 2:
                    if ((b & 2) == 2){
                        result[0] = nums[index];
                    }
                    bitmap[i] = (byte)(b | 2);
                    break;
                case 3:
                    if ((b & 4) == 4){
                        result[0] = nums[index];
                    }
                    bitmap[i]= (byte)(b | 4);
                    break;
                case 4:
                    if ((b & 8) == 8){
                        result[0] = nums[index];
                    }
                    bitmap[i] = (byte)(b | 8);
                    break;
                case 5:
                    if ((b & 16) == 16){
                        result[0] = nums[index];
                    }
                    bitmap[i] = (byte)(b | 16);
                    break;
                case 6:
                    if ((b & 32) == 32){
                        result[0] = nums[index];
                    }
                    bitmap[i] = (byte)(b | 32);
                    break;
                case 0:
                    if ((b & 64) == 64){
                        result[0] = nums[index];
                    }
                    bitmap[i] = (byte)(b | 64);
                    break;
            }

        }

        for (short index=0;index<bitmap.length;index++){
            if (bitmap[index] == 127){
                continue;
            }
            if ((bitmap[index] & 1) != 1){
                result[1] = index * 7 + 1;
                break;
            }
            if ((bitmap[index] & 2) != 2){
                result[1] = index * 7 + 2;
                break;
            }
            if ((bitmap[index] & 4) != 4){
                result[1] = index * 7 + 3;
                break;
            }
            if ((bitmap[index] & 8) != 8){
                result[1] = index * 7 + 4;
                break;
            }
            if ((bitmap[index] & 16) != 16){
                result[1] = index * 7 + 5;
                break;
            }
            if ((bitmap[index] & 32) != 32){
                result[1] = index * 7 + 6;
                break;
            }
            if ((bitmap[index] & 64) != 64) {
                result[1] = index * 7 + 7;
                break;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findErrorNums(new int[]{1,2,2,4})));
//        System.out.println(-65 | 64);
//        System.out.println(-0b10000000);
    }

}
