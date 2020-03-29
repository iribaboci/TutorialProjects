package com.Lab01;

import java.util.Scanner;

public class PyramidPattern {

    Scanner user_input;


    public PyramidPattern() {
        user_input=new Scanner(System.in);
        System.out.println("enter number of layers for Pyramid");
        int number = user_input.nextInt();
        //drawPyramid(number);
        drawChristmasTree(number);
    }

    public void drawPyramid(int numberOfRows, int numberOfPyramids) {
        for (int i = 1; i <= numberOfRows; i++) {
            drawSpace(i, numberOfRows + numberOfPyramids);
            drawRow(i);
            System.out.print("\n");
        }
    }
    public void drawRow(int n){
        for(int k = 1; k < (n*2); k++)
            System.out.print("*");
    }
    public void drawSpace(int i, int n){
        for (int j = i; j < n; j++)
            System.out.print(" ");
    }


    public void drawChristmasTree(int numberOfPyramids) {
        int a = numberOfPyramids;
        for(int i = 1; i <= numberOfPyramids; i++){
            drawPyramid(i, a);
            a = a - 1;
        }

    }
}


