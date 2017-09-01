package selfawarelab.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static selfawarelab.Common.arrayListToString;
import static selfawarelab.Common.arrayToString;
import static selfawarelab.Common.log;

/**
 * Created by ethansmith on 8/31/17.
 */
public class Sort {
    public static void quicksort(ArrayList<Integer> arrayList) {
        log(arrayList);
        quicksort(arrayList, 0, arrayList.size() - 1);
        log(arrayList);
    }

    // temp[i++] = data[k]; I guess this assigns to temp[0] then makes i = 1
    // for (k = first + 1; k <= last; k++)

    /*
    This is kind of cute. You know the size of temp[] (initialize using length = last - first + 1
    So you can add things from the outsides in, knowing you will never collide. When you run out of space, you also ran out of elements
        int i = 0;
        int j = temp.length - 1;
        for (k = first + 1; k <= last; k++)
        {
            if (data[k] <= pivot)
                temp[i++] = data[k];
            else
                temp[j--] = data[k];
        }
     */

    /*
    Lessons Learned:
        1. Make sure that the recursive calls have logical bounds. You won't always have 0 and length - 1 as boundaries
        The original boundaries need to be saved and used for the recursive calls at the end.
        This was wrong, and the correction needed to be used when the recursive call is made and
        in the tests to see if we went over the line
            This test could also be done as an if() recurse else nothing

        2. While() should compare against the randomly selected value, not randomly selected index
        Value at the index will change during the while() and wreak havoc on the algo. Possibly
        could work with index if index was update with every swap, but that would mean checking if
        we are swapping the pivot item or not. Bad idea.


        Bad cases:
        10 5 10
        10 15 10
            Both get stuck in a loop swapping. Need to force one to move, but no way to know which one without peeking.


        advice:
            Pick up the first element in the array as the pivot
            Scan the array from both ends toward the middle
            Whenever finding two elements on the wrong side, swap them
            When the scans from both ends meet in the middle, swap the pivot with this middle element
     */
    private static void quicksort(ArrayList<Integer> arrayList, int l, int r) {
        int length = r - l + 1;
        int oldStart = l;
        int oldEnd = r;
        if(length < 2)
            return;
        int pivotIndex = oldStart + (int) (Math.random() * length);  // Range from oldStart -> oldEnd
        int pivotValue = arrayList.get(pivotIndex);
        log("Hello", pivotIndex + " (" + arrayList.get(pivotIndex) + ") l " + l + " r " + r);
        while(l < r) {
            while (arrayList.get(l) < pivotValue && l < r)
                l++;
            while(arrayList.get(r) > pivotValue && l < r)
                r--;
            // Swap
            if(l < r) { // Prevent swaping self
                log("Hello", arrayList.get(l) + " " + arrayList.get(r));
                swap(arrayList, l, r);
                log(arrayList);
//                l++; // Just because we swapped doesnt mean its in the right position
//            r--;
            }
        }
        // Partioning complete, pivot item should be correctly located now. Recurse on both halves
        log("split", "" + l);
        if(oldStart < l) {
            log("left", oldStart + " " + (l - 1));
            quicksort(arrayList, oldStart, l - 1);
        }
        if(l < oldEnd) {
            log("right", (l+1) + " " + oldEnd);
            quicksort(arrayList, l + 1, oldEnd);
        }
    }

    /*
    Keep looping until you have a pass where nothing gets swapped
    Each pass, compare neighbors. Swap if out of order.

    Iterative.
    In place.

    Lessons learned:
    1. sorted = true needs to happen once every pass. Not every comparison. Within while() without for()
     */
    public static void bubbleSort(ArrayList<Integer> arrayList) {
        boolean sorted = false;
        log(arrayList);
        while(!sorted) {
            sorted = true; // Assume done unless swap happens
            for (int i = 0; i < arrayList.size() - 1; i++) {
                if(arrayList.get(i) > arrayList.get(i + 1)) {
                    swap(arrayList, i, i + 1);
                    sorted = false;
                    log(arrayList);
                }
            }
        }
        log(arrayList);
    }

    /*
    http://www.sorting-algorithms.com/merge-sort
    
    Divide the unsorted list into n sublists, each containing 1 element (a list of 1 element is considered sorted).
    Repeatedly merge sublists to produce new sorted sublists until there is only 1 sublist remaining. This will be the sorted list.
    Each 'merge' means iteratively comparing the first remaning member of each list, and adding the lowest one

    Lessons learned:
    1. Be consistent with use of array vs arrayList. Are we passing arrays, or just indexes to use in place swapping?
    2. Be consisten with passing size vs endIndex
    3. CORE LESSON: need 2 methods. 1. recursive 'split' method (mergeSort) 2. workhorse mergeInOrder method (not recursive)
     */
    public static void mergeSort(ArrayList<Integer> arrayList) {
        mergeSort(arrayList, 0, arrayList.size() - 1);
    }

