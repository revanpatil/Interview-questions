/*Given an array [2,3,5,7,8,8,5,4] I need to find maximum number with minimum frequency

To find the maximum number with the minimum frequency in an array, you can follow these steps:

1. Iterate through the array and create a `HashMap` to store the frequency of each element.
2. Find the minimum frequency value by iterating through the `HashMap`.
3. Iterate through the `HashMap` again to find the maximum number that corresponds to the minimum frequency.

Here's the Java code to achieve this:
*/

import java.util.HashMap;

public class MaxNumberWithMinFrequency {
    public static void main(String[] args) {
        int[] array = {2, 3, 5, 7, 8, 8, 5, 4};
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int minFrequency = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;

        // Find the minimum frequency
        for (int frequency : frequencyMap.values()) {
            minFrequency = Math.min(minFrequency, frequency);
        }

        // Find the maximum number with the minimum frequency
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.get(num) == minFrequency && num > maxNumber) {
                maxNumber = num;
            }
        }

        System.out.println("Maximum number with minimum frequency: " + maxNumber);
    }
}
/*
For the given array `[2, 3, 5, 7, 8, 8, 5, 4]`, the output of the above code will be:

```
Maximum number with minimum frequency: 7
```

Explanation: The number `7` has the minimum frequency (1) among all numbers in the array.
  */
