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
        } catch (IOException e) { 
            System.out.println(e);
        } // try
        
        // convert text file string into array of strings
        String[] fileStrArr = fileText.split(" "); 

        // convert string elements to integer elements
        int[] intArr = new int[fileStrArr.length];
        for (int i = 0; i < fileStrArr.length; i++) {
            intArr[i] = Integer.parseInt(fileStrArr[i]);
        } // for

        // instantiate Sorting class
        Sorting sortClass = new Sorting(intArr);

        // take algorithm choice as input
        String algInput = "";
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-last (q) quick-sort-rand (r)"); 
        System.out.print("Enter the algorithm: ");
        algInput = scn.nextLine();
        switch (algInput) {
            case "s":
                sortClass.selectionSort();
                sortClass.print(algInput);
                break;
            
            case "m":
                sortClass.mergeSort();
                sortClass.print(algInput);
                break;

            case "h":
                sortClass.heapSort();
                sortClass.print(algInput);
                break;
            
            case "q":
                sortClass.quickSortLast();
                sortClass.print(algInput);
                break;
            
            case "r":
                sortClass.quickSortRand();
                sortClass.print(algInput);
                break;

            default:
                break;
        } // switch

        scn.close();
    } // main
} // SortDriver