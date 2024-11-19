/**
 * This program is implemented by SortDriver.java and contains several different sorting algorithms implemented as class methods, and when called, performs them on/with the class instance variables. Also contains functionality to print and get and set variable values.
 */
public class Sorting {

    /**
     * Instance variables:
     * - 'compCount': the 'running total' of the number of comparisons executed by a single program execution.
     */
    public int compCount;

    /**
     * The default constructor method.
     */
    public Sorting() {
        this.compCount = 0;
    } // Sorting

    /**
     * An iterative selection-sort algorithm performed on the class 'array' variable.
     * 
     * Time complexity: O(n^2)
     */
    public void selectionSort(int[] values, int numValues) {
        int endIndex = numValues - 1;
        for (int current = 0; current < endIndex; current++) {
            swap(values[current], values[minIndex(values, current, endIndex)]);
        } // for
    } // selectionSort

    /**
     * An iterative method which returns the smallest number in the array from the given 'start' index.
     * 
     * {@param} the index from which to start iterating through 'array'
     */
    public int minIndex(int[] values, int start, int end) {
        int indexOfMin = start;
        for (int index = start + 1; index <= end; index++) {
            if (values[index] < values[indexOfMin]) indexOfMin = index;
        } // for
        return indexOfMin;
    } // minIndex

    /**
     * Swap the values of the two given indexes in 'array'.
     * 
     * {@param} indexOne the first index in 'array' to swap
     * {@param} indexTwo the second index in 'array' to swap
     */
    public void swap(int varOne, int varTwo) {
        int tempVar = varOne;
        varOne = varTwo;
        varTwo = tempVar;
    } // swap
    
    /**
     * A recursive merge-sort algorithm performed on the class 'array' variable.
     * Runtime Complexity: O(n*log^2(n))
     */
    public void mergeSort(int values[], int first, int last) {
        if (first < last) {
            int middle = (first + last) / 2;
            mergeSort(values, first, middle);
            mergeSort(values, middle + 1, last);
            merge(values, first, middle, middle+1, last);
        } // if
    } // mergeSort

    /**
     * Merge two sorted subsections of a given array.
     * Runtime complexity: O(n)
     */
    public void merge(int values[], int leftFirst, int leftLast, int rightFirst, int rightLast) {
        int[] tempArray = new int[this.array.length]; // ISSUE: may need changing
        int index = leftFirst;
        int saveFirst = leftFirst;

        while ((leftFirst <= leftLast) && (rightFirst <= rightLast)) {
            if (values[leftFirst] < values[rightFirst]) {
                tempArray[index] = values[leftFirst];
                leftFirst++;
            } else {
                tempArray[index] = values[rightFirst];
                rightFirst++;
            } // if
            index++;
        } // while

        while (leftFirst <= leftLast) {
            tempArray[index] = values[leftFirst];
            leftFirst++;
            index++;
        } // while

        while (rightFirst <= rightLast) {
            tempArray[index] = values[rightFirst];
            rightFirst++;
            index++;
        } // while

        for (index = saveFirst; index <= rightLast; index++) {
            values[index] = tempArray[index];
        } // for
    } // merge

    /**
     * A heap-sort algorithm performed on the class 'array' variable.
     */
    public void heapSort(int[] values, int numValues) {
        for (int index = numValues/2 - 1; index >= 0; index--) {
            reHeapDown(values, index, numValues - 1);
        } // for
        for (int index = numValues - 1; index >= 1; index--) {
            swap(values[0], values[index]);
            reHeapDown(values, 0, index - 1);
        } // for
    } // heapSort
    
    public void reHeapDown(int[] values, int root, int bottom) {
        int maxIndex;
        int rightChild;
        int leftChild;

        maxIndex = -1;
        rightChild = root * 2 + 2;
        leftChild = root * 2 + 1;

        if (leftChild <= bottom) {
            if (values[leftChild] > values[rightChild]) maxIndex = leftChild;
            else maxIndex = rightChild;
            if (values[maxIndex] > values[root]) {
                swap(values, maxIndex, root);
                reHeapDown(values, maxIndex, bottom);
            } // if
        } // if
    } // reHeapDown
    
    /**
     * A quick-sort algorithm performed on the class 'array' variable, using the last element in the array as the pivot.
     */
    public void quickSortLast() {

    } // quickSortLast

    /**
     * A quick-sort algorithm performed on the class 'array' variable, using a random element in the array as the pivot.
     */
    public void quickSortRand() {

    } // quickSortRand

} // Sorting