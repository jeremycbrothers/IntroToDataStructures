import java.util.Random;

/**
* @author Charley Sheaffer
* @version 11/6/2018
*/

public class TimedSorts {

    public static void main(String [] args) {
    
        Random gen = new Random();
        int length;
        long startTime = 0;
        long endTime = 0;
        
        if (args.length != 2) {
            System.out.println("Usage: java TimedSorts <sortname> <n>");
            System.exit(0);
        }
        String sortType = args[0];
        length = Integer.parseInt(args[1]);
        long[] startArray = new long[length];        
        for (int i=0; i<length; i++) {
            startArray[i] = gen.nextLong();
        }

        long[] array = copyArray(startArray);
        System.out.println("Starting " + sortType + " sort.");
        System.gc();
        
        switch (sortType) {
            case "bubble"        : startTime = System.nanoTime();
                                   bubbleSort(array);
                                   endTime = System.nanoTime();
                                   break;
            case "selection"     : startTime = System.nanoTime();
                                   selectionSort(array);
                                   endTime = System.nanoTime();
                                   break;
            case "insertion"     : startTime = System.nanoTime();
                                   insertionSort(array);
                                   endTime = System.nanoTime();
                                   ;
            case "merge"         : startTime = System.nanoTime();
                                   mergeSort(array);
                                   endTime = System.nanoTime();
                                   break;
            case "quick"         : startTime = System.nanoTime();
                                   quickSort(array);
                                   endTime = System.nanoTime();
                                   break;
            default              : System.out.println("Sorry, don't know that one.");
                                   break;
        }
        
        System.out.println(sortType + " sort ran in " 
                        + ((endTime - startTime) / 1000000.0) + " milliseconds.\n");
        printArray(array);
    }
    
    public static void selectionSort(long[] array) {
        long temp;
        int largestLoc;
        for (int i=array.length-1; i>0; i--) {
            largestLoc = 0;
            for (int j=1; j<=i; j++) {
                if (array[j] > array[largestLoc])
                    largestLoc = j;
            }
            temp = array[i];
            array[i] = array[largestLoc];
            array[largestLoc] = temp;
        }
    }
       
    public static void insertionSort(long[] array) {
        for (int i=1; i<array.length; i++) {
            long current = array[i];
            int j=i-1;
            while (j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }
       
    public static void bubbleSort(long[] array) {
        long temp;
        int lastSwap;
        int end = array.length - 1;
        while (end > 1) {
            lastSwap = 0;
            for (int j=0; j<end; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    lastSwap = j + 1;
                }
            }
            end = lastSwap;
        }
    }
    
    public static void mergeSort(long[] array) {
        long[] tempArray = mergeSort(array, 0, array.length-1);
        for (int i=0; i<array.length; i++) 
            array[i] = tempArray[i];
    }
    
    private static long[] mergeSort(long[] array, int start, int end) {
         long[] mergedArray = new long[2];
         if (start < end) {
            mergedArray = merge(mergeSort(array, start, (start+end)/2),
                                mergeSort(array, (start+end)/2 + 1, end));
         }
         else if (start == end) {
            mergedArray[0] = array[start];
            mergedArray[1] = Long.MAX_VALUE;
         }
         return mergedArray;
    }
    
    private static long[] merge(long[] left, long[] right) {
        long[] tempArray = new long[left.length + right.length - 1];
        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        
        while (index < tempArray.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                tempArray[index] = left[leftIndex];
                leftIndex++;
            }
            else {
                tempArray[index] = right[rightIndex];
                rightIndex++;
            }
            index++;
        }
        return tempArray;
    }

    public static void quickSort(long[] array) {
        quickSort(array, 0, array.length-1);
    }
    
    private static void quickSort(long[] array, int start, int end) {
        if (start < end) {
            int split = partition(array, start, end);
            quickSort(array, start, split-1);
            quickSort(array, split+1, end);
        }
    }
    
    private static int partition(long[] array, int start, int end) {
        long temp;
        int originalStart = start;
        long pivot = array[start];
        while (start < end) {
            while (array[start] <= pivot && start < end) start++;
            while (array[end] > pivot && start <= end) end--;
            if (start < end) {
                temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
        temp = array[originalStart];
        array[originalStart] = array[end];
        array[end] = temp;
        return end;
    }
    
    public static long[] copyArray(long[] fromArray) {
        long[] toArray = new long[fromArray.length];
        for (int i=0; i<fromArray.length; i++)
            toArray[i] = fromArray[i];
        return toArray;
    }
    
    public static void printArray(long[] array) {
        if (array.length > 100 ){
            System.out.println("Array too large to print!");
        }
        else {
            System.out.print("[");
            for (int i=0; i<array.length-1; i++)
                System.out.print(array[i] + ", ");
            System.out.println(array[array.length-1] + "]");
        }
    }
}