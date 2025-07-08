# Daily Problem (Java)

## Thought Process for Solving Dynamic Programming Problems

### 1. Fibonacci-type Problems

The hallmark of Fibonacci-type problems is that the current state (for example, a position on a staircase) depends only on the previous two – three states and their associated actions. The usual workflow is therefore:

1. **Derive the recurrence relation.**
2. **Define the DP array** (or use rolling variables to save space).
3. **Specify the boundary conditions**, which are often the trickiest part and the main source of bugs.

---

#### Classic Example – *Min Cost Climbing Stairs*

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],
                             dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }v
}
```
The time complexity is O(n), where n is the length of the array. 
While traversing the array we decide, for each step, whether 
the element participates in our dynamic-programming strategy.

You can further reduce the space to O(1) by 
keeping only the last two values instead of the entire dp array