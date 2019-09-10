package com.shusx.p3_longestsubstring;

import java.util.*;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2019/9/10 16:44
 **/
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        Map<Character,Integer> charMap = new HashMap<>(s.length());
        int result = 0;
        int left = 0;
        for (int index=0;index<chars.length;index++){
            if (charMap.containsKey(chars[index])){
                // the prev index of this char
                int i = charMap.get(chars[index]);
                // if the index must greater than the left, because the value beside the left is invalid
                if (i >= left){
                    int length = index - left;
                    result = length > result ? length : result;
                    left = i + 1;
                }
            }
            charMap.put(chars[index],index);
        }
        int length = chars.length - left;
        result = length > result ? length : result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
