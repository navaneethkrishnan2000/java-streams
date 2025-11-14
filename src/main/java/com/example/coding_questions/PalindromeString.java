package com.example.coding_questions;

public class PalindromeString {
    public static void main(String[] args) {

        String s = "madam";

        // 1
        String reversed = new StringBuilder(s).reverse().toString();
        System.out.println(s.equals(reversed));

        // 2
        String orgString = s;
        String rev = "";

        for (int i=s.length()-1; i >= 0; i--) {
            rev += s.charAt(i);
        }

        System.out.println(s.equals(rev));
    }
}
