package com.shusx.array.p118;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 杨辉三角
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int index=1;index<=numRows;index++){
            List<Integer> list = new ArrayList<>();
            for (int i=1;i<=index;i++){
                if (i == 1 || i == index){
                    list.add(1);
                }else {
                    List<Integer> integerList = result.get(index - 2);
                    list.add(integerList.get(i-1)+integerList.get(i-2));
                }

            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generate(5));
    }

}
