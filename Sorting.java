/**
 * This program is implemented by SortDriver.java and contains several 
 * different sorting algorithms implemented as class methods, and when 
 * called, performs them on/with the class instance variables. Also 
 * contains functionality to print and get and set variable values.
 * 
 * *DISCLAIMER*: Most of the methods within were primarily sourced 
 * from CSCI 2720 class resources at the encouragement and direction of 
 * project requirements and presiding professor. 
 */
import java.util.concurrent.ThreadLocalRandom;

public class Sorting {

    // Instance variables---------------------------------------------------
    
    // a variable to count the number of comparisons performed with each program execution
    private long compCount; 

    // Class methods--------------------------------------------------------

    /**
     * A publicly accessible print method for compCount.
     */
    public void printCount() {
        System.out.println(this.compCount);
    } // printCount

    /**
     * Iteratively selection-sort the given integer array.
     * 
     * Time complexity: O(N^2)
     * 
     * @param   values      an array of integers to sort
     * @param   numValues   the number of values in the given 
     *                      integer array (the size of the array)
     * @return              the selection-sorted input array
     */
    public int[] selectionSort(int[] values, int numValues) {
        int endIndex = numValues - 1;
        for (int current = 0; current < endIndex; current++) {
            values = swap(values, current, minIndex(values, current, endIndex));
        } // for
        return values;
    } // selectionSort

    /**
     * Iteratively, linearly search for the minimum index in the given array
     * between the two given indices. 
     * 
     * Time complexity: O(N)
     * 
     * @param   values      an array of integers to search within
     * @param   start       the starting index within the array from which
     *                      to start linearly searching
     * @param   end         the ending index within the array from which to
     *                      finishe linearly searching
     * @return              the index of the minimum value found between
     *                      the given start and end index
     */
    public int minIndex(int[] values, int start, int end) {
        int indexOfMin = start;
        for (int index = start + 1; index <= end; index++) {
            if (values[index] < values[indexOfMin]) {
                indexOfMin = index;
            } // if
            this.compCount++;
        } // for
        return indexOfMin;
    } // minIndex

    /**
     * Swap the values of the two given indexes in the given array.
     * 
     * Time complexity: O(1)
     * 
     * @param   values      an array of integers to search within
     * @param   indexOne    the index to swap values with indeTwo
     * @param   indexTwo    the index to swap values with indexOne
     * @return              the input array with the two values swapped
     */
    public int[] swap(int[] values, int indexOne, int indexTwo) {
        int tempVar = values[indexOne];
        values[indexOne] = values[indexTwo];
        values[indexTwo] = tempVar;
        return values;
    } // swap
    
