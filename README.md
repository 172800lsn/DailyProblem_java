# DailyProblem with java language
## Thougth process for sovling dynamic programming problems
### 1.Fibonacci-type problems
The typical feature of Fibonacci-typy problems is that the status(like point) is decided by the former 2-3 statuses
and their next action. So we can find the recursive expression first, then define the dp array, and find the side condition
which is both difficult and falliable.

- One typical example 'Min Cost Climbing Stairs':
```
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        for(int i = 2;i <=n;i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2]);
        }
        return dp[n];
    }
}
```
The time complexity is usually O(N). N is the length of array.
While raversing an array, we decide whether each element is in our dynamic stragety.
