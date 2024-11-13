public class Sorting {

    int[] array;
    int compCount;

    public Sorting() {
        this.array = null;
        this.compCount = 0;
    } // Sorting

    public Sorting(int[] inArr) {
        this.array = inArr;
        this.compCount = 0;
    } // Sorting

    public int[] getArray() {
        return this.array;
    } // getArray

    public void setArray(int[] inArr) {
        this.array = inArr;
    } // setArray

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

    public void selectionSort() {

    } // selectionSort

    public void mergeSort() {

    } // mergeSort

    public void heapSort() {

    } // heapSort

    public void quickSortLast() {

    } // quickSortLast

    public void quickSortRand() {

    } // quickSortRand

} // Sorting