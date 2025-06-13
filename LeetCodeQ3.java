public class LeetCodeQ3 {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'g';
        int result = nextGreatestLetter(letters, target);
        if (result == -1) {
            System.out.println("No greater letter found");
        } else {
            System.out.println("Next greatest letter is: " + letters[result]);
           }
        }
// LeetCode Question 744: Find Smallest Letter Greater Than Target
           static int nextGreatestLetter(char[] letters, char target){
            int start =0;
            int end = letters.length-1;
            while(start <= end){
                int mid = start + (end -start)/2;
                if (target < letters[mid]) {
                    end = mid - 1;
                } else if (target > letters[mid]) {
                    start = mid+1;
                }
                }
            return start;
           }
}

