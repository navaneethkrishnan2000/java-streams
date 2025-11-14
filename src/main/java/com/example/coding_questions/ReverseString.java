package com.example.coding_questions;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Apple";
        String rev="";

        for (int i=s.length()-1; i>=0; i--) {
            rev += s.charAt(i);
        }

        System.out.println(rev);
    }
}
