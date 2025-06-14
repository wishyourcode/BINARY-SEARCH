public class BS2DSearch {
    public static void main(String[] args) {
        int [][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int target = 10;
        int [] result = search(matrix, target);
        if (result[0] != -1) {
            System.out.println("Element found at: (" + result[0] + ", " + result[1] + ")");
        } else {
            System.out.println("Element not found");
        }
        
    }
    static int [] search(int [][] matrix, int target){
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if (matrix[row][col] == target){
                return new int[] {row, col};
            }
            else if (matrix[row][col] < target){
                row++;
            } else {
                col--;
            }
        }return new int[] {-1, -1};
    } 
}
