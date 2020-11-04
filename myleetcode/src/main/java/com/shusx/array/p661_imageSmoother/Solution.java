package com.shusx.array.p661_imageSmoother;

/**
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
 * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 *
 */
public class Solution {

    /**
     * 输入:
     * [[1,1,1],
     *  [1,0,1],
     *  [1,1,1]]
     * 输出:
     * [[0, 0, 0],
     *  [0, 0, 0],
     *  [0, 0, 0]]
     * 解释:
     * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
     * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
     * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
     *
     * @param M
     * @return
     */
    public int[][] imageSmoother(int[][] M) {

        //
        //注意:
        //给定矩阵中的整数范围为 [0, 255]。
        //矩阵的长和宽的范围均为 [1, 150]。
        //
        int[][] result = new int[M.length][];
        for (int i=0;i<M.length;i++){
            result[i] =  new int[M[i].length];
            for (int j=0;j<M[i].length;j++){
                result[i][j] = getValue(i,j,M);
            }
        }
        return result;
    }

    private int getValue(int i,int j,int[][] M){
        int total = M[i][j];
        int length = 1;
        if (i>0){
            length++;
            total += M[i-1][j];
        }
        if (j>0){
            length++;
            total += M[i][j-1];
        }
        if (i>0 & j>0){
            length++;
            total += M[i-1][j-1];
        }
        if (i+1 < M.length){
            length++;
            total += M[i+1][j];
        }
        if (j+1 < M[i].length){
            length++;
            total += M[i][j+1];
        }
        if (i+1 < M.length && j+1 < M[i].length){
            length++;
            total += M[i+1][j+1];
        }
        if (i>0 & j+1 < M[i].length){
            length++;
            total += M[i-1][j+1];
        }
        if (j>0 & i+1 < M.length){
            length++;
            total += M[i+1][j-1];
        }
        return total / length;
    }

}
