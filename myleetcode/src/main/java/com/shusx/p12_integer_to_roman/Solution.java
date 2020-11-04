package com.shusx.p12_integer_to_roman;

public class Solution {

    public String intToRoman(int num) {
        switch (num){
            case 4:
                return "IV";
            case 9:
                return "IX";
            case 40:
                return "XL";
            case 90:
                return "LX";
            case 400:
                return "CD";
            case 900:
                return "CM";
        }

        StringBuilder result = new StringBuilder();

        if (num >= 1000){
            do{
                num -= 1000;
                result.append("M");
            }while(num >= 1000);
        }

        if (num >= 500){
            if (num >= 900){
                num -= 900;
                result.append("CM");
            }else {
                do{
                    num -= 500;
                    result.append("D");
                }while(num >= 500);
            }
        }

        if (num >= 100){
            if (num >= 400){
                num -= 400;
                result.append("CD");
            }else {
                do{
                    num -= 100;
                    result.append("C");
                }while(num >= 100);
            }
        }

        if (num >= 50){
            if (num >= 90){
                num -= 90;
                result.append("XC");
            }else {
                do{
                    num -= 50;
                    result.append("L");
                }while(num >= 50);
            }
        }

        if (num >= 10){
            if (num >= 40){
                num -= 40;
                result.append("XL");
            }else {
                do{
                    num -= 10;
                    result.append("X");
                }while(num >= 10);
            }
        }

        if (num >= 5){
            if (num >= 9){
                num -= 9;
                result.append("IX");
            }else {
                do{
                    num -= 5;
                    result.append("V");
                }while(num >= 5);
            }
        }

        if (num >= 1){
            if (num >= 4){
                num -= 4;
                result.append("IV");
            }else {
                do{
                    num -= 1;
                    result.append("I");
                }while(num >= 1);
            }
        }

        return result.toString();

    }


    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(1994));
    }

}
