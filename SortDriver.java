import java.util.Scanner;
import java.io.*;

public class SortDriver {
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        BufferedReader br;
        String fileText = "";
        
        // properly intake the input text file
        try {
            // store the given text file into the String variable 'fileText' via use of a BufferedReader
            br = new BufferedReader(new FileReader(args[0]));
            fileText = br.readLine();
            br.close();

        // file error handling
        } catch (FileNotFoundException e || IOException e) { 
            System.out.println(e);
        } // try
        
        // convert text file string into array of strings
        String[] fileStrArr = fileText.split(" "); 

        // convert string elements to integer elements
        int[] input = new int[fileStrArr.length];
        for (String str : fileStrArr) {
            input[str] = Integer.parseInt(fileStrArr[str]);
        } // for

        // instantiate Sorting class
        Sorting sortClass = new Sorting(input);

        // take algorithm input
        String input = "";
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-last (q) quick-sort-rand (r)"); 
        System.out.print("Enter the algorithm: ");
        input = scn.nextLine();
        switch (input) {
            case "s":
                sortClass.selectionSort();
                sortClass.print();
                break;
            
            case "m":
                sortClass.mergeSort();
                sortClass.print();
                break;

            case "h":
                sortClass.heapSort();
                sortClass.print();
                break;
            
            case "q":
                sortClass.quickSortLast();
                sortClass.print();
                break;
            
            case "r":
                sortClass.quickSortRand();
                sortClass.print();
                break;

            default:
                break;
        } // switch
} // SortDriver