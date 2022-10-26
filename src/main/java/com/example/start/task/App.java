package com.example.start.task;

public class App {
    public static void main(String[] args) {
        f(3);
    }

    static int f(int n) {
        int result;
        if (n == 0 || n == 1) {
            result = n;
        } else {
            result = f(n - 1) + f(n - 2);
        }
        System.out.print(n);
        return result;
    }
}