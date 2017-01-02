package com.vadimozarinskiy.Task2;

/**
 * Created by Vadim Ozaronskiy on 28.12.16.
 */
public class Polynomial {

    public static void main(String[] args) {
        int n = 4;
        int a = 3;
        int b = 5;
        printBinomenal(n, a, b);
    }

    private static void printBinomenal(int n, int a, int b) {
        int sum = 0;
        int[] coef = rowTrianglePascal(n);
        for (int i = 0, j = n; i <= n; i++, j--) {

            int test = 1;
            String coefficients = "";
            if (coef[i] != 1) {
                coefficients = String.valueOf(coef[i]);
                test *= coef[i];
            }
            System.out.print(coefficients);
            //a block
            if (j != 0) {
                if (j != 1) {
                    System.out.print("a^" + j);
                    test *= Math.pow(a, j);
                } else {
                    System.out.print("a");
                    test *= a;
                }
            }
            //b block
            if (i != 0)
                if (i == n && n != 1) {
                    System.out.print("b^" + i);
                    test *= Math.pow(b,i);
                }
                else {
                    if (i != 1) {
                        System.out.print("*b^" + i);
                        test *= Math.pow(b,i);
                    }
                    else {
                        if (n == 1)
                            System.out.print("b");
                        else
                            System.out.print("*b");
                        test *= b;
                    }
                }
            if (i != n)
                System.out.print("+");
            sum+=test;
        }
        System.out.print("=" + sum);
    }

    //return array of coeficients
    public static int[] rowTrianglePascal(int n) {
        int x = 1;
        int[] coeff = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            coeff[i] = x;
            x = x * (n - i) / (i + 1);
        }
        return coeff;
    }
}
