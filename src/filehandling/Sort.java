package filehandling;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sort {

    public static void main(String[] args) {

        String fileName = "C:\\Users\\Jedy Matt\\Desktop\\Students.txt";
        FileReader reader;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new FileReader(fileName);
            int c;
            while ((c = reader.read()) != -1) {
                builder.append((char) c);
            }
        } catch (IOException ex) {
        }
        builder.trimToSize();
        String textString = builder.toString();
        String[] lastNames = textString.split(System.getProperty("line.separator"));
        for (String i : lastNames) {
            System.out.println(i);
        }
        
    }

   

}
