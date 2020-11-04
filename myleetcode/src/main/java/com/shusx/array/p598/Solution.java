package com.shusx.array.p598;


/**
 * 给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
 *
 * 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，
 * 含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
 *
 * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
 *
 * 注意:
 *
 * m 和 n 的范围是 [1,40000]。
 * a 的范围是 [1,m]，b 的范围是 [1,n]。
 * 操作数目不超过 10000。
 */
public class Solution {

    /**
     * 输入:
     * m = 3, n = 3
     * operations = [[2,2],[3,3]]
     * 输出: 4
     * 解释:
     * 初始状态, M =
     * [[0, 0, 0],
     *  [0, 0, 0],
     *  [0, 0, 0]]
     *
     * 执行完操作 [2,2] 后, M =
     * [[1, 1, 0],
     *  [1, 1, 0],
     *  [0, 0, 0]]
     *
     * 执行完操作 [3,3] 后, M =
     * [[2, 2, 1],
     *  [2, 2, 1],
     *  [1, 1, 1]]
     *
     * M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
     *
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int maxCount(int m, int n, int[][] ops) {


        // 只需要找到最小的ops中的操作数就行，这个属于公共部分，都会加1，其值一定是最大的
        if (ops.length == 0){
            return m*n;
        }

        int minA = m;
        int minB = n;
        int index = 0;
        while (index < ops.length){
            if (minA > ops[index][0]){
                minA = ops[index][0];
            }
            if (minB > ops[index][1]){
                minB = ops[index][1];
            }

            index++;
        }

        return minA*minB;


//        int[][] array = new int[m][];
//        // 初始化
//        for (int i=0;i<m;i++){
//            array[i] = new int[n];
//            for (int j=0;j<n;j++){
//                array[i][j] = 0;
//            }
//        }
//        for (int index=0;index<ops.length;index++){
//            int a = ops[index][0];
//            int b = ops[index][1];
//            for (int i=0;i<a;i++){
//                for (int j=0;j<b;j++){
//                    array[i][j] += 1;
//                }
//            }
//        }
//
//        int i = 0;
//        int j = 0;
//        int max = array[0][0];
//
//        while (i<m){
//            if (array[i][0] < max){
//                break;
//            }
//            i++;
//        }
//
//        while (j<n){
//            if (array[0][j] < max){
//                break;
//            }
//            j++;
//        }
//
//        return i * j;
    }

    public static void main(String[] args) {
        int[][] ops = new int[2][];
        ops[0] = new int[]{2,2};
        ops[1] = new int[]{3,3};

        System.out.println(new Solution().maxCount(3,3,ops));
    }

}
