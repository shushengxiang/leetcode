package com.shusx.array.p396_maxRotateFunction;

/**
 * 给定一个长度为 n 的整数数组 A 。
 *
 * 假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：
 *
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
 *
 * 计算F(0), F(1), ..., F(n-1)中的最大值。
 *
 * 注意:
 * 可以认为 n 的值小于 105。
 */
public class Solution {
    /**
     * A = [4, 3, 2, 6]
     *
     * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
     * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
     * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
     * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
     *
     * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26
     *
     */

    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int index=0;index<A.length;index++){
            int total = f(A,index);
            if (max < total){
                max = total;
            }
        }
        return max;
    }

    private int f(int[] A,int k){
        int total = 0;
        for (int index=0;index<A.length;index++){
            total += A[index] * ((k+index)%A.length);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxRotateFunction(new int[]{-2147483648,-2147483648}));
    }
}
