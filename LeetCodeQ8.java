public class LeetCodeQ8 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        // 33. Search in Rotated Sorted Array
        int result = search(arr, target);
        if (result == -1) {
            System.out.println("Target not found in the rotated sorted array");
        } else {
            System.out.println("Target found at index: " + result);
        }
    }
    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (pivot == -1) {
            // Array is not rotated, perform normal binary search
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        if(target == nums[pivot]) {
            return pivot; // Target found at pivot
        }else if(target >= nums[0] && target <= nums[pivot]) {
            // Search in the left side of the pivot
            return binarySearch(nums, target, 0, pivot - 1);
        }
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
        int mid = start+ (end - start) / 2;
        if(mid<end && arr[mid]>arr[mid+1]){
            return mid; // Pivot found
        }else if(mid > start && arr[mid]<arr[mid-1]){
            return mid - 1; // Pivot found
        }else if(arr[mid]<= arr[start]){
            end = mid - 1; // Move right
        } else {
            start = mid + 1; // Move left
        }
    }
        return -1;
    }
    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid; // Target found
            } else if (target < arr[mid]) {
                end = mid - 1; // Move left
            } else {
                start = mid + 1; // Move right
            }
        }
        
        
        
        return -1;
    }
}
