import java.util.concurrent.ThreadLocalRandom;
/**
 * This program is implemented by SortDriver.java and contains several different sorting algorithms implemented as class methods, and when called, performs them on/with the class instance variables. Also contains functionality to print and get and set variable values.
 */
public class Sorting {

    /**
     * Instance variables:
     * - 'compCount': the 'running total' of the number of comparisons executed by a single program execution.
     */
    private int compCount;

    /**
     * The default constructor method.
     */
    public Sorting() {
        this.compCount = 0;
    } // Sorting

    /**
     * A publicly accessible print method for compCount.
     */
    public void printCount() {
        System.out.println(this.compCount);
    } // printCount

    /**
     * An iterative selection-sort algorithm performed on the class 'array' variable.
     * Time complexity: O(n^2)
     */
    public int[] selectionSort(int[] values, int numValues) {
        int endIndex = numValues - 1;
        for (int current = 0; current < endIndex; current++) {
            values = swap(values, current, minIndex(values, current, endIndex));
        } // for
        return values;
    } // selectionSort

    /**
     * An iterative method which returns the smallest number in the array from the given 'start' index.
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
     * Swap the values of the two given indexes in 'array'.
     */
    public int[] swap(int[] values, int indexOne, int indexTwo) {
        int tempVar = values[indexOne];
        values[indexOne] = values[indexTwo];
        values[indexTwo] = tempVar;
        return values;
    } // swap
    
    /**
     * A recursive merge-sort algorithm performed on the class 'array' variable.
     * Runtime Complexity: O(n*log^2(n))
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
     * Merge two sorted subsections of a given array.
     * Runtime complexity: O(n)
     */
    public int[] merge(int values[], int leftFirstIndex, int leftLastIndex, int rightFirstIndex, int rightLastIndex) {
        int[] tempArray = new int[values.length];
        int saveFirstIndex = leftFirstIndex;
        int index = leftFirstIndex;

        // Iterate through all of left and right halves
        while ((leftFirstIndex <= leftLastIndex) && (rightFirstIndex <= rightLastIndex)) {
            if (values[leftFirstIndex] < values[rightFirstIndex]) {
                tempArray[index] = values[leftFirstIndex];
                leftFirstIndex++;
            } else {
                tempArray[index] = values[rightFirstIndex];
                rightFirstIndex++;
            } // if
            this.compCount++;
            index++;
        } // while

        // Copy any remaining items from left half to tempArray
        while (leftFirstIndex <= leftLastIndex) {
            this.compCount++;
            tempArray[index] = values[leftFirstIndex];
            leftFirstIndex++;
            index++;
        } // while

        // Copy any remaining items from right half to tempArray
        while (rightFirstIndex <= rightLastIndex) {
            this.compCount++;
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
     * A heap-sort algorithm performed on the class 'array' variable.
     */
    public int[] heapSort(int[] values, int numValues) {
        
        System.out.println("numValues: " + numValues); // CHECK
        int index;

        // Convert array values[0 to numValues-1] into a heap; a.k.a. 'Build-Max-Heap'
        for (index = numValues/2 - 1; index >= 0; index--) {
            // System.out.println("index: " + index); // CHECK
            values = reHeapDown(values, index, numValues - 1);
        } // for

        // Sort the array
        for (index = numValues - 1; index >= 1; index--) {
            values = swap(values, 0, index);
            values = reHeapDown(values, 0, index - 1);
        } // for

        return values;
    } // heapSort
    
    /**
     * A helper method to heapSort() used to re-heap down the heap-picture of the given array.
     */
    public int[] reHeapDown(int[] values, int root, int bottom) {
        int maxIndex;
        int rightChild;
        int leftChild;

        maxIndex = -1;
        rightChild = root * 2 + 2;
        leftChild = root * 2 + 1;

        if (leftChild <= bottom) {
            this.compCount++;

            // System.out.println("leftChild: " + leftChild + " || rightChild: " + rightChild); // CHECK
            // System.out.println("values[leftchild]: " + values[leftChild] + " || values[rightChild]: " + values[rightChild]); // CHECK

            if (values[leftChild] > values[rightChild]) {
                maxIndex = leftChild;
            } else maxIndex = rightChild;
            this.compCount++;

            if (values[maxIndex] > values[root]) {
                this.compCount++;
                values = swap(values, maxIndex, root);
                reHeapDown(values, maxIndex, bottom);
            } // if
        } // if
        return values;
    } // reHeapDown
    
    /**
     * A quick-sort algorithm performed on the class 'array' variable, using the last element in the array as the pivot.
     */
    public int[] quickSortLast(int[] values, int first, int last) {
        if (first < last) {
            int pivot = partitionLast(values, first, last);
            values = quickSortLast(values, first, pivot - 1);
            values = quickSortLast(values, pivot + 1, last);
        } // if
        return values;
    } // quickSortLast

    public int partitionLast(int[] values, int lowIndex, int highIndex) {
        int x = values[highIndex];
        int i = lowIndex - 1;
        for (int j = lowIndex; j <= highIndex - 1; j++) {
            if (values[j] <= x) {
                this.compCount++;
                i++;
                values = swap(values, i, j);
            } // if
        } // for
        values = swap(values, i+1, highIndex);

        return i + 1;
    } // partition

    /**
     * A quick-sort algorithm performed on the class 'array' variable, using a random element in the array as the pivot.
     */
    public int[] quickSortRand(int[] values, int first, int last) {
        if (first < last) {
            int pivot = partitionRand(values, first, last);
            values = quickSortRand(values, first, pivot - 1);
            values = quickSortRand(values, pivot + 1, last);
        } // if
        return values;
    } // quickSortLast

    public int partitionRand(int[] values, int lowIndex, int highIndex) {
        values = setRandomHigh(values, lowIndex, highIndex);
        int x = values[highIndex];
        int i = lowIndex - 1; 
        for (int j = lowIndex; j <= highIndex - 1; j++) { 
            if (values[j] <= x) {
                this.compCount++;
                i++;
                values = swap(values, i, j);
            } // if
        } // for
        values = swap(values, i+1, highIndex);

        return i + 1;
    } // partition

    public int[] setRandomHigh(int[] values, int lowIndex, int highIndex) {
        int randomIndex = ThreadLocalRandom.current().nextInt(lowIndex, highIndex);
        int tempVar = values[highIndex];
        values[highIndex] = values[randomIndex]; 
        values[randomIndex] = tempVar;

        return values;
    } // setRandom

} // Sorting