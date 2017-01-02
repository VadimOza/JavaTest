package com.vadimozarinskiy.Task1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Vadim Ozainskiy on 28.12.16.
 */
public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the number: ");
            try {
                int z = scaner.nextInt();
                rowTrianglePascal(z);
            } catch (InputMismatchException ex){
                System.out.println("Wrong number");
                scaner.next();
            }
        }
    }

    public static void rowTrianglePascal(int n){
        int x = 1;
        for(int i = 0; i <= n; i++){
            System.out.print(x+"\t");
            x = x * (n - i) / (i + 1);
        }
        System.out.println();
    }

}
