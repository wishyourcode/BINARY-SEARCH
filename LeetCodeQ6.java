public class LeetCodeQ6 {
    public static void main(String[] args) {
        // 162. Find Peak Element
        int[] arr = {1, 2,3, 1, 2, 3, 2, 1};
        int solution = findPeakElement(arr);
        if (solution == -1) {
            System.out.println("No peak found in the array");
        } else {
            System.out.println("Peak index is: " + solution);
        }
    }
        static int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                 end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
