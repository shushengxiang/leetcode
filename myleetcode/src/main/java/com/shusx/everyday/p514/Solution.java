package com.shusx.everyday.p514;

import java.util.Arrays;

public class Solution {

    public int findRotateSteps(String ring, String key) {
        System.out.println(key.length());
        // 开始匹配
        int i=0;
        int[] result = new int[2];
        int[] r = new int[1];
        find(i,key,ring,result,r);
        return r[0];
    }

    // 0 表示 需要的总步数 1 表示 head数
    public void find(int i,String key,String ring,int [] result,int[] r){
        if (key.length() <= i){
            if (r[0] == 0){
                r[0] = result[0];
            }else{
                if (result[0] < r[0]){
                    r[0] = result[0];
                }
            }
            System.out.println(i+":"+Arrays.toString(result)+":"+Arrays.toString(r));
            return;
        }
        // 右边
        char c = key.charAt(i);
        int[] r1 = new int[2];
        r1[0] = result[0];
        r1[1] = result[1];

        if (r[0] != 0 && result[0] > r[0]){
            return;
        }

        int index = r1[1];
        for (int j=0;j<ring.length();j++){
            if (ring.charAt(index) == c){
                //头
                result[1] = index;
                result[0] += j+1;
                break;
            }
            index++;
            if (index == ring.length()){
                index = 0;
            }
        }
        find(i+1,key,ring,result,r);

        // 左边
        index = r1[1];
        for (int j=0;j<ring.length();j++){
            if (ring.charAt(index) == c){
                //头
                r1[1] = index;
                r1[0] += j+1;
                break;
            }
            index--;
            if (index < 0){
                index = ring.length()-1;
            }
        }

        // 下一个
        find(i+1,key,ring,r1,r);
    }

    public static void main(String[] args) {

        System.out.println(new Solution().findRotateSteps("tbifw",
                "bfitw"));
    }


}
