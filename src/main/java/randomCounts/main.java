package randomCounts;

import static randomCounts.randomCounts.temp;

public class main {

    public static void main(String[] args) throws InterruptedException {
        //Random counts
        //-----------------------------------------------------------------------------------------------------

        SomeSort ob = new SomeSort();
        int[] rCounts = new int[10000000];
        for (int i = 0; i < rCounts.length; i++) {
            int temp2 = temp.nextInt(10000000);
            rCounts[i] = temp2;
        }
//        ob.printArray(rCounts);


        Long start = System.currentTimeMillis();


//        ob.bubbleSort(rCounts);
//        ob.recursiveBubbleSort(rCounts,rCounts.length); /*Stack Overflow*/
//        ob.insertionSort(rCounts);
//        ob.selectionSort(rCounts);
//        ob.mergeSort(rCounts, 0, rCounts.length - 1);
//        ob.quickSort(rCounts,0,rCounts.length-1);
//        ob.heapSort(rCounts);
//        ob.countingSort(rCounts);
//        ob.radixSort(rCounts);
//        ob.bucketSort(rCounts);
//        ob.shellSort(rCounts);
//        ob.timSort(rCounts);
//        ob.combSort(rCounts);
//        ob.pigeonholeSort(rCounts);




        Long stop = System.currentTimeMillis();
//        ob.printArray(rCounts);
        System.out.println(stop - start + " ms");
//        System.out.println("Distincts : " + ob.countDistinct(rCounts));


        //-----------------------------------------------------------------------------------------------------

    }

}