/**
 * This program is an additioanl driver program which implements 
 * and executes Sorting.java, but instead of taking a text file as
 * input, it generates an array of random values to the size specified
 * by the user and then performs the selected sorting algorithm on 
 * the generated integer array.
 */

 import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SortDriverIns {

    public static void main(String[] args) {

        // program variables
        String algInput = ""; 
        int inSize = 0;
        Scanner scn = new Scanner(System.in);
        Sorting sortClass = new Sorting();

        // program execution
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-last (q) quick-sort-rand (r) iter-algo (i)"); 
        System.out.print("Enter the algorithm: ");
        algInput = scn.nextLine();
        System.out.print("Enter the size of the input: "); 
        inSize = scn.nextInt();
        scn.nextLine();

        // generate array with n = inSize random values
        int[] intArr = new int[inSize];
        for (int index = 0; index < inSize; index++) {
            intArr[index] = ThreadLocalRandom.current().nextInt(0, inSize * 3);
        } // for
    
        switch (algInput) {

            // Execute the selectionSort() method 
            case "s":
                intArr = sortClass.selectionSort(intArr, intArr.length);
                for (int num : intArr) System.out.print(num + " ");
                System.out.println();
                System.out.print("#Selection-sort comparisons: ");
                break;
            
            // Execute the mergeSort() method
            case "m":
                intArr = sortClass.mergeSort(intArr, 0, intArr.length - 1);
                for (int num : intArr) System.out.print(num + " ");
                System.out.println();        
                System.out.print("#Merge-sort comparisons: ");
                break;

            // Execute the heapSort() method
            case "h":
                intArr = sortClass.heapSort(intArr, intArr.length);
                for (int num : intArr) System.out.print(num + " ");
                System.out.println();        
                System.out.print("#Heap-sort comparisons: ");
                break;
            
            // Execute the quickSortLast() method
            case "q":
                intArr = sortClass.quickSortLast(intArr, 0, intArr.length - 1);
                for (int num : intArr) System.out.print(num + " ");
                System.out.println();        
                System.out.print("#Quick-sort-last comparisons: ");
                break;
            
            // Execute the quickSortRand() method
            case "r":
                intArr = sortClass.quickSortRand(intArr, 0, intArr.length - 1);
                for (int num : intArr) System.out.print(num + " ");
                System.out.println();        
                System.out.print("#Quick-sort-rand comparisons: ");
                break;
            
            // execute the itrMergeSort() method
            case "i":
                intArr = sortClass.itrMergeSort(intArr, intArr.length);
                for (int num : intArr) System.out.print(num + " ");
                System.out.println();
                System.out.println("#Iter-algo comparisons: ");
                break;

            // If something else is received as input, do nothing. 
            default:
                break;
        } // switch

        sortClass.printCount();
        scn.close();
    } // main
} // SortDriverIns