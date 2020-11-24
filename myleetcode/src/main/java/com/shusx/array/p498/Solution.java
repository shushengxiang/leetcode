package com.shusx.array.p498;

import java.util.Arrays;

/**
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），
 * 请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 */
public class Solution {

    /**
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     *
     * 输出:  [1,2,4,7,5,3,6,8,9]
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        // 给定矩阵中的元素总数不会超过 100000 。
        if (matrix == null || matrix.length == 0){
            return new int[]{};
        }
        int[] result = new int[matrix.length*matrix[0].length];

        int i = 0; // 横
        int j = 0; // 纵
        int index = 0;
        int d = 1; // 1表示右上 2表示左下
        while (index < result.length){
            result[index++] = matrix[j][i];
            // 寻找下一个
            if (d == 1){
                // 往右上
                if (j-1 >=0 && i+1 < matrix[0].length){
                    i++;
                    j--;
                }else {
                    d = 2;
                    if (j == 0 && i+1 < matrix[0].length){
                        i++;
                    }else if (i+1 == matrix[0].length && j+1 < matrix.length){
                        j++;
                    }
                }
            }else if (d == 2){
                // 往左下
                if (i-1 >= 0 && j+1 < matrix.length){
                    i--;
                    j++;
                }else {
                    d = 1;
                    if (i == 0 && j+1 < matrix.length){
                        j++;
                    }else if (j+1 == matrix.length && i+1 < matrix[0].length){
                        i++;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findDiagonalOrder(new int[][]{
                {1,2,3}
        })));
    }

}
