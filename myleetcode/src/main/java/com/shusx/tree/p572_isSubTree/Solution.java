package com.shusx.tree.p572_isSubTree;

import com.shusx.tree.TreeNode;

public class Solution {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSub(s,t,true);
    }

    public boolean isSub(TreeNode s,TreeNode t,boolean e){
        if (s == null && t == null){
            return true;
        }
        if (s == null || t == null){
            return false;
        }
        boolean result = false;
        if (s.val == t.val){
            result = isSub(s.left,t.left,false);
            if (result){
                result = isSub(s.right,t.right,false);
            }
        }

        if (e && !result){
            if (s.left != null){
                result = isSubtree(s.left,t);
                if (result){
                    return result;
                }
            }
            if (s.right != null){
                result = isSubtree(s.right,t);
                if (result){
                    return result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //[3,4,5,1,2]
        //[4,1,2]
        System.out.println(solution.isSubtree(new TreeNode(new int[]{1,2,3}),new TreeNode(new int[]{1,2})));
    }
}
