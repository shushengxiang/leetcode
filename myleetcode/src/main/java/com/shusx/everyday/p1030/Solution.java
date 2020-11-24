package com.shusx.everyday.p1030;

import java.util.*;

/**
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，
 * 其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。
 * （你可以按任何满足此条件的顺序返回答案。）
 *
 */
public class Solution {

    /**
     * 输入：R = 1, C = 2, r0 = 0, c0 = 0
     * 输出：[[0,0],[0,1]]
     * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
     *
     * 输入：R = 2, C = 2, r0 = 0, c0 = 1
     * 输出：[[0,1],[0,0],[1,1],[1,0]]
     * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
     * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
     *
     *
     * 输入：R = 2, C = 3, r0 = 1, c0 = 2
     * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
     * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
     * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
     *
     * 1 <= R <= 100
     * 1 <= C <= 100
     * 0 <= r0 < R
     * 0 <= c0 < C
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R*C][];
        Map<Integer,List<int[]>> map = new HashMap<>();
        for (int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                int v = Math.abs(r0-i) + Math.abs(c0-j);
                if (map.containsKey(v)){
                    map.get(v).add(new int[]{i,j});
                }else{
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i,j});
                    map.put(v,list);
                }
            }
        }
        int length = R+C;
        int index=0;
        for (int i=0;i<=length;i++){
            if (i == 0){
                result[index++] = new int[]{r0,c0};
                continue;
            }
            if (map.containsKey(i)){
                List<int[]> ints = map.get(i);
                for (int[] list:ints){
                    result[index++] = new int[]{list[0],list[1]};
                }
            }
        }
        return result;
    }

}
