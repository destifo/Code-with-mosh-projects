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


    public void selectionSort(int[] array){
        for (int i = 0; i < array.length; i++){
            int smallestNumber = array[i];
            int smallestNumberIndex = i;
            for (int j = array.length - 1; j >= i; j--){
                if (array[j] < smallestNumber){
                    smallestNumber = array[j];
                    smallestNumberIndex = j;
                }
            }
            array[smallestNumberIndex] = array[i];
            array[i] = smallestNumber;
        }
    }

    public void modifiedSelectionSort(int[] array){
        for (int i = 0; i < array.length; i++){
            int minIndex = findMinIndex(array, i);
            swap(array, i, minIndex);
        }
    }

    public int findMinIndex(int[] array,int i){
        int minIndex = i;
        for (int j = array.length - 1; j >= i; j--)
            if (array[j] < array[minIndex])
                minIndex = j;
        return minIndex;
    }

    public void mergeSort(int[] array){

        if (array.length  < 2)
            return;

        int middleIndex = array.length/2;

        int[] left = new int[middleIndex];
        for (int i = 0; i < middleIndex; i++)
            left[i] = array[i];
        
        int rightLength = array.length - middleIndex;
        int[] right = new int[rightLength];
        for (int i = 0; i < rightLength; i++){
            right[i] = array[i + middleIndex];
        }

        mergeSort(left);
        mergeSort(right);

        merge(left, right, array);

    }

    private void merge(int[] firstArray, int[] secondArray, int[] combinedArray){
        int i = 0, j = 0, k = 0;

        while (i < firstArray.length && j < secondArray.length){
            if (firstArray[i] <= secondArray[j])
                combinedArray[k++] = firstArray[i++];
            else
                combinedArray[k++] = secondArray[j++];
        }
        while (i < firstArray.length)
            combinedArray[k++] = firstArray[i++];
        while (j < secondArray.length)
            combinedArray[k++] = secondArray[j++];
    }

    public void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);
    }


    private void quickSort(int[] array, int startIndex, int endIndex){
        if (startIndex >= endIndex)
            return;
        int boundary = partition(array, startIndex, endIndex);
        quickSort(array, startIndex, boundary -1);
        quickSort(array, boundary + 1, endIndex);
    }


    private int partition(int[] array, int start, int end){
        int pivot = (start + end)/2;
        int boundary = start - 1;
        for (int i = start; i <= end; i++)
            if (array[i] < array[pivot])
                swap(array, ++boundary, i);
        swap(array, ++boundary, pivot);
        return boundary;
    }


    public void countingSort(int[] array, int max){
        int[] count = new int[max++];
        for (int num : array){
            count[num]++;
        }

        int k = 0;
        for (int i = 0; i < count.length; i++){
            for (int j = 0; j < count[i]; j++){
                array[k] = i;
            }
        }
    }

    public void bucketSort(int[] array){
        
    }

}