    private static void mergeSort(ArrayList<Integer> arrayList, int startInd, int endInd) {
        if(endInd > startInd) { // Simpler than checking length. If equal, we're down to 1 item lists and can return, allowing recursive call to move on to the mergeInOrder step

            int splitInd = (startInd + endInd) / 2; // Average rounded down to get middle item
            // 0 -> (start + end) / 2 will always give half, or the larger of odd half (due to inclusive bonuses)
            // (start + end) / 2 + 1 -> end will all always give half or the smaller of odd (due to +1 robbing inclusive lower bound)
            // (In effect, rounding down with + 1 means you are always rounding up. First half is always bigger)
            log("SplitLeft", startInd + "->" + splitInd);
            mergeSort(arrayList, startInd, splitInd); // Just repeat the call to get down to smallest piece
            log("SplitRight", (splitInd + 1) + "->" + endInd);
            mergeSort(arrayList, splitInd + 1, endInd);
            // By this point, both left and right are in order (internally) or single items (first pass). Begin the real work
            log("MergeInOrder", arrayListToString(arrayList, startInd, splitInd) + " | " + arrayListToString(arrayList, splitInd + 1, endInd));
            mergeInOrder(arrayList, startInd, splitInd, endInd);
            log("Merged      ", arrayListToString(arrayList));
        }
        // Do nothing if single item. Begins the actual comparing and merging
    }

    private static void mergeInOrder(ArrayList<Integer> arrayList, int startInd, int splitInd, int endInd) {
        ArrayList<Integer> temp = new ArrayList<>();

        int leftInd = startInd;
        int rightInd = splitInd + 1;
        while(leftInd <= splitInd && rightInd <= endInd) { // Compare until one array is empty
            if(arrayList.get(leftInd) < arrayList.get(rightInd)) {
                temp.add(arrayList.get(leftInd++));
            } else {
                temp.add(arrayList.get(rightInd++));
            }
        }
        // Add any leftovers in the first array
        while(leftInd <= splitInd) {
            temp.add(arrayList.get(leftInd++));
        }
        // Add any leftovers in the right array
        while(rightInd <= endInd) {
            temp.add(arrayList.get(rightInd++));
        }
        // Copy back the sorted temp array
        for(int i = 0; startInd + i <= endInd; i++) {
            arrayList.set(startInd + i, temp.get(i));
        }
    }

    // Arrays.copyOfRange(array, inclusive, EXCLUSIVE) I don't understand the rational of this since I'm passing indexes
    // but need to add +1 for every end index.
    public static int[] mergeSort(int[] array) {
        if(array.length < 2)
            return array;
        else {
            int splitIndex = (array.length - 1) / 2;
            int[] leftSorted = mergeSort(Arrays.copyOfRange(array, 0, splitIndex + 1));
            int[] rightSorted = mergeSort(Arrays.copyOfRange(array, splitIndex + 1, array.length));
            log("List________", arrayToString(array));
            log("MergeInOrder", arrayToString(leftSorted) + " | " + arrayToString(rightSorted));
            log("Merged______", arrayToString(mergeInOrder(leftSorted, rightSorted)));
            return mergeInOrder(leftSorted, rightSorted);
        }
    }

    private static int[] mergeInOrder(int[] array1, int[] array2) {
        int[] sortedArray = new int[array1.length + array2.length];
        int i = 0;
        int l = 0;
        int r = 0;
        while(l < array1.length && r < array2.length) {
            if(array1[l] < array2[r]) {
                sortedArray[i++] = array1[l++];
            } else {
                sortedArray[i++] = array2[r++];
            }
        }
        // Add leftovers
        while(l < array1.length) {
            sortedArray[i++] = array1[l++];
        }
        while(r < array2.length) {
            sortedArray[i++] = array2[r++];
        }
        return sortedArray;
    }

    // Utils

    private static void swap(ArrayList<Integer> arrayList, int l, int r) {
        int temp = arrayList.get(r);
        arrayList.set(r, arrayList.get(l));
        arrayList.set(l, temp);
    }

    private <T> T[] mergeArrays(T[] array1, T[] array2) {
        T[] newArray = Arrays.copyOf(array1, array1.length + array2.length);
        // Starting at [length] starts you at an index 1 after the final index of array1. (In otherwords, [length] starts you in the first empty bucket) :-)
        for(int i = 0; i < array1.length; i++) {
            newArray[i + array1.length] = array2[i];
        }

        return newArray;
    }


}
