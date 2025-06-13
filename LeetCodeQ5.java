public class LeetCodeQ5 {
    public static void main(String[] args) {
        int[] arr = {0, 1,3,5,7,9,10,8,6,4,2, 0};
        int result = peakIndexInMountainArray(arr);
        if(result == -1) {
            System.out.println("No peak found in the mountain array");
        } else {
            System.out.println("Peak index is: " + result);
        }
    }
    // 852. Peak Index in a Mountain Array
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start<= end){
            int mid = start + (end - start) / 2;
           if(arr[mid] > arr[mid+1] && arr[mid]>arr[mid-1]){
            return mid; // Peak found
           }else if(arr[mid]> arr[mid+1]){
            end = mid - 1; // Move left
        } else {
            start = mid + 1; // Move right
        }
        }
        return 0;
    }
}
