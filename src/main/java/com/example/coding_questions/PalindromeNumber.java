package com.example.coding_questions;

public class PalindromeNumber {
    public static void main(String[] args) {

        int num = 363;
        int orgNum = num;
        int rev = 0;

        while (num > 0) {
            rev=rev*10+num%10;
            num/=10;
        }

        System.out.println(orgNum == rev);

    }
}
