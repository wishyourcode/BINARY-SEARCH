public class rotation_cound {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 3, 4, 5, 6, 7};
        int result = findPivot(arr);
        if (result == -1) {
            System.out.println("No pivot found in the array");
        } else {
            System.out.println("Pivot index is: " + result);
        }
    }
    static int findPivot(int []arr){
        int pivotIndex = findPivotWithDuplicates(arr);
        return pivotIndex +1;
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
