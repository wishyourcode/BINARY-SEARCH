public class orderAgnosticBS {
    public static void main(String[] args) {
        int [] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 6;
        int result = orderAgnostic_BS(arr2, target);
        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
    static int orderAgnostic_BS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end]; // Determine if the array is sorted in ascending order
        while (start <= end) {
                int mid = start + (end - start) / 2;
                if (target == arr[mid]) {
                    return mid;
                }
                if(isAsc){
                    if (target > arr[mid]){
                        start =mid + 1;
                    } else{
                        end = mid - 1;
                    }
                }
                else{
                    if (target < arr[mid]){
                        start =mid + 1;
                    } else{
                        end = mid - 1;
                    }
                }
        }
        return -1;
    }
}
