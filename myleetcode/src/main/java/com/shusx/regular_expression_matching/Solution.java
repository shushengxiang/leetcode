package com.shusx.regular_expression_matching;

public class Solution {


    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     *
     *
     * aaaaaaaabbbbbb
     * [a*]: PUnit
     *
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null){
            return false;
        }
        if (!p.contains("*") && p.length() != s.length()){
            return false;
        }


        int sPoint = 0;
        int pPoint = 0;

        while(pPoint < p.length()){

            // 判断当前p字符类型，1：字母 2：. 3: *
            char pc = p.charAt(pPoint);

            C type = type(pc);
            for(;;) {
                if (pPoint + 1 < p.length()){
                    boolean plus = type.plus(type(p.charAt(pPoint + 1)));
                    if (plus){
                        pPoint++;
                    }else {
                        break;
                    }
                }else {
                    break;
                }
            }


            do{
                byte match = type.match(s.charAt(sPoint));
                if (match == (byte)-1){
                    return false;
                }else if (match == (byte)0){
                    pPoint++;
                    sPoint++;
                    break;
                }else if (match == (byte)1){
                    sPoint++;
                }else if (match == (byte)2){

                }else if (match == (byte)3){
                    if (type.multiNum > 0){
                        return false;
                    }
                    pPoint++;
                    break;
                }
            }while (sPoint < s.length());

        }

        return true;
    }

    private C type(char c){
        if (c == '.'){
            return new C(c,(byte)2);
        }else if (c == '*'){
            return new C(c,(byte)3);
        }else {
            return new C(c,(byte)1);
        }
    }

    private static class C{

        char val;

        byte type;

        boolean multi = false;

        int multiNum = 0;

        C(char val,byte type){
            this.val = val;
            this.type = type;
        }

        boolean plus(C next){
            if (next.type == (byte)3){
                multi = true;
                return true;
            }else {
                if (next.val == val && multi){
                    multiNum++;
                    return true;
                }
            }
            return false;
        }

        /**
         * @param sc
         * @return -1 不成功
         *          0 成功：表示p指针需要后移 s指针后移
         *          1 成功其为multi模式：表示p指针可以不用后移
         *          2 .*模式：成功，表示p指针需要后移
         *          3 multi 模式失败，p指针需要后移 s指针不用
         */
        byte match(char sc){
            if (type == (byte)3){
                return 0;
            }
            if (type == (byte)2){
                return multi ? (byte) 2:(byte) 0;
            }
            if (sc == val){
                if (multi){
                    multiNum--;
                    return (byte)1;
                }else {
                    return (byte)0;
                }
            }else {
                if (multi){
                    return (byte)3;
                }else {
                    return (byte)-1;
                }
            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("abc","a*abc"));
    }

}
