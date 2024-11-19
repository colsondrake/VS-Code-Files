/**
 * This program is implemented by SortDriver.java and contains several different sorting algorithms implemented as class methods, and when called, performs them on/with the class instance variables. Also contains functionality to print and get and set variable values.
 */
public class Sorting {

    /**
     * Instance variables:
     * - 'array': an integer array storing the list of integers used by the program and its sorting algorithms (as class methods).
     * - 'compCount': the 'running total' of the number of comparisons executed by a single program execution.
     */
    public int[] array;
    public int compCount;

    /**
     * The default constructor method
     */
    public Sorting() {
        this.array = null;
        this.compCount = 0;
    } // Sorting

    /**
     * A custom contstructor method to set the class's 'array' variable to the given input integer array
     */
    public Sorting(int[] inArr) {
        this.array = inArr;
        this.compCount = 0;
    } // Sorting

    /**
     * The program's print function; prints the following in the following order: 1) the newly sorted integer array, 2) the sorting algorithm used, 3) the number of comparisons executed by the executed sorting algorithm chosen (by user input)
     */
    public void print(String pType) {
        for (int num : array) System.out.print(array[num] + " ");
        System.out.println();
        switch (pType) {
            case "s":
                System.out.print("#Selection-sort comparisons: ");
                break;
            case "m":
                System.out.print("#Merge-sort comparisons: ");
                break;
            case "h":
                System.out.print("#Heap-sort comparisons: ");
                break;
            case "q":
                System.out.print("#quick-sort-last comparisons: ");
                break;
            case "r":
                System.out.print("#quick-sort-rand comparisons: ");
                break;
            default:
                break;
        } // switch
        System.out.println(this.compCount);
    } // print

    /**
     * An iterative selection-sort algorithm performed on the class 'array' variable.
     * 
     * Time complexity: O(n^2)
     */
    public void selectionSort() {
        for (int i = 0; i < this.array.length - 1; i++) {
            swap(i, minIndex(i));
        } // for
    } // selectionSort

    /**
     * An iterative method which returns the smallest number in the array from the given 'start' index.
     * 
     * {@param} the index from which to start iterating through 'array'
     */
    int minIndex(int start) {
        int indexOfMin = start;
        for (int i = start + 1; i < this.array.length; i++) {
            if (this.array[i] < this.array[indexOfMin]) indexOfMin = i;
            this.compCount++;
        } // for
        return indexOfMin;
    } // minIndex

    /**
     * Swap the values of the two given indexes in 'array'.
     * 
     * {@param} indexOne the first index in 'array' to swap
     * {@param} indexTwo the second index in 'array' to swap
     */
    public void swap(int indexOne, int indexTwo) {
        int tempVar = this.array[indexOne];
        this.array[indexOne] = this.array[indexTwo];
        this.array[indexTwo] = tempVar;
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
    public void heapSort() {

    } // heapSort

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