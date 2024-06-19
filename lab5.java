/*
 * Gee
 * This is free and unencumbered software released into the public domain.
 */
package gee_lab5;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This program reads the file "lab5.dat", inserts elements into a linked list
 * in non-descending order, displays the linked list, removes duplicates,
 * and displays the linked list without duplicates.
 */
public class lab5 {
    private static final String FILE_NAME = "/FILENAME";


    /**
     * The main method of the program.
     * @param args Command-line arguments.
     *
     */

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("This No Duplicates! program reads the file  " +
                FILE_NAME +"and inserts the");
        System.out.println("elements into a linked list in non-descending " +
                "order. The contents of");
        System.out.println("the linked list are then displayed to the user " +
                "in column form.");
        System.out.println("Duplicates are then removed, and the contents " +
                "are displayed again.");
        System.out.println();

        // Create a new instance of the LinkedList class to represent a singly
        // linked list of integers.
        LinkedList linkedList = new LinkedList();

        // Create a File object representing the file named FILE_NAME.
        File file = new File(FILE_NAME);

        // Check if the file exists.
        boolean fileExists = file.exists();

        // If the file does not exist, print an error message and exit the
        // program with a status code of 1.
        if (!fileExists) {
            System.err.println("File not found: " + FILE_NAME);
            System.exit(1);
        }

        // Declare a Scanner variable named scanner and initialize it to null.
        Scanner scanner = null;

        // Perform file reading only if the file exists
        if (fileExists) {
            try {
                scanner = new Scanner(file);
                while (scanner.hasNextInt()) {
                    int data = scanner.nextInt();
                    linkedList.insertInOrder(data);
                }
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
        }



        //Print out the data below After reading the linked list in numerical
        // order
        System.out.println("Reading file, inserting nodes.. done.");
        System.out.println("Linked List in Numerical Order, After Reading:");
        System.out.println(linkedList);

        //Call removeDuplicates method on the linked list
        linkedList.removeDuplicates();

        //Print out the data without duplicates
        System.out.println("Removing duplicates from the linked list.. done.");
        System.out.println("Linked list contents with no duplicates: ");
        System.out.println(linkedList);
        System.out.println();

        //Goodbye message
        System.out.println("Thanks for using the linked list program!");


    }


}
