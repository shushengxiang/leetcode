package com.shusx.tree;

import apple.laf.JRSUIUtils;

import java.util.HashMap;
import java.util.Map;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int[] array){
        Map<Integer,TreeNode> map = new HashMap<>();
        for (int i=0;i<array.length;i++){
            if (i == 0){
                this.val = array[0];
                map.put(i,this);
            }else {
                TreeNode node = new TreeNode(array[i]);
                int parent;
                // 左节点
                if (i % 2 != 0){
                    parent = (i-1)/2;
                    map.get(parent).left = node;
                }else{
                    parent = (i-2)/2;
                    map.get(parent).right = node;
                }
                map.put(i,node);
            }
        }
        map = null;
    }

    public String toString(){
        StringBuilder s = new StringBuilder("v:").append(val);
        if (left != null){
            s.append("[left]:").append(left.toString());
        }
        if (right != null){
            s.append("[right]:").append(right.toString());
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(new TreeNode(new int[]{1,2,3,4,5}));
    }

}
