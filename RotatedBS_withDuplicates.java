public class RotatedBS_withDuplicates {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2, 2, 3 };
        int target = 2;
        int result = search(arr, target);
        if (result == -1) {
            System.out.println("Target not found in the rotated sorted array");
        } else {
            System.out.println("Target found at index: " + result);
        }
    }
    // 81. Search in Rotated Sorted Array II
    static int search(int[] nums, int target) {
        int pivot = findPivat_inDuplicates(nums);
        if (pivot == -1) {
            // Array is not rotated, perform normal binary search
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        if (target ==nums[pivot]){
            return pivot; // Target found at pivot
        } else if (target > nums[0]){
            // Search in the left side of the pivot
            return binarySearch(nums, target, 0, pivot - 1);
        }
            // Search in the right side of the pivot
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }
    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            }
            return mid;
        }
        return -1;
    }

    static int findPivat_inDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1] && mid < end) {
                return mid; // Pivot found
            }
            if (arr[mid] < arr[mid - 1] && mid > start) {
                return mid - 1; // Pivot found
            }
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // If duplicates are present, we cannot determine the pivot
                // We can skip the first and last elements
                start++;
                end--;
            } else if (arr[start] <= arr[mid]) {
                start = mid + 1; // Move right
            } else {
                end = mid - 1; // Move left
            }
        }
        return -1;
    }
}
