package com.shusx.tree.p687_longestUnivaluePath;

import com.shusx.tree.TreeNode;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 *
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 *
 */
public class Solution {

    //注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
    public int longestUnivaluePath(TreeNode root) {
        return cal(root,0);
    }

    public int cal(TreeNode root,int max){
        if (root == null){
            return 0;
        }
        int result = 0;
        if (root.left != null && root.left.val == root.val){
            result++;
            result += discovery(root.left);
        }
        if (root.right != null && root.right.val == root.val){
            result++;
            result += discovery(root.right);
        }
        if (result > max){
            max = result;
        }
        if (root.left != null){
            max = cal(root.left,max);
        }
        if (root.right != null){
            max = cal(root.right,max);
        }
        return max;
    }

    public int discovery(TreeNode node){
        int left = 0;
        int right = 0;
        if (node.left != null && node.val == node.left.val){
            left += discovery(node.left) + 1;
        }
        if (node.right != null && node.val == node.right.val){
            right += discovery(node.right) + 1;
        }
        return left > right ? left : right;
    }
}
