package com.shusx.array.p57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class Solution {

    /**
     * 示例 1：
     *
     * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出：[[1,5],[6,9]]
     * 示例 2：
     *
     * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出：[[1,2],[3,10],[12,16]]
     * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
     *  
     *
     * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0){
            return intervals;
        }
        if (intervals == null || intervals.length == 0){
            intervals = new int[1][];
            intervals[0] = newInterval;
            return intervals;
        }

        int[][] result = new int[intervals.length+1][];

        if (newInterval[1] < intervals[0][0]){
            result[0] = newInterval;
            int index = 0;
            while(index < intervals.length){
                result[index + 1] = intervals[index];
                index++;
            }
            return result;
        }

        if (newInterval[0] > intervals[intervals.length-1][1]){
            result[intervals.length] = newInterval;
            int index = 0;
            while(index < intervals.length){
                result[index] = intervals[index];
                index++;
            }
            return result;
        }


        // 思路：双指针，分别找到对应的位置，再判断是否需要合并
        int index = 0;
        int iindex = 0;
        int jindex = 0;
        while(index < intervals.length){
            if (intervals[index][0] < newInterval[0]){
                iindex = index;
                jindex = index;
            }else {
                if (intervals[index][0] < newInterval[1]){
                    jindex = index;
                }
            }
            index++;
        }

        List<int[]> list = new ArrayList<>();
        index = 0;
        while (index < intervals.length){
            if (iindex > index){
                list.add(intervals[index++]);
            }else if (index > jindex){
                list.add(intervals[index++]);
            }else {
                if (newInterval[0] > intervals[iindex][1]){
                    list.add(intervals[iindex]);
                    iindex++;
                }
                int[] array = new int[2];
                array[0] = intervals[iindex][0] <= newInterval[0] ? intervals[iindex][0]:newInterval[0];

                if (newInterval[1] < intervals[jindex][0]){
                    jindex--;
                }else {
                    if (jindex+1 < intervals.length && newInterval[1] == intervals[jindex+1][0]){
                        jindex++;
                    }
                }
                array[1] = intervals[jindex][1] < newInterval[1] ? newInterval[1]:intervals[jindex][1];
                list.add(array);
                index = jindex+1;
            }
        }

        result = new int[list.size()][];
        index = 0;
        while (index<list.size()){
            result[index] = list.get(index++);
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(new Solution().insert(
//                new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{4,8})));
        System.out.println(Arrays.deepToString(new Solution().insert(
                new int[][]{{1,5},{6,8}},new int[]{3,7})));
    }

}
