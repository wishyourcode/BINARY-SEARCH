public class LeetCode10 {
public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 8;
        boolean result = search(nums, target);
        System.out.println("Target " + target + " found: " + result);
    }
    static boolean search(int[] nums, int target) {
        int pivot = findPivotWithDuplicates(nums);
        if (pivot == -1) {
            // Array is not rotated, perform normal binary search
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        if (target == nums[pivot]) {
            return true; // Target found at pivot
        } else if (target >= nums[0]) {
            // Search in the left side of the pivot
            return binarySearch(nums, target, 0, pivot - 1);
        }
        // Search in the right side of the pivot
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }
    static boolean binarySearch(int[] arr, int target, int start, int end) {
       while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            // If elements at start, mid, end are equal, skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                if (end > start && arr[end - 1] > arr[end]) {
                    return end - 1;
                }
                end--;
            } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}