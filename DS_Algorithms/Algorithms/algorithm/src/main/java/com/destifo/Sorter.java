package com.destifo;

public class Sorter{
    public void bubbleSorter(int[] array){
        //the next bigger num bubbles up to the last every turn
        //that's why it's called bubble sort
        //best: O(n), worst: O(n^2)
        boolean isSorted;
        int length = array.length;
        for (int i = 0; i < length; i++){//O(1) if the array is sorted(best case scenario)
            isSorted = true;
            for (int j = 0; j < length - 1 - i; j++)//O(n) the loop runs at least one time to compare the numbers, so even the best case is O(n)
                if (array[j] > array[j + 1]){
                    isSorted = false;
                    swap(array, j, j + 1);
                }
            if (isSorted){
                return;
            }
        }
    }

    private void swap(int[] array, int firstIndex, int secondIndex){
        var temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }


    public void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++){//iterate through each element of the array
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current){//compare the current value with the previous one and shift right if it is larger as long as we are in the index range
                array[j + 1] = array[j];
                j--;
            } 
            array[j + 1] = current;
        }

    }

    private void shift(int[] array, int numberIndex, int startingIndex){
        for (int i = numberIndex; i <= startingIndex; i--){
            array[numberIndex] = array[numberIndex - 1];
        }
    }

}