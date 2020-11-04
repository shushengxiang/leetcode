package com.shusx.palindrome_number;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }else if (x<=9){
            return true;
        }else {
            if (x % 10 == 0){
                return false;
            }
            List<Integer> list = new ArrayList<>();
            int temp;
            do{
                list.add(x % 10);
            }while ((x = x / 10) != 0);
            System.out.println(list);
            for (int index=0;index<list.size()/2;index++){
                if (!list.get(index).equals(list.get(list.size()-1-index))){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(10022201));
    }



}
