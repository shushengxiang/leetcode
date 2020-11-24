package com.shusx.tree.p563;

public class Solution {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public int findTilt(TreeNode root) {
        return cal(root);
    }

    public int cal(TreeNode node){
        int v=0;
        if (node == null){
            return 0;
        }
        if (node.left == null && node.right == null){
            return 0;
        }else if (node.left != null && node.right != null){
            v = Math.abs(sumNode(node.left) - sumNode(node.right));
            v += cal(node.left);
            v += cal(node.right);
        }else {
            if (node.left != null){
                v = sumNode(node.left);
                v += cal(node.left);
            }else {
                v = sumNode(node.right);
                v += cal(node.right);
            }
        }
        return v;
    }

    public int sumNode(TreeNode node){
        int sum = 0;
        sum += node.val;
        if (node.left != null){
            sum += sumNode(node.left);
        }
        if (node.right != null) {
            sum += sumNode(node.right);
        }
        return sum;
    }

}
