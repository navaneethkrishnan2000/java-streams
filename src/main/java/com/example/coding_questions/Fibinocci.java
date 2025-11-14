package com.example.coding_questions;

public class Fibinocci {
    public static void main(String[] args) {

        int num = 10;
        int n1=0, n2=1, sum=0;
        System.out.print(n1 + " " + n2);

        for (int i=0; i<=num; i++) {
            sum = n1+n2;
            System.out.print(" " + sum);
            n1=n2;
            n2=sum;
        }
    }
}
