/**
 * This program is implemented by SortDriver.java and contains several different sorting algorithms implemented as class methods, and when called, performs them on/with the class instance variables. Also contains functionality to print and get and set variable values.
 */
public class Sorting {

    /**
     * Instance variables:
     * - 'array': an integer array storing the list of integers used by the program and its sorting algorithms (as class methods).
     * - 'compCount': the 'running total' of the number of comparisons executed by a single program execution.
     */
    private int[] array;
    private int compCount;

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
     * A get function for the program's integer array 'array'
     */
    public int[] getArray() {
        return this.array;
    } // getArray

    /**
     * A set function for the program's integer array 'array'
     */
    public void setArray(int[] inArr) {
        this.array = inArr;
    } // setArray

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
     * A selection-sort algorithm performed on the class 'array' variable.
     */
    public void selectionSort() {

    } // selectionSort

    /**
     * A merge-sort algorithm performed on the class 'array' variable.
     */
    public void mergeSort() {

    } // mergeSort

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