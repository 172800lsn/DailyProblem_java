class Solution {
    static final int MOD = 1000000007;
    public int possibleStringCount(String word, int k) {
        int len = word.length();
        int count = 1;

    }
}
import java.util.*;

class Solution {
    static final int MOD = 1_000_000_7;
    List<Integer> compressed = new ArrayList<>();
    int k;
    int totalWays = 0;

    public int possibleStringCount(String word, int k) {
        this.k = k;
        compress(word);
        dfs(0, 0, 1);
        return totalWays;
    }

    // 将字符串压缩为每段字符的连续重复次数，比如"aabbcc" -> [2,2,2]
    private void compress(String word) {
        int i = 0;
        while (i < word.length()) {
            int count = 1;
            while (i + count < word.length() && word.charAt(i + count) == word.charAt(i)) {
                count++;
            }
            compressed.add(count);
            i += count;
        }
    }

    // dfs遍历所有分段情况：index 当前字符段，len 当前构造字符串长度，ways 当前路径下的构造方式数
    private void dfs(int index, int len, long ways) {
        if (index == compressed.size()) {
            if (len >= k) {
                totalWays = (int)((totalWays + ways) % MOD);
            }
            return;
        }

        int repeat = compressed.get(index);
        // 枚举当前字符段的可能重复次数
        for (int times = 1; times <= repeat; times++) {
            if (repeat % times == 0) {import java.util.*;

                class Solution {

                    private static final int MOD = 1_000_000_7;

                    /**
                     * 统计 Alice 原本可能输入的字符串数量（长度 ≥ k），
                     * 使得经过“同一字符可能被连续多次输入”后能得到 word。
                     *
                     * @param word 最终出现在屏幕上的字符串
                     * @param k    原始字符串的最小长度
                     * @return     满足条件的方案数 (mod 1e9+7)
                     */
                    public int possibleStringCount(String word, int k) {
                        // 1️⃣  把 word 进行 RLE 压缩，得到每段连续字符出现次数 r_i
                        List<Integer> runs = new ArrayList<>();
                        for (int i = 0, n = word.length(); i < n; ) {
                            int j = i;
                            while (j < n && word.charAt(j) == word.charAt(i)) j++;
                            runs.add(j - i);          // r_i = 连续段长度
                            i = j;
                        }
                        int m = runs.size();          // 段数 == 原串最少长度

        /* 2️⃣  先算“总方案数”：每段可以取 [1 .. r_i] 个字符，彼此独立
                ==> 总方案数 = ∏ r_i                       */
                        long total = 1L;
                        for (int r : runs) total = (total * r) % MOD;

                        // 如果 k ≤ m，所有方案都合法，直接返回
                        if (k <= m) return (int) total;

        /* 3️⃣  设 extra_i = r_i - 1 (每段在保底 1 个字符基础上还能额外删去的数量)
                现在问题变为：在数组 extra_i 中选 x_i ∈ [0 .. extra_i]，
                使 Σ x_i ≥ (k - m)。要统计满足该不等式的组合数。
                令 t = k - m > 0，求解：
                    Count( Σ x_i ≥ t ) = All  -  Count( Σ x_i ≤ t-1 )
                右边那项只需做“带上界”的背包即可，且背包容量 ≤ t-1。           */
                        int t = k - m;                       // 需要的“额外长度”
                        int cap = t - 1;                     // 我们只关心 0..cap 的方案数
                        if (cap < 0) cap = 0;                // 理论上不会走到这里

                        int[] dp = new int[cap + 1];         // dp[j] = 处理到当前段时，额外长度恰为 j 的方案数
                        dp[0] = 1;                           // 初始：一个段都没处理，额外长度 0 的方案数为 1

                        for (int r : runs) {
                            int a = r - 1;                   // 当前段可删去的最大 extra 数
                            int[] ndp = new int[cap + 1];
                            long window = 0;                 // 用滑动窗口优化「上界背包」
                            int left = 0;
                            for (int j = 0; j <= cap; j++) {
                                window = (window + dp[j]) % MOD;           // 窗口右端加入 dp[j]
                                if (j - a - 1 >= 0) {                      // 超出窗口宽度 a 时滑出左端
                                    window = (window - dp[j - a - 1] + MOD) % MOD;
                                }
                                ndp[j] = (int) window;                     // ndp[j] = Σ_{t=0..a} dp[j - t]
                            }
                            dp = ndp;                                      // 状态迭代
                        }

                        long notEnough = 0;                                // Σ_{j=0}^{t-1} dp[j]
                        for (int j = 0; j <= cap; j++) {
                            notEnough = (notEnough + dp[j]) % MOD;
                        }

                        long ans = (total - notEnough + MOD) % MOD;         // 防止负数再取一次 MOD
                        return (int) ans;
                    }
                }

                int addedLength = repeat / times; // 表示当前字符段原始字符长度为1，则重复times次
                dfs(index + 1, len + 1, (ways * 1L) % MOD);  // 每个合法times对应一种构造方式
            }
        }
    }
}
