package com.shusx.tree.p654_maximumBinaryTree;

import com.shusx.tree.TreeNode;

/**
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 */
public class Solution {

    /**
     *
     * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
     *
     * 二叉树的根是数组中的最大元素。
     * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
     * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
     * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
     *
     * 给定的数组的大小在 [1, 1000] 之间。
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return generate(nums,0,nums.length-1);
    }

    private TreeNode generate(int[] nums,int left,int right){
        if (left > right){
            return null;
        }
        int maxIndex = getMaxIndex(nums, left, right);
        TreeNode treeNode = new TreeNode(nums[maxIndex]);
        treeNode.left = generate(nums,left,maxIndex-1);
        treeNode.right = generate(nums,maxIndex+1,right);
        return treeNode;
    }

    public int getMaxIndex(int[] nums,int left,int right){
        if (left == right){
            return left;
        }
        int max = nums[left];
        int index = left;
        for (int i = left+1;i<=right;i++) {
            if (max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

}
