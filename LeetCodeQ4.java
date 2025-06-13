public class LeetCodeQ4 {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] result = searchRange(nums, target);
        if (result[0] == -1 && result[1] == -1) {
            System.out.println("Target not found in the array");
        } else {
            System.out.println("Target found at range: [" + result[0] + ", " + result[1] + "]");
        }
    }

    static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                int first = mid;
                int last = mid;
                // Find first occurrence
                while (first >= 0 && nums[first] == target) {
                    first--;
                }
                while (last < nums.length && nums[last] == target) {
                    last++;
                }
                return new int[] { first + 1, last - 1 };
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[] { -1, -1 }; // If target is not found
    }
}
