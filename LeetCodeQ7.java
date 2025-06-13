public class LeetCodeQ7 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 4, 2, 1};
        int target = 5;
        int result = peakIndexInMountainArray(arr);
        int searchResult = binarySearch(arr, target, 0, result);
        if (searchResult == -1) {
            System.out.println("Target not found in the mountain array");
        } else {
            System.out.println("Target found at index: " + searchResult);
        }
    }
    static int peakIndexInMountainArray(int[] arr) {
            int start = 0;
            int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]) {
                return mid; // Peak found
            } else if (arr[mid] > arr[mid + 1]) {
                end = mid; // Move left
            } else {
                start = mid + 1; // Move right
            }
        }
        return -1; // Target not found
    }
    static int binarySearch(int [] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid; // Target found
            }
        }
        return -1; // Target not found
    }
}
