package com.shusx.string2number;

public class Solution {

    public static int myAtoi(String str) {
        int result = 0;
        if (str == null || str.length() == 0){
            return result;
        }
        char[] chars = str.toCharArray();
        int first = 0;
        int flag = 1;
        while(first < chars.length && chars[first] == ' '){
            first++;
        }

        if (first >= chars.length){
            return 0;
        }

        if (chars[first] == '-'){
            flag = -1;
            first++;
        }else if (chars[first] == '+'){
            first++;
        }else if (chars[first] >= '0' && chars[first] <= '9'){

        }else {
            return result;
        }

        if (first >= chars.length){
            return 0;
        }

        while (first < chars.length && chars[first] >= '0' && chars[first] <= '9'){
            int value = chars[first++] - '0';
            if (result > (Integer.MAX_VALUE - value)/10){
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + value;
        }

        return result * flag;
    }

    public static void main(String[] args) {
        String str = " ";
        System.out.println(myAtoi(str));
    }

}
