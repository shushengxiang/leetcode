package com.shusx.array.p628_maximumProduct;

public class Solution {


    /**
     * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     *
     * 给定的整型数组长度范围是[3,10000]，数组中所有的元素范围是[-1000, 1000]。
     * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        if (nums.length == 3){
            return nums[0] * nums[1] * nums[2];
        }
        int d = -1000, e = d , f = d;
        int a = 1000,b = a ,c = a;

        //  其中 d e f 分别为最大的三个，a b c 为最小的三个
        for (int index=0;index<nums.length;index++){
            if (nums[index] < a){
                c = b;
                b = a;
                a = nums[index];
            }else if (a <= nums[index] && nums[index] < b){
                c = b;
                b = nums[index];
            }else if (b <= nums[index] && nums[index] < c){
                c = nums[index];
            }

            if (nums[index] > d){
                f = e;
                e = d;
                d = nums[index];
            }else if (e < nums[index] && nums[index] <= d){
                f = e;
                e = nums[index];
            }else if (f < nums[index] && nums[index] <= e){
                f = nums[index];
            }
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);

        if (d < 0 || a > 0){
            return d * e * f;
        }else if (a < 0 && b < 0 && a * b > e * f){
            return d * a * b;
        }


        return d * e * f;
    }

    public static void main(String[] args) {
        new Solution().maximumProduct(new int[]{1,2,3,2});
    }

}
