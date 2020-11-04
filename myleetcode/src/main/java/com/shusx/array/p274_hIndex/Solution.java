package com.shusx.array.p274_hIndex;

import java.util.Map;

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
 * （其余的 N - h 篇论文每篇被引用次数 不超过 h 次。）
 *
 * 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
 *
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 *
 * 提示：如果 h 有多种可能的值，h 指数是其中最大的那个。
 */
public class Solution {


    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0){
            return 0;
        }
        for (int i = citations.length;i>0;i--){
            int total = 0;
            for (int j=0;j<citations.length;j++){
                if (citations[j] >= i){
                    total++;
                    if (total >= i){
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    public int hIndex2(int[] citations) {
        // 使用数组作为字典
        if (citations == null || citations.length == 0){
            return 0;
        }
        int[] nums = new int[citations.length];
        for (int i=0;i<citations.length;i++){
            nums[i] = 0;
        }
        for (int i=0;i<citations.length;i++){
            if (citations[i] <= 0){
                continue;
            }
            // 比数组长度大的数都放在最后一个
            if (citations[i] >  citations.length){
                nums[citations.length - 1] = nums[citations.length - 1] + 1;
            }else {
                nums[citations[i] - 1] = nums[citations[i] - 1] + 1;
            }
        }

        int total = 0;
        for (int i=citations.length;i>0;i--){
            total += nums[i-1];
            if (total >= i){
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hIndex2(new int[]{3,0,6,1,5}));
    }

}
