package com.company;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class Main {

    private static String links = "";
    private static int LinkNum = 0;

    public static void main(String[] args) {
        try {
            File myObj = new File("Input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("://") || data.contains("http://") || data.contains("https://")) {
                    System.out.println(data);
                    links = links + data + "\n";
                    LinkNum++;
                }
            }
            myReader.close();
            try {
                FileWriter myWriter = new FileWriter("Output.txt");
                myWriter.write(links);
                myWriter.close();
                System.out.println("Successfully wrote " + LinkNum + " links to file");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
