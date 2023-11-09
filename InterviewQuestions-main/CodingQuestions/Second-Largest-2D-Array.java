//Humancloud
//Find second largest number in each row

public class SecondLargestInRow {
    public static void main(String[] args) {
        int[][] array = {
            {5, 12, 8, 10},
            {20, 6, 15, 9},
            {25, 22, 18, 30}
        };

        for (int row = 0; row < array.length; row++) {
            int largest = Integer.MIN_VALUE;
            int secondLargest = Integer.MIN_VALUE;

            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] > largest) {
                    secondLargest = largest;
                    largest = array[row][col];
                } else if (array[row][col] > secondLargest && array[row][col] != largest) {
                    secondLargest = array[row][col];
                }
            }
 
            System.out.println("Second largest element in row " + row + ": " + secondLargest);
        }
    }
}
