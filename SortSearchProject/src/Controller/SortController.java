package Controller;

import Model.Element;
import View.Menu;
import Controller.SearchController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import Model.Element;

public class SortController extends Menu {

    private int[] array;

    public SortController() {
        super("\nSort Managerment System",
                Arrays.asList(new String[]{"Create random array", "Bubble sort",
            "Quick sort", "Exit"}));
    }

    public int[] createRandomArray() {
        Element e = new Element();
        int size = e.getPositiveIntFromInput("Enter number of array");
        array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            do {
                array[i] = random.nextInt(20);
                flag = false;
                for (int j = 0; j < i; j++) {
                    if (array[j] == array[i]) {
                        flag = true;
                        break;
                    }
                }
            } while (flag);
        }
        return array;
    }

    public int[] BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public void swap(int[] arr, int index1, int index2) {
        if (index1 >= 0 && index1 < arr.length && index2 >= 0 && index2 < arr.length) {
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        } else {
            System.out.println("Invalid indices");
        }
    }

    public int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot);
            quickSort(arr, pivot + 1, high);
        }
        return arr;
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) {
                return j;
            }
            swap(arr, i, j);
        }
    }

    public int[] displaySortedArray(int[] arrayUnsort) {
        array = quickSort(arrayUnsort, 0, arrayUnsort.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));
        return array;
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                createRandomArray();
                System.out.println("Unsorted array: " + Arrays.toString(array));
                break;
            case 2:
                if (array != null) {
                    System.out.println("Sorted array: " + Arrays.toString(BubbleSort(array)));
                } else {
                    System.out.println("Please generate a new array first !!!");
                }
                break;
            case 3:
                if (array != null) {
                    quickSort(array, 0, array.length - 1);
                    System.out.println("Array sorted using quick sort ");
                    System.out.println("Sorted array: " + Arrays.toString(array));
                } else {
                    System.out.println("Please generate an array first.");
                }
                break;
            case 4:
                System.err.println("Exited. Bye bye!");
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
        }
    }
}
