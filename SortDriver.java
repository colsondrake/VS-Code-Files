/**
 * This program is a driver program which implements and executes Sorting.java, a program that implements several sorting algorithms. 
 */
import java.util.Scanner;
import java.io.*;

public class SortDriver {
    public static void main(String[] args) {

        // Driver program execution variables-------------------------------

        Scanner scn; // Scanner class instance variable to take user input
        BufferedReader br; // BufferedReader instance variable used to read input file (i.e. args[0])
        String fileText; // String variable used to store the entire contents of the input file

        String[] fileStrArr; // String array used to store each individual entry in fileText
        int[] intArr; // Integer array used to store converted Strings -> Integers from fileStrArr

        Sorting sortClass; // Sorting class instance variable 
        String algInput; // String user input to decide which sorting algorithm method to perform

        // Variable instantiation-------------------------------------------
        scn = new Scanner(System.in);
        fileText = "";
        sortClass = new Sorting();
        algInput = "";
        
        // Stage program execution------------------------------------------

        // Properly intake the input text file
        try {
            // store the given text file into the String variable 'fileText' via use of a BufferedReader
            br = new BufferedReader(new FileReader(args[0]));
            fileText = br.readLine();
            br.close();
        } catch (IOException e) { // file error handling
            System.out.println(e);
        } // try
        
        // convert text file string into array of strings
        fileStrArr = fileText.split(" "); 

        // convert string elements to integer elements
        intArr = new int[fileStrArr.length];
        for (int i = 0; i < fileStrArr.length; i++) {
            intArr[i] = Integer.parseInt(fileStrArr[i]);
        } // for

        // Execute program functionality------------------------------------
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-last (q) quick-sort-rand (r)"); 
        System.out.print("Enter the algorithm: ");
        algInput = scn.nextLine();
        switch (algInput) {

            // Implement the selectionSort() method 
            case "s":
                sortClass.selectionSort(intArr, intArr.length);
                break;
            
            // Implement the mergeSort() method
            case "m":
                sortClass.mergeSort(intArr, intArr[0], intArr[intArr.length-1]);
                break;

            // Implement the heapSort() method
            case "h":
                sortClass.heapSort(intArr, intArr.length);
                break;
            
            // Implement the quickSortLast() method
            case "q":
                sortClass.quickSortLast();
                break;
            
            // Implement the quickSortRand() method
            case "r":
                sortClass.quickSortRand();
                break;

            // If something else is received as input, do nothing. 
            default:
                break;
        } // switch

        scn.close();
    } // main
} // SortDriver