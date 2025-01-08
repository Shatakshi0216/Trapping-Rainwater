Trapping Rainwater Problem

Problem Description
Given a non-negative array of integers representing an elevation map where the width of each bar is 1, compute how much water can be trapped after raining.

Example:
For the elevation map height[] = {4, 2, 0, 6, 3, 2, 5}, the total trapped water is 9.

Logic & Approach
Edge Cases
Number of Bars:
Single bar: No water is trapped.
Two bars: No water is trapped as there are no boundaries.
At least 3 bars are required to trap water.
Sorting:
If bars are sorted in ascending or descending order, no water will be trapped as there are no boundaries to hold the water.
Core Formula
Trapped Water for each bar is given by:



Water Level: The minimum of the maximum height on the left and right of the current bar.
Bar Level: The height of the current bar.
Width: Width of each bar (given as 1 in this problem).
The total trapped water is the sum of trapped water for all bars.

Steps to Solve
Water Level:
For each bar, calculate maxLeft (maximum height to the left) and maxRight (maximum height to the right).

Use the formula:

Trapped Water:
For each bar, calculate trapped water as:


Auxiliary Arrays:
Use two auxiliary arrays, leftMax[] and rightMax[], to store the maximum heights on the left and right of each bar.

leftMax[i]: Maximum height from the start to index i.

rightMax[i]: Maximum height from index i to the end.
