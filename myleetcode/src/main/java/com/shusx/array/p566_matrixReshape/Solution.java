package com.shusx.array.p566_matrixReshape;


import java.util.Arrays;

/**
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 */
public class Solution {

    /**
     * 输入:
     * nums =
     * [[1,2],
     *  [3,4]]
     * r = 1, c = 4
     * 输出:
     * [[1,2,3,4]]
     * 解释:
     * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
     *
     *
     * 输入:
     * nums =
     * [[1,2],
     *  [3,4]]
     * r = 2, c = 4
     * 输出:
     * [[1,2],
     *  [3,4]]
     * 解释:
     * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
     *
     * 给定矩阵的宽和高范围在 [1, 100]。
     * 给定的 r 和 c 都是正数。
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length){
            return nums;
        }
        int[][] result = new int[r][];
        // 初始化
        for (int index=0;index<r;index++){
            result[index] = new int[c];
        }

        int i1 = 0;
        int j1 = 0;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums[i].length;j++){
                result[i1][j1] = nums[i][j];
                if (j1+1 <c){
                    j1++;
                }else if (i1 +1 < r){
                    i1++;
                    j1=0;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().matrixReshape(
                new int[][]{{1,2},{3,4}},2,2)));
    }

}
