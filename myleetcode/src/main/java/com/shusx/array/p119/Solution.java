package com.shusx.array.p119;

import java.util.ArrayList;
import java.util.List;

/**
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class Solution {

    // 思路 因为杨辉三角前一半和后一半是一样的，即可存储一半值即可
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0){
            List<Integer> result = new ArrayList<>();
            result.add(1);
            return result;
        }
        if (rowIndex == 1){
            List<Integer> result = new ArrayList<>();
            result.add(1);
            result.add(1);
            return result;
        }
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        for (int index=2;index<=rowIndex;index++){
            // 一半的个数
            int i = (index+1) % 2 == 0 ? (index+1) / 2 : (index+1) / 2 + 1;
            int j = 0 ;
            while(j<i){
                if (j==0){
                    list2.add(1);
                }else {
                    list2.add(getValue(list1,index,j));
                }
                j++;
            }
            list1 = new ArrayList<>(list2);
            list2 = new ArrayList<>();
        }

        // 补上后面的值
        for (int index = (rowIndex+1)/2;index>0;index--){
            list1.add(list1.get(index-1));
        }

        return list1;
    }

    private int getValue(List<Integer> list,int length,int index){
        Integer i1 = list.get(index - 1);
        int i = length % 2 == 0 ? length / 2 : length / 2 + 1;
        if (index < i){
            return  i1 + list.get(index);
        }
        return i1 + list.get(length - 1 - index - length % 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getRow(2));
    }

}
