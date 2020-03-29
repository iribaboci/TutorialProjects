package com.Lab01;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Task2 {

    /***
     * commands:
     * py size
     *   draw a pyramid with size
     * ct size
     *   draw a christmas tree with size
     * ld documentName
     *   load document from standard input line by line. Last line consists of only sequence "eod",
     *   which means end of document
     * ha
     *   halt program and finish execution
     * @param args
     */


    public static void main(String[] args) throws FileNotFoundException {
        Task2 task =  new Task2();
        task.takeCommands();
    }


    public void takeCommands() throws FileNotFoundException {
        Scanner scan;
        System.out.println("START");
        scan=new Scanner(System.in);
        boolean halt=false;
        while(!halt) {
            String line=scan.nextLine();
            // empty line and comment line - read next line
            if(line.length()==0 || line.charAt(0)=='#')
                continue;
            // copy line to output (it is easier to find a place of a mistake)
            System.out.println("!"+line);
            String word[]=line.split(" ");
            if(word[0].equalsIgnoreCase("py") && word.length==2) {
                int value=Integer.parseInt(word[1]);
                drawPyramid(value, 1);
                continue;
            }
            if(word[0].equalsIgnoreCase("ct") && word.length==2) {
                int value=Integer.parseInt(word[1]);
                drawChristmasTree(value);
                continue;
            }
            // ld documentName
            if(word[0].equalsIgnoreCase("ld") && word.length==2) {
                String filePath = chooseFile();
                if(filePath != null)
                    loadDocument(filePath);
                else
                    System.out.println("please choose a file");
                continue;
            }
            // ha
            if(word[0].equalsIgnoreCase("ha") && word.length==1) {
                halt=true;
                continue;
            }
            System.out.println("Wrong command");
        }
        System.out.println("END OF EXECUTION");
        scan.close();
    }


    public String chooseFile() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "txt files", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getAbsolutePath());
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    public void loadDocument(String fileName) throws FileNotFoundException {

        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line=sc.nextLine();
            // empty line and comment line - read next line
            if(line.length()==0 || line.charAt(0)=='#')
                continue;

            String word[]=line.split(" ");
            for(int i = 0; i < word.length; i++) {
                //System.out.println(word[i]);
                String[] w = word[i].split("=");
                if(w[0].equalsIgnoreCase("link") && w.length == 2) {
                    String value = w[1];
                    System.out.println(value);
                }
            }
        }
        System.out.println("FILE CLOSED");

    }


    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
    private static boolean correctLink(String link) {
        return true;
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
        for (int i = 1; i <= numberOfPyramids; i++) {
            drawPyramid(i, a);
            a = a - 1;
        }
    }
}