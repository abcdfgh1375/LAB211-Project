package Controller;

import Model.Element;
import View.Menu;
import Controller.SortController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SearchController extends Menu {

    int[] array;
    SortController sort;

    public SearchController() {
        super("\nSearch Management", Arrays.asList(new String[]{"Create random"
            + " array", "Linear Search", "Binary Search", "Exit"}));
    }

    public int[] takeSortedArray(int[] arr) {
        SortController sort = new SortController();
        arr = sort.displaySortedArray(arr);
        return arr;
    }

    public int inputKey() {
        Element e = new Element();
        int key = e.getIntFromInput("Enter search value");
        return key;
    }

    public void LinearSearch(int[] arr) {
        int key = inputKey();
        arr = takeSortedArray(arr);
        int i;
        try {
            boolean found = false;
            for (i = 0; i < arr.length; i++) {
                if (key == arr[i]) {
                    System.out.println("Found " + key + " at index: " + i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("There is no " + key + " in array.");
            }
        } catch (NullPointerException e) {
            System.out.println("There is no array. Generate a new array first.");
        }
    }

    public void BinarySearch(int[] arr, int key, int low, int high) {
        arr = takeSortedArray(arr);
        class LocalBinarySearch {

            void BinarySearchMini(int[] arr, int key, int low, int high) {
                try {
                    if (low <= high) {
                        int mid = (low + high) / 2;
                        int pivot = array[mid];
                        if (pivot == key) {
                            System.out.println("Found " + key + " at index: " + mid);
                        } else if (pivot > key) {
                            BinarySearchMini(arr, key, low, mid - 1);
                        } else if (pivot < key) {
                            BinarySearchMini(arr, key, mid + 1, high);
                        }
                    } else {
                        System.out.println("There is no " + key + " in array");
                    }
                } catch (NullPointerException e) {
                    System.out.println("There is no array. Generate a new array first.");
                }
            }
        }
        LocalBinarySearch var = new LocalBinarySearch();
        var.BinarySearchMini(arr, key, low, high);
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                sort = new SortController();
                array = sort.createRandomArray();
                System.out.println("Unsorted array: " + Arrays.toString(array));
                break;
            case 2:
                LinearSearch(array);
                break;
            case 3:
                int key = inputKey();
                BinarySearch(array, key, 0, array.length - 1);
                break;
            case 4:
                System.err.println("Exited. Bye bye!");
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
        }
    }

}
