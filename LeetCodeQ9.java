public class LeetCodeQ9 {
    public static void main(String[] args) {
        int[] nums = {11,13,15,17};
        int result = findMin(nums);
        System.out.println("The minimum element in the rotated sorted array is: " + result);
    }
    static int findMin(int[] nums) {
        int pivot = findPivot(nums);
        while(pivot<= nums.length -1){
            return nums[pivot +1];
        }
        return nums[0]; // If no pivot found, return first element
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
}
