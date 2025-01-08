/*
Ques : Given a non-negative integers representing an elevation(height) map where the width of each bar is 1, compute how much water it can trap after raining.

Logic :

1. edge cases

i. no. of bars
a. Single bar : no water is trapped.
b. 2 bars : no water is trapped as there are no boundries.
no. of bars should be greater than 2.

ii. sorting
If bars are arranged in ascending or descending order than no water is trapped.



2. trapped water = (waterlevel - barlevel)*width
waterlevel : level of water from ground
barlevel : level of bar from ground
width : width of each bar (in this particular ques width is 1)



3. barlevel is given and width may given and in this case width is 1.



4. We just have to find waterlevel it is our main ques.
let understand with some examples

a. 6 2 8 => water level for bar 2 is 6 because if it goes beyond 6 it starts spilling.
b. 8 2 4 => water level for bar 2 is 4 because if it goes beyond 4 it stars spilling.
c. 10 6 2 8 => water level for bar 2 is 8 because we will not consider 6 as left highest because 10 is the left highest bar and 8 is right highest bar we will find minimum of both than it is 8.

overall we conclude :
waterlevel = min(maxLeft , maxRight)
and at last sum of all trappedwater is total trapped water.





5. for finding maxLeft and maxRight we will make two auxiliary array or helper array.
first array is to find maxLeft of each bar and if maxLeft is not there than the value of that bar becomes maxLeft.
second array is to find maxRight of each bar and if maxRight is not there than the value of that bar becomes maxRight.
 */

class TrappedWater
{
    static int trappedWater(int height[])
    {
        int n = height.length;

        // Calculate leftMax -- array
        int leftMax[] = new int[n];
        leftMax[0] = height[0]; // LeftMax of 1st bar is 1st bar itself.
        for(int i=1;i<n;i++)
        {
            leftMax[i] = Math.max(height[i],leftMax[i-1]); // Finding max of value of bar and its previous max value
        }

        // Calculate rightMax -- Array
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1]; // The rightMax of last bar is the last bar itself.
        for(int i=n-2;i>=0;i--)
        {
            rightMax[i] = Math.max(height[i],rightMax[i+1]); // rightMax is the max of the bar's height and its next value.
        }

        // Loop
        int trappedWater = 0;
        for(int i=0;i<n;i++)
        {
            // WaterLevel = min(leftmax , rightmax)
            int waterlevel = Math.min(leftMax[i],rightMax[i]);
            // TrappedWater = waterlevel - height
            trappedWater += waterlevel - height[i];
        }
        return trappedWater;
    }
    public static void main(String[]args)
    {
        int height[] = {4,2,0,6,3,2,5};
        System.out.println(trappedWater(height));
    }
}