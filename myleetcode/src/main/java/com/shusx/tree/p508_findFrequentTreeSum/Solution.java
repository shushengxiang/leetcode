package com.shusx.tree.p508_findFrequentTreeSum;

import com.shusx.tree.TreeNode;

import java.util.*;

/**
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。
 * 一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 你需要返回出现次数最多的子树元素和。
 * 如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 */
public class Solution {

    /**
     * 输入:
     *
     *   5
     *  /  \
     * 2   -3
     * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
     *
     * 输入：
     *
     *   5
     *  /  \
     * 2   -5
     * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
     *
     *
     * 假设任意子树元素和均可以用 32 位有符号整数表示。
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        getSum(root,map);
        int max = 1;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue() > max){
                max = entry.getValue();
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()  == max){
                list.add(entry.getKey());
            }
        }
        int[] result = new int[list.size()];
        for (int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public int getSum(TreeNode root, Map<Integer,Integer> map){
        if (root == null){
            return 0;
        }
        int sum = root.val;
        if (root.left != null){
            sum += getSum(root.left,map);
        }
        if (root.right != null){
            sum += getSum(root.right,map);
        }
        if (map.containsKey(sum)){
            map.put(sum,map.get(sum)+1);
        }else{
            map.put(sum,1);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(-5);
        t1.left = t2;
        t1.right = t3;
        System.out.println(Arrays.toString(new Solution().findFrequentTreeSum(t1)));
    }
}