    /**
     * Recursively merge-sort the given integer array.
     * 
     * Time Complexity: O(Nlog^2N)
     *  
     * @param   values      an array of integers to search within
     * @param   firstIndex  the first index of the subarray of the  
     *                      given array to merge-sort
     * @param   lastIndex   the last index of the subarray of the  
     *                      given array to merge-sort
     * @return              the merge-sorted input array
     */
    public int[] mergeSort(int values[], int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            values = mergeSort(values, firstIndex, middleIndex);
            values = mergeSort(values, middleIndex + 1, lastIndex);
            values = merge(values, firstIndex, middleIndex, middleIndex + 1, lastIndex);
        } // if
        return values;
    } // mergeSort

    /**
     * Merges two sorted subsections of a given array.
     * 
     * Time complexity: O(N)
     * 
     * @param   values          an array of integers to search within
     * @param   leftFirstIndex  the first index of the lefthand subarray  
     *                          of the given array to merge-sort
     * @param   leftLastIndex   the last index of the lefthand subarray  
     *                          of the given array to merge-sort
     * @param   rightFirstIndex the first index of the righthand subarray  
     *                          of the given array to merge-sort
     * @param   rightLastIndex  the last index of the righthand subarray  
     *                          of the given array to merge-sort
     * @return                  the input array with the two given subarrays
     *                          merged together
     */
    public int[] merge(int values[], int leftFirstIndex, int leftLastIndex, int rightFirstIndex, int rightLastIndex) {

        int[] tempArray = new int[values.length];
        int saveFirstIndex = leftFirstIndex;
        int index = leftFirstIndex;

        // Iterate through all of left and right halves
        while ((leftFirstIndex <= leftLastIndex) && (rightFirstIndex <= rightLastIndex)) {
            if (values[leftFirstIndex] < values[rightFirstIndex]) {
                this.compCount++;
                tempArray[index] = values[leftFirstIndex];
                leftFirstIndex++;
            } else {
                this.compCount++;
                tempArray[index] = values[rightFirstIndex];
                rightFirstIndex++;
            } // if
            index++;
        } // while

        // Copy any remaining items from left half to tempArray
        while (leftFirstIndex <= leftLastIndex) {
            tempArray[index] = values[leftFirstIndex];
            leftFirstIndex++;
            index++;
        } // while

        // Copy any remaining items from right half to tempArray
        while (rightFirstIndex <= rightLastIndex) {
            tempArray[index] = values[rightFirstIndex];
            rightFirstIndex++;
            index++;
        } // while

        // Copy the sorted elements from tempArray back into 'values'
        for (index = saveFirstIndex; index <= rightLastIndex; index++) {
            values[index] = tempArray[index];
        } // for

        return values;
    } // merge

    /**
     * Iteratively heap-sort the given integer array.
     * 
     * Time complexity: O(NlogN)
     * 
     * @param   values      an array of integers to sort
     * @param   numValues   the number of values in the given 
     *                      integer array (the size of the array)
     * @return              the heap-sorted input array
     */
    public int[] heapSort(int[] values, int numValues) {
        
        // Convert array values[0 to numValues-1] into a heap; a.k.a. 'Build-Max-Heap'
        // for (int num : values) System.out.print(num + " "); // CHECK
        // System.out.println(); // CHECK

        for (int index = numValues/2 - 1; index >= 0; index--) {
            values = reHeapDown(values, index, numValues - 1);
            // for (int num : values) System.out.print(num + " "); // CHECK
            // System.out.println(); // CHECK    
        } // for

        // Heap-sort the array
        for (int index = numValues - 1; index > 0; index--) {
            values = swap(values, 0, index);
            values = reHeapDown(values, 0, index - 1);
        } // for

        // for (int num : values) System.out.print(num + " "); // CHECK
        // System.out.println("\n"); // CHECK

        // last checks
        if (values[0] > values[1]) {
            values = swap(values, 0, 1);
        } // if
        if (values[numValues-1] < values[numValues-2]) {
            values = swap(values, numValues - 1, numValues - 2);
        } // if

        return values;
    } // heapSort
    
    /**
     * A helper method for heapSort() used to re-heap down the heap 
     * picture of the given array.
     * 
     * Time complexity: O(logN)
     * 
     * @param   values  an array of integers to sort
     * @param   root    the root of the given subtree
     * @param   bottom  the bottom of the given subtree
     * @return          the re-heaped integer array
     */
    public int[] reHeapDown(int[] values, int root, int bottom) {

        int maxIndex = root; 
        int rightChildIndex = root * 2 + 2;
        int leftChildIndex = root * 2 + 1;

        if (leftChildIndex < bottom) {
            if (values[leftChildIndex] > values[rightChildIndex]) {
                maxIndex = leftChildIndex;
            } else maxIndex = rightChildIndex;
            this.compCount++;

            if (values[maxIndex] > values[root]) {
                values = swap(values, maxIndex, root);
                reHeapDown(values, maxIndex, bottom);
            } // if
        } // if

        return values;
    } // reHeapDown

    /**
     * Quick-sort the given integer array using the last element in the 
     * array as the pivot.
     * 
     * Time complexity: O(Nlog^2N)
     * 
     * @param   values      an array of integers to search within
     * @param   firstIndex  the first index of the subarray of the  
     *                      given array to quick-sort
     * @param   lastIndex   the last index of the subarray of the  
     *                      given array to quick-sort
     * @return              the quick-sorted input array
     */
    public int[] quickSortLast(int[] values, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            // int pivot = partitionLast(values, firstIndex, lastIndex);
            int pivot = partition(values, "p", firstIndex, lastIndex);
            values = quickSortLast(values, firstIndex, pivot - 1);
            values = quickSortLast(values, pivot + 1, lastIndex);
        } // if
        return values;
    } // quickSortLast

    /**
     * Quick-sort the given integer array using a random element in
     * the array as the pivt.
     * 
     * Time complexity: O(Nlog^2N)
     * 
     * @param   values      an array of integers to search within
     * @param   firstIndex  the first index of the subarray of the  
     *                      given array to quick-sort
     * @param   lastIndex   the last index of the subarray of the  
     *                      given array to quick-sort
     * @return              the quick-sorted input array
     */
    public int[] quickSortRand(int[] values, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            // int pivot = partitionRand(values, firstIndex, lastIndex);
            int pivot = partition(values, "r", firstIndex, lastIndex);
            values = quickSortRand(values, firstIndex, pivot - 1);
            values = quickSortRand(values, pivot + 1, lastIndex);
        } // if
        return values;
    } // quickSortLast

    /**
     * iteratively partition the elements of the subarray based on 
     * the last element in the subarray.
     * 
     * Time complexity: O(N)
     * 
     * @param   values      an array of integers to search within
     * @param   firstIndex  the first index of the subarray of the  
     *                      given array to quick-sort
     * @param   lastIndex   the last index of the subarray of the  
     *                      given array to quick-sort
     * @return              the final index of the pivot
     */
    public int partition(int[] values, String type, int firstIndex, int lastIndex) {
        if (type.equals("r")) values = setRandomHigh(values, firstIndex, lastIndex);
        int x = values[lastIndex];
        int i = firstIndex - 1; 
        for (int j = firstIndex; j <= lastIndex - 1; j++) { 
            if (values[j] <= x) {
                i++;
                values = swap(values, i, j);
            } // if
            this.compCount++;
        } // for
        values = swap(values, i+1, lastIndex);

        return i + 1;
    } // partitionRand

    /**
     * A helper method to quickSortRand(); set the last element 
     * in the given subarray to a random element within it.
     * 
     * Time complexity: O(1)
     * 
     * @param   values      an array of integers to search within
     * @param   firstIndex  the first index of the subarray of the  
     *                      given array to quick-sort
     * @param   lastIndex   the last index of the subarray of the  
     *                      given array to quick-sort
     * @return              the final index of the pivot
     */
    public int[] setRandomHigh(int[] values, int lowIndex, int highIndex) {
        int randomIndex = ThreadLocalRandom.current().nextInt(lowIndex, highIndex);
        int tempVar = values[highIndex];
        values[highIndex] = values[randomIndex]; 
        values[randomIndex] = tempVar;

        return values;
    } // setRandom

    /**
     * Iteratively merge-sort the given integer array.
     * 
     * Time complexity: O(NlogN)
     * 
     * @param   values      an array of integers to sort
     * @param   numValues   the number of values in the given 
     *                      integer array (the size of the array)
     * @return              the merge-sorted input array
     */
    public int[] itrMergeSort(int[] values, int numValues) {

        int subArrLen;

        // iterate through the sizes of the subarrays
        for (subArrLen = 1; subArrLen < numValues; subArrLen = subArrLen * 2) {
            // iterate through the subarrays in the comphrehensive array
            for (int leftIndex = 0; leftIndex < numValues - subArrLen; leftIndex = leftIndex + (subArrLen * 2)) {
                
                // determine the beginning of the right subarray
                int rightIndex; 
                if ((leftIndex + 2 * subArrLen - 1) < (numValues - 1 )) {
                    rightIndex = (leftIndex + 2 * subArrLen - 1);
                } else {
                    rightIndex = (numValues - 1 );
                } // if
                // determine the division between the subarrays
                int midIndex;               
                if ((leftIndex + subArrLen - 1) < (numValues - 1)) {
                    midIndex = (leftIndex + subArrLen - 1);
                } else {
                    midIndex = (numValues - 1);
                } // if

                // merge the two subarrays together: leftSubArray = {leftIndex-midIndex}, rightSubArray = {midIndex-rightIndex}
                itrMerge(values, leftIndex, midIndex, rightIndex);
            } // for
        } // for

        return values;
    } // mergeSort

    /**
     * A helper function to itrMergeSort(); iteratively merge 
     * two subarrays within the merge sort algorithm.
     * 
     * Time complexity: O(N)
     * 
     * @param   values      an array of integers to search within
     * @param   leftIndex   the first index of the lefthand subarray  
     *                      of the given array to merge-sort
     * @param   midIndex    the middle index of the array which 
     *                      separates the left and right subarrays
     * @param   rightIndex  the right index of the righthand subarray  
     *                      of the given array to merge-sort
     * @return              the input array with the two given subarrays
     *                      merged together
     */
    public int[] itrMerge(int[] values, int leftIndex, int midIndex, int rightIndex) {
        
        int[] leftSubArray = new int[midIndex - leftIndex + 1];
        int[] rightSubArray = new int[rightIndex - midIndex];

        // properly create both left and right subarrays
        leftSubArray = copySubArray(values, leftSubArray, leftIndex, 0, leftSubArray.length);
        rightSubArray = copySubArray(values, rightSubArray, midIndex + 1,0, rightSubArray.length);

        int leftSubIndex = 0;
        int rightSubIndex = 0;
        int finalIndex = leftIndex;
        // compare successive values in leftSubArray vs rightSubArray and add the lesser element to values
        while (leftSubIndex < leftSubArray.length && rightSubIndex < rightSubArray.length) {
            if (leftSubArray[leftSubIndex] <= rightSubArray[rightSubIndex]) {
                this.compCount++;
                values[finalIndex] = leftSubArray[leftSubIndex];
                leftSubIndex++;
            } else {
                this.compCount++;
                values[finalIndex] = rightSubArray[rightSubIndex];
                rightSubIndex++;
            } // if
            finalIndex++;
        } // while

        // copy all elements left in leftSubArray to values
        while (leftSubIndex < leftSubArray.length) {
            values[finalIndex] = leftSubArray[leftSubIndex];
            leftSubIndex++;
            finalIndex++;
        } // while
        // copy all elements left in rightSubArray to values
        while (rightSubIndex < rightSubArray.length) {
            values[finalIndex] = rightSubArray[rightSubIndex];
            rightSubIndex++;
            finalIndex++;
        } // while

        return values;
    } // itrMerge

    /**
     * A helper method to itrMerge(); copy a subarray of the 
     * given array.
     * 
     * Time complexity: O(1)
     * 
     * @param   values      an array of integers to search within
     * @param   copyArray   the array to copy to
     * @param   valIndex    the index of values to start copying
     * @param   copyIndex   the index of copyArray to start copying to
     * @param   numCopies   the number of indices to copy
     * @return              the array of copied values
     */
    public int[] copySubArray(int[] values, int[] copyArray, int valIndex, int copyIndex, int numCopies) {
        for (int count = 0; count < numCopies; count++) {
            copyArray[copyIndex] = values[valIndex];
            copyIndex++;
            valIndex++;
        } // for

        return copyArray;
    } // copySubArray

} // Sorting