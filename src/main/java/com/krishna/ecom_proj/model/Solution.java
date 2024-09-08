package com.krishna.ecom_proj.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static int getMinScore(List<Integer> watch_history, int series1, int series2) {
        // 1. Initial Setup
        int n = watch_history.size();  // Get the size of the watch_history list
        int minScore = Integer.MAX_VALUE;  // Initialize minScore with a very large value

        int left = 0;  // Left pointer for the sliding window
        Set<Integer> set = new HashSet<>();  // A set to store distinct series in the current window

        // 2. Sliding Window Loop
        for (int right = 0; right < n; right++) {  // Right pointer for the sliding window
            set.add(watch_history.get(right));  // Add the series at the right pointer to the set

            // 3. Check if Current Window is Valid
            while (set.contains(series1) && set.contains(series2)) {  // Both series1 and series2 are in the current window
                minScore = Math.min(minScore, set.size());  // Update minScore with the size of the current set (number of distinct series)

                // 4. Try to Shrink the Window
                set.remove(watch_history.get(left));  // Remove the series at the left pointer from the set
                if (left < right && !set.contains(watch_history.get(left))) {  // If removing it made the set invalid (missing series), move left pointer
                    left++;
                    set.add(watch_history.get(left));  // Re-add the series at the new left position if necessary
                } else {
                    left++;  // Otherwise, just move the left pointer
                }
            }
        }

        // 5. Return Result
        return minScore;  // Return the minimum watch score found
    }

    public static void main(String[] args) {
        List<Integer> watch_history = List.of(1, 3, 2, 2, 5, 2);  // Sample watch history
        int series1 = 1;  // First series to include in subarray
        int series2 = 5;  // Second series to include in subarray

        System.out.println(getMinScore(watch_history, series1, series2));  // Output the result, expected 3
    }
}
