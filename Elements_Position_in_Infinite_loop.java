public class Elements_Position_in_Infinite_loop {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40, 50, 60, 70, 80, 90};
        int target = 90;
        int result = ans(arr, target);
        if (result == -1) {
            System.out.println("Target not found in the array");
        } else {
            System.out.println("Target found at index: " + result);
        }
    }
    static int ans(int[]arr, int target){
        int start = 0;
        int end = 1; // Simulating an infinite array with a large range
        while(target > arr[end]){
            int newstart = end+1;
            end = end+(end - start+1)*2; // Double the end until target is within range
            start =newstart; 
        }
        return binarySearch(arr, target, start, end);
    }
    static int binarySearch(int[]arr,int target,int start,int end){
        while(start<= end){
            int mid = start+(end - start)/2;
            if(target<arr[mid]){
                end = mid - 1;
            } else if(target > arr[mid]){
                start = mid + 1;
            } else {
                return mid; // Target found
            }
        }
        return -1;
    }
}
